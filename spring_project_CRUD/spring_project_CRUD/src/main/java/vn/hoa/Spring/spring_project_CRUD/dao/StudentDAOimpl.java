package vn.hoa.Spring.spring_project_CRUD.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.hoa.Spring.spring_project_CRUD.entity.Student;

import java.util.List;
@Repository
public class StudentDAOimpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> getAllStudents() {
        String jpql = "select s from Student s";
        return entityManager.createQuery(jpql, Student.class).getResultList();
    }

    @Override
    public Student getStudentById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    //@Transactional
    public Student save(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
   // @Transactional
    public Student saveAndFlush(Student student) {
        student = entityManager.merge(student);
        entityManager.flush();
        return student;
    }

    @Override
    //@Transactional
    public void deleteById(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}
