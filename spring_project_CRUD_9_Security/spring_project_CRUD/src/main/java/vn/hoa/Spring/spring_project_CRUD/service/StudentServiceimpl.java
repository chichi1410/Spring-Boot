package vn.hoa.Spring.spring_project_CRUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.hoa.Spring.spring_project_CRUD.dao.StudentDAO;
import vn.hoa.Spring.spring_project_CRUD.dao.StudentRepository;
import vn.hoa.Spring.spring_project_CRUD.entity.Student;

import java.util.List;

@Service
public class StudentServiceimpl  implements StudentService{

    private StudentRepository studentRepository;
    @Autowired
    public StudentServiceimpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.getById(id);
    }

    @Override
    @Transactional
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    @Transactional
    public void DeleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
