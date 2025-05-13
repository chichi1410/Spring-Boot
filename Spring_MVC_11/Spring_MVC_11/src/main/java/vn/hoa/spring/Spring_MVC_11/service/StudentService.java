package vn.hoa.spring.Spring_MVC_11.service;

import org.springframework.stereotype.Service;
import vn.hoa.spring.Spring_MVC_11.entity.Student;



import java.util.List;
@Service
public interface StudentService {
    public List<Student> getAllStudents();

    public Student getStudentById(int id);

    public Student addStudent(Student student);

    public Student updateStudent(Student student);

    public void deleteStudentById(int id);

}
