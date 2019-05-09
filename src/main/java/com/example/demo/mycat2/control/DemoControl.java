package com.example.demo.mycat2.control;

import com.example.demo.mycat2.bean.BaseBean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/*

SpringBoot相关注解     注解的作用
@Entity             @Entity说明这个class是实体类，并且使用默认的orm规则
@GeneratedValue     JPA通用策略生成器
@Controller         处理HTTP请求
@RestContoller      Spring4以后的注解，相当于@Controller+@ResponseBody配合使用
@RequestMapping     配置URL映射
@PathVariable       获取URL中的数据
@RequestParam       获取请求参数的值
@GetMapping         注解组合
*/

@RestController
@EnableAutoConfiguration
public class DemoControl {

    @RequestMapping("/hello")
    private String index() {
        return "Hello World!";
    }

    //    @RequestMapping：表示请求的映射，value的值表示路径，method的值是请求方式，如：GET，POST等。
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam String params) {
        System.out.println(params);
        return "hello " + params;
    }

    @GetMapping("/search/{path}")
    public String path(@PathVariable String path) {
        System.out.println(path);
        return path;
    }

    @GetMapping("/searchall")
    public String searchAll(@RequestParam Map map) {// 这个也可以使用bean对象
        System.out.println(map);
        return map.toString();
    }

    @PostMapping("/find")
    public String find(@RequestBody String userId) {
        System.out.println(userId);
        return userId;
    }

    @PostMapping("/addmap")
    public String addUser1(@RequestBody Map map) {
        System.out.println(map);
        return map.toString();
    }

    @PostMapping("/adduser")
    public String addUser(@RequestBody BaseBean user) {
        System.out.println(user);
        return "Success";
    }

    @ResponseBody
    @PostMapping("/finduser")
    public BaseBean findUser(@RequestBody BaseBean user) {
        System.out.println(user);
        return user;
    }

}