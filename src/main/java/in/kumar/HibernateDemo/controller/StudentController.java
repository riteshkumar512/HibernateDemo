package in.kumar.HibernateDemo.controller;

import in.kumar.HibernateDemo.model.Student;
import in.kumar.HibernateDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping()
    public ResponseEntity<String> createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return ResponseEntity.ok("Student Created");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id){
        Student result = studentService.getStudentById(id);
        return ResponseEntity.ok(result);
    }
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> list= studentService.getAllStudent();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@RequestBody Student student,
                                                @PathVariable long id){
        studentService.updateSudent(student,id);
        return ResponseEntity.ok("Updated Successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Deleted");
    }
}
