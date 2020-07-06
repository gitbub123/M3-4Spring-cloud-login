package com.lagou.edu.dao;

import com.lagou.edu.pojo.LagouToken;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tudedong
 * @description
 * @date 2020-07-05 15:22:05
 */
public interface LagouTokenDao extends JpaRepository<LagouToken, Integer> {

    LagouToken findFirstByToken(String token);
}
