package com.example.demo.mycat2.control;

import com.example.demo.mycat2.bean.BaseBean;
import com.example.demo.mycat2.bean.FormulaBean;
import com.example.demo.mycat2.interfaces.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/web")
public class WebControl {

    @Autowired
    private CatService catService;

    @RequestMapping("/test")
    public String test(@RequestParam String params) {
        return "test = " + params;
    }

    @ResponseBody
    @RequestMapping(value = "/queryBase", method = RequestMethod.GET)
    public List<BaseBean> queryBase() {
        return catService.findAllBase();
    }

    @ResponseBody
    @RequestMapping(value = "/queryFormula", method = RequestMethod.GET)
    public List<FormulaBean> queryFormula() {
        return catService.findAllFormula();
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean add(BaseBean baseBean) {
        return catService.addBase(baseBean);
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean add(FormulaBean formulaBean) {
        return catService.addFormula(formulaBean);
    }


    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public boolean update(BaseBean baseBean) {
        return catService.updateBase(baseBean);
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public boolean update(FormulaBean formulaBean) {
        return catService.updateFormula(formulaBean);
    }


    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public boolean del(BaseBean baseBean) {
        return catService.delBase(baseBean);
    }

    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public boolean del(FormulaBean formulaBean) {
        return catService.delFormula(formulaBean);
    }
}
