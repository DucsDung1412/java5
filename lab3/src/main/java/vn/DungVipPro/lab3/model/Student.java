package vn.DungVipPro.lab3.model;

import java.util.List;

public class Student {
    private String name;
    private String email;
    private Double marks;
    private Boolean gender;
    private String faculty;
    private List<String> hobbies;

    public Student(String name, String email, Double marks, Boolean gender, String faculty, List<String> hobbies) {
        this.name = name;
        this.email = email;
        this.marks = marks;
        this.gender = gender;
        this.faculty = faculty;
        this.hobbies = hobbies;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}
