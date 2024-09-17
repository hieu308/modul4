package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TranslateController {
    private static final Map<String,String> list = new HashMap<>();
    static{
        list.put("dog","chó");
        list.put("cat","mèo");
        list.put("human","người");

    }
    @GetMapping("/")
    public String home() {
        return "home";
    }
    @PostMapping("/translate")
    public String translate(@RequestParam("text") String text, Model model) {
        String result = list.get(text);
        if(result==null){
            result = "không tìm thấy từ cần tra";
            model.addAttribute("result",result);
        }else{
            model.addAttribute("result",result);
        }
        return "home";
    }

}
