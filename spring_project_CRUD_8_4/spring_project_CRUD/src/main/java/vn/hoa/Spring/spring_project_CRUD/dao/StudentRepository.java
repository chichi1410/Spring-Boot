package vn.hoa.Spring.spring_project_CRUD.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import vn.hoa.Spring.spring_project_CRUD.entity.Student;

import java.util.List;

@RepositoryRestResource(path = "students")
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // truy van bang firstName
    public List<Student> findByFirstName(String firstName);

    // truy van bang firstNameAndLastName
    public List<Student> findByFirstNameAndLastName(String firstName , String lastName);

    // truy van student co first name khac gia tri tim kiem
    @Query("SELECT s FROM Student s where s.firstName<>?1")
    public List<Student> findByFirstNameNot(String firstName);

}