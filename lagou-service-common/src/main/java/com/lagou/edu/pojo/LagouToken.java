package com.lagou.edu.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author 罗维
 * @description 令牌存储表
 * @create 2021-12-27 21:30
 */
@Getter
@Setter
@Entity
@Table(name = "lagou_token")
public class LagouToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String token;
}
