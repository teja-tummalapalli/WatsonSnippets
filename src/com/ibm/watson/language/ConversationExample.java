package com.ibm.watson.language;

import java.util.Map;

import com.ibm.watson.developer_cloud.conversation.v1_experimental.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1_experimental.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1_experimental.model.MessageResponse;
import com.ibm.watson.developer_cloud.http.ServiceCallback;

import jersey.repackaged.jsr166e.CompletableFuture;

public class ConversationExample {

	  public static void main(String[] args) throws Exception {
	    ConversationService service = new ConversationService(ConversationService.VERSION_DATE_2016_05_19);
	    service.setUsernameAndPassword("82468892-41c9-461d-b638-769b3bda0c99", "mZabMdQyXEtd");

	    // sync
	    MessageRequest newMessage = new MessageRequest.Builder().inputText("What can you do?").build();
	    MessageResponse response = service.message("e33d0e94-550d-404c-8afd-ec8e0dfed6c4", newMessage).execute();
	    System.out.println(response);
	  }

	}