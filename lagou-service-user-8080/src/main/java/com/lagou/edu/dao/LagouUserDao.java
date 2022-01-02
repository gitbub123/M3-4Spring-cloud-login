package com.lagou.edu.dao;

import com.lagou.edu.pojo.LagouUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 罗维
 * @create 2021-12-27 21:30
 */
public interface LagouUserDao extends JpaRepository<LagouUser, Integer> {

    LagouUser findFirstByEmail(String email);
}
