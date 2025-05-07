package vn.hoa.Spring.spring_project_CRUD.service;

import vn.hoa.Spring.spring_project_CRUD.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudents();

    public Student getStudentById(int id);

    public Student addStudent(Student student);

    public Student updateStudent(Student student);

    public void DeleteStudent(int id);

}
