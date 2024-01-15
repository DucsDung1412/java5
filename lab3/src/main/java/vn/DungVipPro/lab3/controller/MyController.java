package vn.DungVipPro.lab3.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.DungVipPro.lab3.model.Student;

import java.io.File;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student st, @RequestParam("file") MultipartFile file, Model model){
        try {
            File f = new File(new ClassPathResource(".").getFile().getPath() + "/static/images");
            if(!f.exists()){
                f.mkdirs();
            }
            Path path = Paths.get(f.getAbsolutePath(), File.separator, file.getOriginalFilename());
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            String avatar = Base64.getEncoder().encodeToString(file.getBytes());
            st.setAvatar(avatar);
        } catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("student", st);
        return "/home";
    }
}
