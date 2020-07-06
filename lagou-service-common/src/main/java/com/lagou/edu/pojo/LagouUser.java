package com.lagou.edu.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author tudedong
 * @description
 * @date 2020-07-05 14:35:50
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
