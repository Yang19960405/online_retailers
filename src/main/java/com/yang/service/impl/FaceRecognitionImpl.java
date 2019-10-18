package com.yang.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import com.yang.service.IFaceRecognitionService;
import org.springframework.stereotype.Service;
import com.github.sarxos.webcam.Webcam;

import javax.imageio.ImageIO;


/**
 * 人脸识别逻辑类
 */
@Service
public class FaceRecognitionImpl implements IFaceRecognitionService {
    @Override
    public void openCamera() {
        // 获取默认摄像头并打开
        Webcam webcam = Webcam.getDefault();
        webcam.open();


        // 获取图片
        BufferedImage image = webcam.getImage();

        // 将图片保存到PNG文件
        try {
            ImageIO.write(image, "PNG", new File("test.png"));
        } catch (IOException e) {
            e.printStackTrace();
            webcam.close();
        }
        webcam.close();
    }
}
