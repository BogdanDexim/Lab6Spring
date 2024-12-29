package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "students")
@NamedQueries({
    @NamedQuery(name = "Student.findBySecondname", query = "SELECT s FROM Student s WHERE s.secondname = :secondname")
})
@NoArgsConstructor 
@AllArgsConstructor 
@ToString
@Getter
@Setter
public class Student {

    @Id
    @Column(name = "ID")
    private int studId; 
    private String firstname;
    private String secondname;
    private String groupname;
}