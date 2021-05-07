package com.example.geradordeqrcode;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class QRCodeGenerator {
    int size = 125;
    String nomeArquivo = "qrcode.png";

    public byte[] gerarQRCode(String mensagem) {
        try (
            FileOutputStream f = new FileOutputStream(nomeArquivo);
            ByteArrayOutputStream out = QRCode.from(mensagem)
                    .to(ImageType.PNG)
                    .withSize(size, size)
                    .stream();

        ) {
            return out.toByteArray();
        } catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }
}
