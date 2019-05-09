package com.example.demo.mycat2.dao;

import com.example.demo.mycat2.bean.BaseBean;
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
public interface BaseBeanDao extends JpaRepository<BaseBean, Long> {
    /* *****************************create***************************************/
    @Override
    <S extends BaseBean> S save(S s);

    /* *****************************read***************************************/

    /**
     * Using sort
     *
     * @param name  名称
     * @return
     */
    @Query("select u from BaseBean u where u.name = ?1")
    List<BaseBean> findByAndSort(String name);

    /**
     * Query creation
     * this translates into the following query:
     * select u from BaseBean u where u.idCard = ?1
     */
    BaseBean findByIdCard(String idCard);

    /**
     * Native Queries
     * The @Query annotation allows for running native queries by setting the nativeQuery flag to true
     *
     * @param idCard
     * @return
     */
    @Query(value = "select * from user where ID_CARD = ?1", nativeQuery = true)
    BaseBean findByIdCard2(String idCard);

    /**
     * Using @Query
     *
     * @param idCard
     * @return
     */
    @Query("select u from BaseBean u where u.idCard = ?1")
    BaseBean findByIdCard3(String idCard);

    /**
     * Declare native count queries for pagination at the query method by using @Query
     *
     * @param lastName
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * FROM BaseBean WHERE name = ?1",
            countQuery = "SELECT count(*) FROM BaseBean WHERE name = ?1",
            nativeQuery = true)
    Page<BaseBean> findByLastNameWithPageable(String lastName, Pageable pageable);

    /**
     * Using Named Parameters
     *
     * @param firstName
     * @param lastName
     * @return
     */
    @Query("select u from BaseBean u where u.firstName = :firstName or u.lastName = :lastName")
    List<BaseBean> findByFirstNameOrLastName(@Param("firstName") String firstName,
                                                @Param("lastName") String lastName);

    /**
     * findByDateOfBirth
     *
     * @param date
     * @return
     */
    List<BaseBean> findByDateOfBirth(@Param("date") LocalDate date);

    /**
     * find all users
     *
     * @param sort
     * @return
     */
    @Override
    List<BaseBean> findAll(Sort sort);
    /****************************update*****************************************/
    /**
     * update a usr by Modifying Queries
     *
     * @param firstName
     * @param idCard
     * @return
     */
    @Modifying
    @Query("update BaseBean u set u.firstName = ?1 where u.idCard = ?2")
    int updateUser(String firstName, String idCard);
    /****************************delete*****************************************/
    /**
     * delete a user by idCard
     *
     * @param idCard
     */
    void deleteByIdCard(String idCard);

    /**
     * Using a derived delete query
     *
     * @param idCard
     */
    @Modifying
    @Query("delete from BaseBean u where u.idCard = ?1")
    void deleteByIdCard2(String idCard);

    /**
     * delete a user by id
     *
     * @param id
     */
    @Override
    @Modifying
    @Query(value = "delete from user where id = ?1", nativeQuery = true)
    void deleteById(Long id);


}
