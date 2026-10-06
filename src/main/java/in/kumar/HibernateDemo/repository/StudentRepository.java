package in.kumar.HibernateDemo.repository;

import in.kumar.HibernateDemo.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    //create
    public void save(Student student){
        entityManager.persist(student);
    }

    //read
    public Student findById(long id){
        return entityManager.find(Student.class,id);
    }

    //delete
    public void remove(Student student){
        entityManager.remove(student);
    }

    //update



}
