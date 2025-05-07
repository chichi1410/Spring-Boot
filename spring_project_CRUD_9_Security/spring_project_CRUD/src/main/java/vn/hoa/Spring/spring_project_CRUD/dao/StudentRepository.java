package vn.hoa.Spring.spring_project_CRUD.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import vn.hoa.Spring.spring_project_CRUD.entity.Student;

@RepositoryRestResource(path = "students")
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
