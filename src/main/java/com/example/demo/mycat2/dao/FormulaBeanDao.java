package com.example.demo.mycat2.dao;

import com.example.demo.mycat2.bean.FormulaBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * 创建Dao接口
 */
public interface FormulaBeanDao extends JpaRepository<FormulaBean, Long> {
    @Override
    List<FormulaBean> findAll();

    @Override
    List<FormulaBean> findAllById(Iterable<Long> iterable);

    @Modifying
    @Query(value = "update FormulaBean set product=:product,elements=:elements,part=:part where id = :id", nativeQuery = true)
    void update(@Param("id") Long id, @Param("product") String product, @Param("elements") String elements, @Param("part") int part);

}
