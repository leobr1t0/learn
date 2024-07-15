package tests.tests.service;

import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tests.tests.config.MetricsConfig;
import tests.tests.model.Student;
import tests.tests.model.Tagger;
import tests.tests.repository.StudentRepository;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private MetricsConfig metricsConfig;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MeterRegistry meterRegistry;

    private Student validateStudent(UUID id) {
        logger.info("Validating student with id: {}", id);
        return studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found"));
    }

    public List<Student> getAllStudents() {
        logger.info("Getting all students");
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        logger.info("Creating student: {}", student);
        Tagger tagger = MetricsConfig.map(student);
        metricsConfig.addCommonTags(meterRegistry, tagger);
        return studentRepository.save(student);
    }

    public void createStudents(List<Student> students) {
        logger.info("Creating students: {}", students);
        studentRepository.saveAll(students);
    }

    public void deleteStudent(UUID id) {
        logger.info("Deleting student with id: {}", id);
        studentRepository.delete(validateStudent(id));
    }
}
