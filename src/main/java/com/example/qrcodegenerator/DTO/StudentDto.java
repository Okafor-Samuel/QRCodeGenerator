package com.example.qrcodegenerator.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private String firstName;
    private String lastName;
    @NaturalId(mutable = true)
    private String email;
    private String mobileNumber;
}
