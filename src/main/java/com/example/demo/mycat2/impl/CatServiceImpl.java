package com.example.demo.mycat2.impl;

import com.example.demo.mycat2.bean.BaseBean;
import com.example.demo.mycat2.bean.CatVersion;
import com.example.demo.mycat2.bean.FormulaBean;
import com.example.demo.mycat2.dao.BaseBeanDao;
import com.example.demo.mycat2.dao.CatVersionDao;
import com.example.demo.mycat2.dao.FormulaBeanDao;
import com.example.demo.mycat2.interfaces.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
    public List<CatVersion> checkVersion(List<CatVersion> versions) {
        List<CatVersion> result = new ArrayList<>();
        for (CatVersion catVersion : versions) {
            List<CatVersion> catV = catVersionDao.findCatVersionByKey(catVersion.getKey());
            if (catV != null && catV.size() > 0) {
                if (catV.get(0).getVersion() > catVersion.getVersion()) {
                    result.add(catV.get(0));
                }
            }
        }
        return result;
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
        baseBeanDao.save(baseBean);
        return false;
    }

    @Override
    public boolean addFormula(FormulaBean formulaBean) {
        formulaBeanDao.save(formulaBean);
        return false;
    }

    //更新
    @Override
    public boolean updateBase(BaseBean baseBean) {
        baseBeanDao.update(baseBean.getId(), baseBean.getName(), baseBean.getType(), baseBean.isEffect(), baseBean.getBuff(), baseBean.getAddition());
        return false;
    }

    @Override
    public boolean updateFormula(FormulaBean formulaBean) {
        formulaBeanDao.update(formulaBean.getId(), formulaBean.getProduct(), formulaBean.getElements(), formulaBean.getPart());
        return false;
    }

    //删除
    @Override
    public boolean delBase(BaseBean baseBean) {
        baseBeanDao.delete(baseBean);
        return false;
    }

    @Override
    public boolean delFormula(FormulaBean formulaBean) {
        formulaBeanDao.delete(formulaBean);
        return false;
    }
}
