package com.example.demo.mycat2.bean;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by SJD
 * time: 2019/4/23
 * 基础类型
 */

@Entity
@Table(name = "base")
@ToString
public class BaseBean {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //名称
    @Setter
    @Getter
    @Column(nullable = false)
    private String name;

    //类型
    @Setter
    @Getter
    @Column(nullable = false)
    private int type;

    //是否是可合成的
    @Setter
    @Getter
    @Column(nullable = false)
    private boolean isEffect = false;

    //效果
    @Setter
    @Getter
    @Column(nullable = true)
    private String buff;

    //加成
    @Setter
    @Getter
    @Column(nullable = true)
    private String addition;
}
