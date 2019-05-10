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
public interface DemoDao extends JpaRepository<FormulaBean, Long> {
    /* *****************************create***************************************/
    @Override
    FormulaBean save(FormulaBean user);

    /* *****************************read***************************************/

    /**
     * Using sort
     *
     * @param lastName
     * @param sort
     * @return
     */
    @Query("select u from FormulaBean u where u.lastName like ?1%")
    List<FormulaBean> findByAndSort(String lastName, Sort sort);

    /**
     * Query creation
     * this translates into the following query:
     * select u from FormulaBean u where u.idCard = ?1
     */
    FormulaBean findByIdCard(String idCard);

    /**
     * Native Queries
     * The @Query annotation allows for running native queries by setting the nativeQuery flag to true
     *
     * @param idCard
     * @return
     */
    @Query(value = "select * from user where ID_CARD = ?1", nativeQuery = true)
    FormulaBean findByIdCard2(String idCard);

    /**
     * Using @Query
     *
     * @param idCard
     * @return
     */
    @Query("select u from FormulaBean u where u.idCard = ?1")
    FormulaBean findByIdCard3(String idCard);

    /**
     * Declare native count queries for pagination at the query method by using @Query
     *
     * @param lastName
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * FROM FormulaBean WHERE LAST_NAME = ?1",
            countQuery = "SELECT count(*) FROM FormulaBean WHERE LAST_NAME = ?1",
            nativeQuery = true)
    Page<FormulaBean> findByLastNameWithPageable(String lastName, Pageable pageable);

    /**
     * Using Named Parameters
     *
     * @param firstName
     * @param lastName
     * @return
     */
    @Query("select u from FormulaBean u where u.firstName = :firstName or u.lastName = :lastName")
    List<FormulaBean> findByFirstNameOrLastName(@Param("firstName") String firstName,
                                                @Param("lastName") String lastName);

    /**
     * findByDateOfBirth
     *
     * @param date
     * @return
     */
    List<FormulaBean> findByDateOfBirth(@Param("date") LocalDate date);

    /**
     * find all users
     *
     * @param sort
     * @return
     */
    @Override
    List<FormulaBean> findAll(Sort sort);
    /****************************update*****************************************/
    /**
     * update a usr by Modifying Queries
     *
     * @param firstName
     * @param idCard
     * @return
     */
    @Modifying
    @Query("update FormulaBean u set u.firstName = ?1 where u.idCard = ?2")
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
    @Query("delete from FormulaBean u where u.idCard = ?1")
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
