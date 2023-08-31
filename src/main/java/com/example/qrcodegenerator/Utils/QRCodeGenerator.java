package com.example.qrcodegenerator.Utils;

import com.example.qrcodegenerator.DTO.StudentDto;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeGenerator {
    public static void generateQRCode(StudentDto studentDto) throws WriterException {

        String qrCodePath ="/Users/decagon/Desktop/QRCodeFolder";
        String qrCodeName = qrCodePath+studentDto.getEmail()+ "-QRCODE.png";
        var qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(
                "First Name: "+studentDto.getFirstName()+"\n"+
                        "Last Name: "+studentDto.getLastName()+"\n"+
                        "Email: "+studentDto.getEmail()+"\n"+
                        "Mobile Number: "+studentDto.getMobileNumber(), BarcodeFormat.QR_CODE,400,400);
    }
}
