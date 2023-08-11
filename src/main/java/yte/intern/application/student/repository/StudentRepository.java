package yte.intern.application.student.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.application.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {


}