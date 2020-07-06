package com.lagou.edu.dao;

import com.lagou.edu.pojo.LagouAuthCode;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tudedong
 * @description
 * @date 2020-07-05 16:05:00
 */
public interface LagouAuthCodeDao extends JpaRepository<LagouAuthCode, Integer> {

    LagouAuthCode findFirstByEmailOrderByIdDesc(String email);
}
