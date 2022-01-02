package com.lagou.edu.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 罗维
 * @description 令牌存储表
 * @create 2021-12-27 21:30
 */
@Getter
@Setter
@Entity
@Table(name = "lagou_user")
public class LagouUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private Date createtime;
    private Date logintime;
}
