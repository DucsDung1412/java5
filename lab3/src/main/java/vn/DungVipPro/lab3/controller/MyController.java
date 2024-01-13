package vn.DungVipPro.lab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.DungVipPro.lab3.model.Student;

import java.lang.reflect.Array;
import java.util.*;

@Controller
@RequestMapping("/student")
public class MyController {
    @GetMapping("/register")
    public String getIndex(Model model){
        Student student = new Student();
        List<String> faculties = Arrays.asList("CNTT", "DLNHKS", "QTDN");
        Map<Boolean, String> genders = new HashMap<>();
        genders.put(true, "Male");
        genders.put(false, "Female");
        Map<String, String> hobbies = new HashMap<>();
        hobbies.put("T", "Travelling");
        hobbies.put("M", "Music");
        hobbies.put("F", "Food");
        hobbies.put("O", "Other");
        model.addAttribute("student", student);
        model.addAttribute("faculties", faculties);
        model.addAttribute("genders", genders);
        model.addAttribute("hobbies", hobbies);


        hobbies.keySet().forEach(test -> {
            System.out.println(hobbies.get(test));
        });


        return "/index";
    }
}
