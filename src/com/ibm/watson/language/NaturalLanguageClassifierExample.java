package com.ibm.watson.language;


import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;

public class NaturalLanguageClassifierExample {

  public static void main(String[] args) {
    NaturalLanguageClassifier service = new NaturalLanguageClassifier();
    service.setUsernameAndPassword("<username>", "<password>");

    Classification classification = service.classify("<classifier-id>", "Is it sunny?").execute();

    System.out.println(classification);
  }

}