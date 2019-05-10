package com.example.demo.mycat2.dao;

import com.example.demo.mycat2.bean.BaseBean;
import com.example.demo.mycat2.bean.CatVersion;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CatVersionDao extends JpaRepository<CatVersion, Long> {
    @Override
    List<CatVersion> findAll();

    @Override
    List<CatVersion> findAll(Sort sort);

    @Query(value = "select * from CatVersion where key=:key", nativeQuery = true)
    public List<CatVersion> findCatVersionByKey(@Param("key") String key);
}