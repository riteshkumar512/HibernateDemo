package in.kumar.HibernateDemo.service;

import in.kumar.HibernateDemo.model.Student;
import in.kumar.HibernateDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createStudent(Student student){
        studentRepository.save(student);
    }

    @Transactional
    public Student getStudentById(long id){
        return studentRepository.findById(id);
    }

    @Transactional
    public void deleteStudent(long id){
        Student student1=studentRepository.findById(id);

        if (student1==null){
            throw new RuntimeException("Stuent not found");
        }
        studentRepository.remove(student1);
    }

    @Transactional
    public void updateSudent(Student studentReq, long id){
        Student student1=studentRepository.findById(id);

        if (student1==null){
            throw new RuntimeException("Stuent not found");
        }
        student1.setName(studentReq.getName());
        student1.setEmail(studentReq.getEmail());
        student1.setAge(studentReq.getAge());
    }

    public List<Student> getAllStudent(){
        return null;
    }
}
