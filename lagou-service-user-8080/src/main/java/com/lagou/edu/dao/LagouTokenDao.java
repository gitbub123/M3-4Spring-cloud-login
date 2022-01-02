package com.lagou.edu.dao;

import com.lagou.edu.pojo.LagouToken;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 罗维
 * @create 2021-12-27 21:30
 */
public interface LagouTokenDao extends JpaRepository<LagouToken, Integer> {

    LagouToken findFirstByToken(String token);
}
