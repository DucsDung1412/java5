package vn.DungVipPro.lab3.model;

import jakarta.validation.constraints.*;

import java.util.List;

public class Student {
    @NotBlank(message = "Vui lòng nhập họ và tên")
    private String name;
    @NotBlank(message = "Vui lòng nhập địa chỉ email")
    @Email(message = "Vui lòng nhập đúng định dạng email")
    private String email;
    @NotNull(message = "Vui lòng nhập điểm")
    @Min(value = 0, message = "Điểm phải lớn hơn hoặc bằng 0")
    @Max(value = 10, message = "Điểm phải nhỏ hơn hoặc bằng 10")
    private Double marks;
    @NotNull(message = "Vui lòng chọn giới tính")
    private Boolean gender;
    @NotBlank(message = "Vui lòng chọn khoa")
    private String faculty;
    @NotEmpty(message = "Vui lòng chọn sở thích")
    private List<String> hobbies;
    @NotEmpty(message = "Vui lòng chọn avatar")
    private String avatar;

    public Student(String name, String email, Double marks, Boolean gender, String faculty, List<String> hobbies, String avatar) {
        this.name = name;
        this.email = email;
        this.marks = marks;
        this.gender = gender;
        this.faculty = faculty;
        this.hobbies = hobbies;
        this.avatar = avatar;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", marks=" + marks +
                ", gender=" + gender +
                ", faculty='" + faculty + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
