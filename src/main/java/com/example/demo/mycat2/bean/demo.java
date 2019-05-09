package com.example.demo.mycat2.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

/**
 * @Description: SpringBoot自动配置会探测到我们使用了H2数据库，它会根据实体类自动创建数据表
 * @author: Alan
 * @Date: 2018/11/30 22:33
 */
@Entity
@Table(name = "user")
@ToString
public class demo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;//主键

    @Column(nullable = false)
    @Getter
    @Setter
    private String firstName;//名

    @Column(nullable = false)
    @Getter
    @Setter
    private String lastName;//姓

    @Column(nullable = false)
    @Getter
    @Setter
    private String idCard;//身份证

    @Column(nullable = false)
    @Getter
    @Setter
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;//出生日期

    public demo() {
    }

    public demo(Long id, String firstName, String lastName, String idCard, LocalDate dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idCard = idCard;
        this.dateOfBirth = dateOfBirth;
    }
}
