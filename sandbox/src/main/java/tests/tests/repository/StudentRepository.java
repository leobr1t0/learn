package tests.tests.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tests.tests.model.Student;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
}
