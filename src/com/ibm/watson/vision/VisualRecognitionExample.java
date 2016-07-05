package com.ibm.watson.vision;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualRecognitionOptions;

public class VisualRecognitionExample {

  public static void main(String[] args) throws IOException {
    VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_19);
    service.setApiKey("d2834f0879e7c19aa3c76af3840b6ac33587c21a");    
    File obama;    
    URL url = new URL("https://www.whitehouse.gov/sites/whitehouse.gov/files/images/first-family/44_barack_obama%5B1%5D.jpg");
    obama = new File("test");     
    FileUtils.copyURLToFile(url, obama);     
    VisualRecognitionOptions voptoins = new VisualRecognitionOptions.Builder().images(obama).build();
	service.detectFaces(voptoins);
	DetectedFaces result = service.detectFaces(voptoins).execute();
    System.out.println(result.toString());
    }
}