package com.example.demo;

import com.example.demo.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TranslateController {
  @Autowired
    IDictionaryService dictionaryService;
    @GetMapping("/")
    public String home() {
        return "home";
    }
    @PostMapping("/translate")
    public String translate(@RequestParam("text") String text, Model model) {
        Map<String, String> list = dictionaryService.getDictionary();
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
