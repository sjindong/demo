package com.example.demo.mycat2.interfaces;


import com.example.demo.mycat2.bean.BaseBean;
import com.example.demo.mycat2.bean.CatVersion;
import com.example.demo.mycat2.bean.FormulaBean;

import java.util.List;

/**
 * 创建业务逻辑接口
 */
public interface CatService {
    //------------------------------------------- 设备端 ------------------------------------------------------------------

    /**
     * 检查版本
     *
     * @param versions 基础版本
     * @return
     */
    List<CatVersion> checkVersion(List<CatVersion> versions);

    /**
     * 查找所有的合成公式
     *
     * @return
     */
    List<FormulaBean> findAllFormula();

    /**
     * 查找所有的基础元素
     *
     * @return
     */
    List<BaseBean> findAllBase();

    //------------------------------------------- WEB端 ------------------------------------------------------------------

    /**
     * 添加基础类
     *
     * @param baseBean 基础元素
     * @return 添加结果
     */
    boolean addBase(BaseBean baseBean);

    /**
     * 添加基础类
     *
     * @param formulaBean 基础元素
     * @return 添加结果
     */
    boolean addFormula(FormulaBean formulaBean);


    /**
     * 更新基础类
     *
     * @param baseBean 基础元素
     * @return 更新结果
     */
    boolean updateBase(BaseBean baseBean);

    /**
     * 更新基础类
     *
     * @param formulaBean 基础元素
     * @return 更新结果
     */
    boolean updateFormula(FormulaBean formulaBean);


    /**
     * 删除基础类
     *
     * @param baseBean 基础元素
     * @return 删除结果
     */
    boolean delBase(BaseBean baseBean);

    /**
     * 删除基础类
     *
     * @param formulaBean 基础元素
     * @return 删除结果
     */
    boolean delFormula(FormulaBean formulaBean);
}
