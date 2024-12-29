package com.example.demo.Service;

import com.example.demo.entity.Student;
import com.example.demo.Repository.StudentRepository1;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final StudentRepository1 studentRepository;

    public UserService(StudentRepository1 studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> listAll() {
    	
        return studentRepository.findAll();
    }
    public List<Student> findStudentsByName(String secondname) {
        return studentRepository.findBySecondnameQuery(secondname);
    }

    public List<Student> findStudentsByGroup(String groupname) {
        return studentRepository.findStudentsByGroup(groupname);
    }
}
