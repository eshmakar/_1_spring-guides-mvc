package ru.eshmakar._1_springguidesmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {


    //this Controller work with mustache
    @GetMapping("greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                           Map<String, Object> model){

        model.put("name", name);
        return "greeting";
    }


    @GetMapping
    public String main(Map<String, Object> model){ //здесь уже необходимо сделать список, без этого не работает
        model.put("some", "hello, Eshmakar!"); //put - это синоним add.atribute (thymeleaf)
        return "main";
    }
}
