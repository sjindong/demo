package com.example.demo.mycat2.impl;

import com.example.demo.mycat2.bean.BaseBean;
import com.example.demo.mycat2.bean.FormulaBean;
import com.example.demo.mycat2.dao.BaseBeanDao;
import com.example.demo.mycat2.dao.CatVersionDao;
import com.example.demo.mycat2.dao.FormulaBeanDao;
import com.example.demo.mycat2.interfaces.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建业务逻辑实现类
 */
@Service
public class CatServiceImpl implements CatService {
    @Autowired
    private BaseBeanDao baseBeanDao;

    @Autowired
    private FormulaBeanDao formulaBeanDao;

    @Autowired
    private CatVersionDao catVersionDao;

    @Override
    public String checkVersion(long base, long formula) {
//        catVersionDao.find
        return null;
    }

    //查找

    @Override
    public List<BaseBean> findAllBase() {
        return baseBeanDao.findAll();
    }

    @Override
    public List<FormulaBean> findAllFormula() {
        return formulaBeanDao.findAll();
    }

    // 添加
    @Override
    public boolean addBase(BaseBean baseBean) {
        return false;
    }

    @Override
    public boolean addFormula(FormulaBean formulaBean) {
        return false;
    }

    //更新
    @Override
    public boolean updateBase(BaseBean baseBean) {
        return false;
    }

    @Override
    public boolean updateFormula(FormulaBean formulaBean) {
        return false;
    }

    //删除
    @Override
    public boolean delBase(BaseBean baseBean) {
        return false;
    }

    @Override
    public boolean delFormula(FormulaBean formulaBean) {
        return false;
    }
}
