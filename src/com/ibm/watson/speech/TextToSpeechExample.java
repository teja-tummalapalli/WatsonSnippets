package com.ibm.watson.speech;



import java.util.List;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;

public class TextToSpeechExample {


  public static void main(String[] args) {
    TextToSpeech service = new TextToSpeech();
    service.setUsernameAndPassword("b2e32c2e-b2bd-4bdb-b826-0b4b74094cad", "58BJnsSnuIQa");

    List<Voice> voices = service.getVoices().execute();
    System.out.println(voices);
  }

}