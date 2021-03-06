package com.ibm.watson.language;


import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;
import com.ibm.watson.developer_cloud.language_translation.v2.model.Language;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;

public class LanguageTranslationExample {

  public static void main(String[] args) {
    LanguageTranslation service = new LanguageTranslation();
    service.setUsernameAndPassword("44147fb6-d719-42f1-802e-c1939b43c90f", "qKLU42iUalbL");

    TranslationResult translationResult = service.translate("hello", Language.ENGLISH, Language.SPANISH).execute();

    System.out.println(translationResult);
  }

}