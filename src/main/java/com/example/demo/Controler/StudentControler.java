package com.example.demo.Controler;

import com.example.demo.entity.Student;

import com.example.demo.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "users", description = "Operations with users")
public class StudentControler {

    private final UserService userService;

    public StudentControler(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Operation(summary = "Get all students", description = "Get a list with all Students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(userService.listAll());
    }

    @GetMapping("/findByName")
    @Operation(summary = "Get Students by Name", description = "Get a list with Students with specific second name")
    public ResponseEntity<List<Student>> findStudentsByName(@RequestParam String secondname) {
        List<Student> students = userService.findStudentsByName(secondname);
        if (students.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(students);
    }

    @GetMapping("/findByGroup")
    @Operation(summary = "Get Students by Group", description = "Get a list with Students from specific Group")
    public ResponseEntity<List<Student>> findStudentsByGroup(@RequestParam String groupname) {
        List<Student> students = userService.findStudentsByGroup(groupname);
        if (students.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(students);
    }
}
