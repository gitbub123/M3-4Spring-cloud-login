package com.lagou.edu.service.impl;

import com.lagou.edu.dao.LagouTokenDao;
import com.lagou.edu.dao.LagouUserDao;
import com.lagou.edu.pojo.LagouToken;
import com.lagou.edu.pojo.LagouUser;
import com.lagou.edu.service.AuthCodeServiceFeignClient;
import com.lagou.edu.service.LagouUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author tudedong
 * @description
 * @date 2020-07-05 14:43:50
 */
@Service
public class LagouUserServiceImpl implements LagouUserService {

    @Autowired
    private LagouUserDao lagouUserDao;

    @Autowired
    private LagouTokenDao lagouTokenDao;

    @Autowired
    private AuthCodeServiceFeignClient authCodeServiceFeignClient;

    @Override
    public LagouToken register(String email, String password, String code) {

        //注册前校验：1.是否已注册；2用数据库保存的验证码和从邮箱获得的输入验证码进行比对,在10分钟内有效
        if(!isRegistered(email) && authCodeServiceFeignClient.validateAuthCode(email, code) == 0){

            //1.保存注册信息
            LagouUser lagouUser = new LagouUser();
            lagouUser.setEmail(email);
            lagouUser.setPassword(password);
            lagouUser.setCreatetime(new Date());
            lagouUser.setLogintime(new Date());
            lagouUserDao.save(lagouUser);

            //2.注册成功后，根据<用户邮箱+密码>生成token，用UUID模拟
            String tokenText = email + password;
            UUID uuid = UUID.nameUUIDFromBytes(tokenText.getBytes());

            LagouToken token = new LagouToken();
            token.setEmail(email);
            token.setToken(uuid.toString());
            return lagouTokenDao.save(token);
        }
        return null;

    }

    @Override
    public boolean isRegistered(String email) {
        LagouUser lagouUser= lagouUserDao.findFirstByEmail(email);
        return lagouUser==null?false:true;
    }

    @Override
    public LagouToken login(String email, String password) {

        LagouUser lagouUser = lagouUserDao.findFirstByEmail(email);
        //已注册
        if (lagouUser != null && lagouUser.getPassword().equalsIgnoreCase(password)) {
            lagouUser.setLogintime(new Date());
            lagouUserDao.save(lagouUser);

            String tokenText = email + password;
            UUID uuid = UUID.nameUUIDFromBytes(tokenText.getBytes());

            LagouToken token = new LagouToken();
            token.setEmail(email);
            token.setToken(uuid.toString());
            return lagouTokenDao.save(token);
        }
        return null;
    }

    @Override
    public String getEmailByToken(String token) {
        LagouToken lagouToken = lagouTokenDao.findFirstByToken(token);
        return token == null ? "NOT FOUND" : lagouToken.getEmail();
    }
}
