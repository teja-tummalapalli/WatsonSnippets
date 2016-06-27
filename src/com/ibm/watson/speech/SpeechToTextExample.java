package com.ibm.watson.speech;


import java.io.File;

import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;


/**
 * Recognize a sample wav file and print the transcript into the console output. Make sure you are
 * using UTF-8 to print messages; otherwise, you will see question marks.
 */
public class SpeechToTextExample {

  public static void main(String[] args) {
    SpeechToText service = new SpeechToText();
    service.setUsernameAndPassword("<username>", "<password>");

    File audio = new File("src/test/resources/speech_to_text/sample1.wav");
    SpeechResults transcript = service.recognize(audio).execute();

    System.out.println(transcript);
  }
}