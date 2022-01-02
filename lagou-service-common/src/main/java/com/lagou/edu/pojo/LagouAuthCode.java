package com.lagou.edu.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


/**
 * @author 罗维
 * @description 验证码存储表
 * @create 2021-12-27 21:30
 */
@Getter
@Setter
@Entity
@Table(name = "lagou_auth_code")
public class LagouAuthCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String code;
    private Date createtime;
    private Date expiretime;

}
