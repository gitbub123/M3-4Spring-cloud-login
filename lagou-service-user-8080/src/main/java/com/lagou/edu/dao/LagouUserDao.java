package com.lagou.edu.dao;

import com.lagou.edu.pojo.LagouUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tudedong
 * @description
 * @date 2020-07-05 14:34:53
 */
public interface LagouUserDao extends JpaRepository<LagouUser, Integer> {

    LagouUser findFirstByEmail(String email);
}
