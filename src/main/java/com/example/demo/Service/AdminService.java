package com.example.demo.Service;

import com.example.demo.entity.Student;
import com.example.demo.Repository.StudentRepository1;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final StudentRepository1 studentRepository;

    public AdminService(StudentRepository1 studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void removeStudent(int studId) {
        studentRepository.deleteById(studId);
    }

    public void newStudent(int id, String firstname, String secondname, String groupname) {
    	
        Student student = new Student(id, firstname, secondname, groupname);
        studentRepository.save(student);
    }
}
