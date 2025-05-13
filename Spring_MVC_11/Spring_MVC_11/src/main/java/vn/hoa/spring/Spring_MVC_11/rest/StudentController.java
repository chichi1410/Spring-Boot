package vn.hoa.spring.Spring_MVC_11.rest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.hoa.spring.Spring_MVC_11.entity.Student;
import vn.hoa.spring.Spring_MVC_11.service.StudentService;



import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;
    List<Student> students;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/list")
    public String listAll(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students" , students);
        return "student/students";
    }

}
