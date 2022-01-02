package com.lagou.edu.dao;

import com.lagou.edu.pojo.LagouAuthCode;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 罗维
 * @create 2021-12-27 21:30
 */
public interface LagouAuthCodeDao extends JpaRepository<LagouAuthCode, Integer> {

    LagouAuthCode findFirstByEmailOrderByIdDesc(String email);
}
