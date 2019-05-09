package com.example.demo.mycat2.control;

import com.example.demo.mycat2.interfaces.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mobile")
public class MobileControl {

    @Autowired
    private CatService userService;

    @RequestMapping("/test")
    public String test(@RequestParam String params) {
        return "test = " + params;
    }

    @ResponseBody
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public String check(long base, long formula) {
        return userService.checkVersion(base, formula);
    }
}
