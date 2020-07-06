package com.lagou.edu.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author tudedong
 * @description 令牌存储表
 * @date 2020-07-05 14:25:18
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
