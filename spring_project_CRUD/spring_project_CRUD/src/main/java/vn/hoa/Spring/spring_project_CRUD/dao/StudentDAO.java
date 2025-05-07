package vn.hoa.Spring.spring_project_CRUD.dao;

import vn.hoa.Spring.spring_project_CRUD.entity.Student;

import java.util.List;

public interface StudentDAO {
    public List<Student> getAllStudents();

    public Student getStudentById(int id);

    public Student save (Student student);

    // update
    public Student saveAndFlush (Student student);

    public void deleteById (int id);
}
