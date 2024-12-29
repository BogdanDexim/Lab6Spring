package com.example.demo.Controler;

import com.example.demo.entity.Student;
import com.example.demo.Service.AdminService;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admins")
@Tag(name = "admins", description = "Operations with admins")
public class AdminControler {

    private final AdminService adminService;

    public AdminControler(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    @Operation(summary = "Create or update a student", description = "Create or update a student with specified parameters")
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        adminService.newStudent(student.getStudId(), student.getFirstname(), student.getSecondname(), student.getGroupname());
        return ResponseEntity.ok("Student created/updated successfully.");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Student By Id", description = "Delete Student by specific identifier")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studId) {
        adminService.removeStudent(studId);
        return ResponseEntity.ok("Student deleted successfully.");
    }
}
