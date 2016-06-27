package com.ibm.watson.language;


import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;

public class NaturalLanguageClassifierExample {

  public static void main(String[] args) {
    NaturalLanguageClassifier service = new NaturalLanguageClassifier();
    service.setUsernameAndPassword("971c5cca-dfaf-4e67-9386-787e045bcded", "IdeW0KGaeNsw");

    Classification classification = service.classify("2374f9x69-nlc-7541", "Is it sunny?").execute();

    System.out.println(classification);
  }

}