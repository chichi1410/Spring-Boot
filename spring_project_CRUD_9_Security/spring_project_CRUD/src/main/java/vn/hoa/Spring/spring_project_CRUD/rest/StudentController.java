package vn.hoa.Spring.spring_project_CRUD.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hoa.Spring.spring_project_CRUD.dao.StudentDAO;
import vn.hoa.Spring.spring_project_CRUD.entity.Student;
import vn.hoa.Spring.spring_project_CRUD.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAll")
    public List<Student> getAll() {
        return this.studentService.getAllStudents();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        if(student != null){
            return ResponseEntity.ok(student);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        student = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        Student existingStudent = studentService.getStudentById(id);
        if(existingStudent != null){
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            existingStudent.setEmail(student.getEmail());
            studentService.updateStudent(existingStudent);
            return ResponseEntity.ok(existingStudent);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        if(student != null){
            studentService.DeleteStudent(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
        }
}
