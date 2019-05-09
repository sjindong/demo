package com.example.demo.mycat2.dao;

import com.example.demo.mycat2.bean.BaseBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatVersionDao extends JpaRepository<BaseBean, Long> {

}