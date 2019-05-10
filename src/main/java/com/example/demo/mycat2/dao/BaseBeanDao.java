package com.example.demo.mycat2.dao;

import com.example.demo.mycat2.bean.BaseBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 创建Dao接口
 */
@Transactional
public interface BaseBeanDao extends JpaRepository<BaseBean, Long> {
    @Override
    List<BaseBean> findAll();

    @Override
    List<BaseBean> findAllById(Iterable<Long> iterable);

    @Modifying
    @Query(value = "update BaseBean set name = :name where id = :id", nativeQuery = true)
    void updateNameById(@Param("id") Long id, @Param("name") String name);

    @Modifying
    @Query(value = "update BaseBean set type = :type where id = :id", nativeQuery = true)
    void updateTypeById(@Param("id") Long id, @Param("type") int type);

    @Modifying
    @Query(value = "update BaseBean set isEffect = :isEffect where id = :id", nativeQuery = true)
    void updateIsEffectById(@Param("id") Long id, @Param("isEffect") boolean isEffect);

    @Modifying
    @Query(value = "update BaseBean set addition=:addition,buff = :buff where id = :id", nativeQuery = true)
    void updateBuffById(@Param("id") Long id, @Param("buff") String buff, @Param("addition") String addition);

    @Modifying
    @Query(value = "update BaseBean set name=:name,type=:type,isEffect=:isEffect,addition=:addition,buff = :buff where id = :id", nativeQuery = true)
    void update(@Param("id") Long id, @Param("name") String name, @Param("type") int type, @Param("isEffect") boolean isEffect, @Param("buff") String buff, @Param("addition") String addition);

    /**报错：
     * java.sql.SQLException: Can not issue data manipulation statements with executeQuery().
     * 解决方式：
     * 在修改方法上面添加@Modifying 注解
     * 报错：
     * javax.persistence.TransactionRequiredException: Executing an update/delete query
     * 解决方式：
     * 在UserRepository.java类上添加@Transactional注解
     */
}
