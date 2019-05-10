package com.example.demo.mycat2.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "version")
@ToString
public class CatVersion {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //名称
    @Setter
    @Getter
    @Column(nullable = false)
    private String key;


    //名称
    @Setter
    @Getter
    @Column(nullable = false)
    private long version;
}
