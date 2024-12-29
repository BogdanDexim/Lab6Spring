package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Student;
import java.util.List;

@Repository
public interface StudentRepository1 extends JpaRepository<Student, Integer> {
    
	List<Student> findAll();

 
    @Query("SELECT s FROM Student s WHERE s.groupname = ?1")
    List<Student> findStudentsByGroup(String groupname);

   
    @Query(name = "Student.findBySecondname")
    List<Student> findBySecondnameQuery(String secondname);
}
