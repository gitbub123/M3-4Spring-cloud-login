package com.lagou.edu.filter;

import com.lagou.edu.service.UserServiceGateWayFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author tudedong
 * @description 统一认证filter
 * @date 2020-07-05 23:10:39
 */
@Component
public class TokenGlobalFilter implements GlobalFilter, Ordered {

    /**
     * 思路：对于注册和登录请求放行，其他请求进行token验证
     */

    @Autowired
    private UserServiceGateWayFeignClient userServiceFeignClient;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // 从上下文中取出request和response对象
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        //获取每次请求的路径
        String path = request.getURI().getPath();

        if(!path.startsWith("/api/user/") && !path.startsWith("/api/code/")){
            //如果不是/api/user/请求或/api/code/请求则进行token验证
            List<HttpCookie> tokenList = request.getCookies().get("token");
            boolean flag = false;
            if(CollectionUtils.isEmpty(tokenList)){
                flag = true;
            }else{
                HttpCookie httpCookie = tokenList.get(0);
                String value = httpCookie.getValue();
                //根据token去获取对应的登录邮箱
                String info = userServiceFeignClient.info(value);
                if("NOT FOUND".equals(info)){
                    flag = true;
                }
            }
            //验证不通过重定向到登录页面
            if(flag){
                //重定向(redirect)到登录页面
                String url = "/static/login.html";
                //303状态码表示由于请求对应的资源存在着另一个URI，应使用GET方法定向获取请求的资源
                response.setStatusCode(HttpStatus.SEE_OTHER);
                response.getHeaders().set(HttpHeaders.LOCATION, url);
                return response.setComplete();
            }
        }
        //如果是/api/user/请求或/api/code/请求放行
        // 合法请求，放行，执行后续的过滤器
        return chain.filter(exchange);

    }

    /**
     * 返回值表示当前过滤器的顺序(优先级)，数值越小，优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
