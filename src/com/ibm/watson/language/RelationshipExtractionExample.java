package com.ibm.watson.language;

import com.ibm.watson.developer_cloud.relationship_extraction.v1_beta.RelationshipExtraction;
import com.ibm.watson.developer_cloud.relationship_extraction.v1_beta.model.Dataset;


public class RelationshipExtractionExample {

  public static void main(String[] args) {
    RelationshipExtraction service = new RelationshipExtraction();
    service.setUsernameAndPassword("<username>", "<password>");

    service.setDataset(Dataset.ENGLISH_NEWS);
    String response = service.extract("IBM Watson developer cloud").execute();

    System.out.println(response);
  }
}