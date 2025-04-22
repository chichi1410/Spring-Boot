package vn.hoa.spring7_8_pathvaliables.rest;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.hoa.spring7_8_pathvaliables.entity.Student;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/students")
public class Controller {
    List<Student> students;
    @PostConstruct
    public void creatStudent(){
        students = new ArrayList<Student>();
        students.add(new Student(2432 , "nguyen dai hoa"));
        students.add(new Student(57 , "nguyen hoa"));
        students.add(new Student(2 , "dai hoa"));
    }
    @GetMapping("/")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/{id}")
    public Student getStudentByName(@PathVariable int id){
        for(Student student : students){
            if(student.getId() == id){
                return student;
            }
        }
        return null;
    }
}
