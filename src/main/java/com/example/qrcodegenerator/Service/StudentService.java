package com.example.qrcodegenerator.Service;

import com.example.qrcodegenerator.Model.Student;
import com.example.qrcodegenerator.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }
    public ResponseEntity<Student> addStudent(){
        return null;
    }
}
