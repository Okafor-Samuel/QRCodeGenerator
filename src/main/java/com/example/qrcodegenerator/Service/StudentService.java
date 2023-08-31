package com.example.qrcodegenerator.Service;

import com.example.qrcodegenerator.DTO.StudentDto;
import com.example.qrcodegenerator.Exception.StudentNotFoundException;
import com.example.qrcodegenerator.Model.Student;
import com.example.qrcodegenerator.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }
    public ResponseEntity<Student> addStudent(StudentDto studentDto){
       Student student  = studentRepository.save(new Student(studentDto));

        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }
    public ResponseEntity<Student> findAStudent(Long id){
        Optional<Student> student = studentRepository.findById(id);
        if(!student.isPresent()){
            throw new StudentNotFoundException("Student with id "+id+ " not found");
        }
        Student targetStudent = student.get();
       return new ResponseEntity<>(targetStudent,HttpStatus.OK);
    }


}
