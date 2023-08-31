package com.example.qrcodegenerator.Utils;

import com.example.qrcodegenerator.DTO.StudentDto;
import com.example.qrcodegenerator.Model.Student;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {
    public static void generateQRCode(Student student) throws WriterException, IOException {

        String qrCodePath ="/Users/decagon/Desktop/QRCodeFolder";
        String qrCodeName = qrCodePath+student.getEmail()+ "-QRCODE.png";
        var qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(
                "First Name: "+student.getFirstName()+"\n"+
                        "Last Name: "+student.getLastName()+"\n"+
                        "Email: "+student.getEmail()+"\n"+
                        "Mobile Number: "+student.getMobileNumber(), BarcodeFormat.QR_CODE,400,400);
        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix,"PNG",path);
    }
}
