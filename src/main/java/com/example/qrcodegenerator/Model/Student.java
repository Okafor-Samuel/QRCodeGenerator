package com.example.qrcodegenerator.Model;

import com.example.qrcodegenerator.DTO.StudentDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @NaturalId(mutable = true)
    private String email;
    private String mobileNumber;

    public Student(StudentDto studentDto){
        this.firstName = studentDto.getFirstName();
        this.lastName = studentDto.getLastName();
        this.email = studentDto.getEmail();
        this.mobileNumber = studentDto.getMobileNumber();

    }

}
