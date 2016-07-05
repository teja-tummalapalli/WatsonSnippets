package com.ibm.watson.speech;


import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;


/**
 * Recognize a sample wav file and print the transcript into the console output. Make sure you are
 * using UTF-8 to print messages; otherwise, you will see question marks.
 */
public class SpeechToTextExample {

  public static void main(String[] args) throws IOException {
    SpeechToText service = new SpeechToText();
    service.setUsernameAndPassword("f0d59211-e88f-4b14-b2b0-fd4d1f7df231", "YNA4VcN1AaXY");
   
    
    URL url = new URL("https://raw.githubusercontent.com/watson-developer-cloud/java-sdk/master/src/test/resources/speech_to_text/sample1.wav");
    File audio = new File("test");
    FileUtils.copyURLToFile(url, audio);
    
    RecognizeOptions options = new RecognizeOptions.Builder().contentType(HttpMediaType.AUDIO_WAV).build();
    SpeechResults transcript = service.recognize(audio,options).execute();
    System.out.println(transcript);
  }
}