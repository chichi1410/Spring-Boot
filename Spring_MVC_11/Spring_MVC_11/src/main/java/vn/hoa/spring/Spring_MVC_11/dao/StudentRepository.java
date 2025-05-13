package vn.hoa.spring.Spring_MVC_11.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hoa.spring.Spring_MVC_11.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
