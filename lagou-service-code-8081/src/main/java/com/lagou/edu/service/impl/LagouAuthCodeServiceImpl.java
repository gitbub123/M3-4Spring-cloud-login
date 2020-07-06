package com.lagou.edu.service.impl;

import com.lagou.edu.dao.LagouAuthCodeDao;
import com.lagou.edu.pojo.LagouAuthCode;
import com.lagou.edu.service.LagouAuthCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author tudedong
 * @description
 * @date 2020-07-05 16:09:20
 */
@Service
public class LagouAuthCodeServiceImpl implements LagouAuthCodeService {

    @Autowired
    private LagouAuthCodeDao lagouAuthCodeDao;

    @Value("${config.code.validate.expire}")
    private int codeExpireSeconds;

    @Override
    public void createAuthCode(String email, String code) {

        long createTime = System.currentTimeMillis();
        long expireTime = createTime + codeExpireSeconds * 1000;

        LagouAuthCode lagouAuthCode = new LagouAuthCode();
        lagouAuthCode.setEmail(email);
        lagouAuthCode.setCode(code);
        lagouAuthCode.setCreatetime(new Date(createTime));
        lagouAuthCode.setExpiretime(new Date(expireTime));

        lagouAuthCodeDao.save(lagouAuthCode);

    }

    @Override
    public int validateAuthCode(String email, String code) {

        LagouAuthCode latest = lagouAuthCodeDao.findFirstByEmailOrderByIdDesc(email);
        //0-正确，1-错误，2-超时
        if (latest == null){
            return 1;
        }
        if (!latest.getCode().equalsIgnoreCase(code)){
            return 1;
        }

        long expireTime = latest.getExpiretime().getTime();
        if (expireTime <= System.currentTimeMillis()){
            return 2;
        }
        return 0;
    }
}
