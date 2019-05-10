package com.example.demo.mycat2.control;

import com.example.demo.mycat2.bean.CatVersion;
import com.example.demo.mycat2.interfaces.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mobile")
public class MobileControl {

    @Autowired
    private CatService catService;

    @RequestMapping("/test")
    public String test(@RequestParam String params) {
        return "test = " + params;
    }

    @ResponseBody
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public List<CatVersion> check(List<CatVersion> catVersions) {
        return catService.checkVersion(catVersions);
    }

    @ResponseBody
    @RequestMapping(value = "/getVersion", method = RequestMethod.GET)
    public  List<CatVersion> getVersion(List<CatVersion> catVersions) {
        List<CatVersion> s = catService.checkVersion(catVersions);
        return s;
    }
}
