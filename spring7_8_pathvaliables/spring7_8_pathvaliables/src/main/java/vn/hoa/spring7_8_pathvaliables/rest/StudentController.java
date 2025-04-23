package vn.hoa.spring7_8_pathvaliables.rest;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;
import vn.hoa.spring7_8_pathvaliables.entity.Student;
import vn.hoa.spring7_8_pathvaliables.exception.StudentException;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/students")
public class StudentController {
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
        Student st = null;
        for(Student student : students){
            if(student.getId() == id){
                return student;
            }
        }
        if(st == null){
            throw new StudentException("canNot find student with id " + id);
        }
        return st;
    }
}
