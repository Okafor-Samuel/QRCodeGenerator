package com.example.qrcodegenerator.Controller;

import com.example.qrcodegenerator.DTO.StudentDto;
import com.example.qrcodegenerator.Model.Student;
import com.example.qrcodegenerator.Service.StudentService;
import com.example.qrcodegenerator.Utils.QRCodeGenerator;
import com.google.zxing.WriterException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get-all-student")
    private ResponseEntity<List<Student>> getStudents() throws IOException, WriterException {
        List<Student> students = studentService.getStudents().getBody();
        if(students.size() !=0){
            for (Student student: students){
                QRCodeGenerator.generateQRCode(student);
            }
        }
        return studentService.getStudents();}

    @PostMapping("/add-student")
    public ResponseEntity<Student> addStudent(@RequestBody StudentDto studentDto){
    return studentService.addStudent(studentDto);
    }
    @GetMapping("/get-a-student/{id}")
    public ResponseEntity<Student> findAStudent(@PathVariable Long id){
        return studentService.findAStudent(id);
    }



}
