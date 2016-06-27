package com.ibm.watson.vision;

import java.io.File;

import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.CreateClassifierOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassifier;

public class VisualRecognitionExample {

  public static void main(String[] args) {
    VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_19);
    service.setApiKey("d2834f0879e7c19aa3c76af3840b6ac33587c21a");

    System.out.println("Classify an image");
    ClassifyImagesOptions options = new ClassifyImagesOptions.Builder()
        .images(new File("src/test/resources/visual_recognition/car.png"))
        .build();
    VisualClassification result = service.classify(options).execute();
    System.out.println(result);

    
    System.out.println("Create a classifier with positive and negative images");
    CreateClassifierOptions createOptions = new CreateClassifierOptions.Builder()
        .classifierName("foo")
        .addClass("car", new File("src/test/resources/visual_recognition/car_positive.zip"))
        .addClass("baseball", new File("src/test/resources/visual_recognition/baseball_positive.zip"))
        .negativeExamples(new File("src/test/resources/visual_recognition/negative.zip"))
        .build();
    VisualClassifier foo = service.createClassifier(createOptions).execute();
    System.out.println(foo);

    System.out.println("Classify using the 'Car' classifier");
    options = new ClassifyImagesOptions.Builder()
        .images(new File("src/test/resources/visual_recognition/car.png"))
        .classifierIds("car")
        .build();
    result = service.classify(options).execute();
    System.out.println(result);

  }
}