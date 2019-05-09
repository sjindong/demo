package com.example.demo.mycat2.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by SJD
 * time: 2019/4/23
 * 合成公式
 */
@Entity
@Table(name = "formula")
@ToString
public class FormulaBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //结果 产品
    //名称
    @Setter
    @Getter
    @Column(nullable = false)
    private String product;

    //元素 ， 合成的选项
    //名称
    @Setter
    @Getter
    @Column(nullable = false)
    private String elements;

    //部位，套装 等
    //名称
    @Setter
    @Getter
    @Column(nullable = false)
    private int part;
}
