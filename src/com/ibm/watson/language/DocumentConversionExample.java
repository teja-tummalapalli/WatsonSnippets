package com.ibm.watson.language;

import java.io.File;

import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Answers;

public class DocumentConversionExample {

  public static void main(String[] args) {
    DocumentConversion service = new DocumentConversion(DocumentConversion.VERSION_DATE_2015_12_01);
    service.setUsernameAndPassword("77c1f4a5-fcff-4407-bfef-c590adaa9066", "BLchTTXCBJk6");

    File html = new File("C:/Users/IBM_ADMIN/Desktop/Inbox/html-with-extra-content-input.htm");
    File pdf =  new File("src/test/resources/document_conversion/pdf-with-sections-input.pdf");
    File doc =  new File("src/test/resources/document_conversion/word-document-heading-input.doc");

    System.out.println("Convert html document to Answers");
    Answers htmlToAnswers = service.convertDocumentToAnswer(html).execute();
    System.out.println(htmlToAnswers);

    System.out.println("Convert pdf document to Normalized HTML");
    String normalizedHTML = service.convertDocumentToHTML(pdf).execute();
    System.out.println(normalizedHTML);

    System.out.println("Convert html document to Normalized Text");
    String normalizedText = service.convertDocumentToText(doc).execute();
    System.out.println(normalizedText);

  }
}