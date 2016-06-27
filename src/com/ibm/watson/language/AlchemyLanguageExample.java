package com.ibm.watson.language;

import java.util.HashMap;
import java.util.Map;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Entities;

public class AlchemyLanguageExample { 


public static void main(String[] args) {
    AlchemyLanguage service = new AlchemyLanguage();
    service.setApiKey("5fc91e98eacfa5ebf83440e8c6a61d0f60fa380b");
    Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.TEXT,"IBM Watson won the Jeopardy television show hosted by Alex Trebek");
    DocumentSentiment sentiment = service.getSentiment(params).execute();
    System.out.println("Sentiment: " + sentiment);    
    Entities entities = service.getEntities(params).execute();
    System.out.println("Entities: " + entities);    
  }
}