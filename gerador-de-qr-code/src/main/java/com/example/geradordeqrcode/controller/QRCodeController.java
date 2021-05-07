package com.example.geradordeqrcode.controller;

import com.example.geradordeqrcode.QRCodeGenerator;
import net.glxn.qrgen.core.image.ImageType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qrcode")
public class QRCodeController {

    @GetMapping
    public ResponseEntity gerarQRCode(@RequestBody String mensagem) {
        QRCodeGenerator qrcode = new QRCodeGenerator();

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity(qrcode.gerarQRCode(mensagem), headers, HttpStatus.CREATED);
    }
}
