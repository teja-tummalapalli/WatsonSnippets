package com.ibm.watson.language;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.FileUtils;

import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Answers;

public class DocumentConversionExample {

  public static void main(String[] args) throws IOException {
    DocumentConversion service = new DocumentConversion(DocumentConversion.VERSION_DATE_2015_12_01);
    service.setUsernameAndPassword("77c1f4a5-fcff-4407-bfef-c590adaa9066", "BLchTTXCBJk6");
    
    URL url = new URL("https://raw.githubusercontent.com/watson-developer-cloud/java-sdk/master/src/test/resources/document_conversion/html-with-extra-content-input.htm");
    File html = new File("google.html");
    FileUtils.copyURLToFile(url, html);


    System.out.println("Convert html document to Answers");
    Answers htmlToAnswers = service.convertDocumentToAnswer(html).execute();
    System.out.println(htmlToAnswers);

  }
}