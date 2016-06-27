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
	    service.setUsernameAndPassword("<username>", "<password>");

	    // sync
	    MessageRequest newMessage = new MessageRequest.Builder().inputText("Hi").build();
	    MessageResponse response = service.message("<workspace-id>", newMessage).execute();
	    System.out.println(response);


	    // async
	    service.message("<workspace-id>", newMessage).enqueue(new ServiceCallback<MessageResponse>() {
	      @Override
	      public void onResponse(MessageResponse response) {
	        System.out.println(response);
	      }

	      @Override
	      public void onFailure(Exception e) {}
	    });

	    // rx callback
	    service.message("<workspace-id>", newMessage).rx()
	        .thenApply(new CompletableFuture.Fun<MessageResponse, Map<String, Object>>() {
	          @Override
	          public Map<String, Object> apply(MessageResponse message) {
	            return message.getOutput();
	          }
	        }).thenAccept(new CompletableFuture.Action<Map<String, Object>>() {
	          @Override
	          public void accept(Map<String, Object> output) {
	            System.out.println(output);
	          }
	        });

	    // rx async callback
	    service.message("<workspace-id>", newMessage).rx()
	        .thenApplyAsync(new CompletableFuture.Fun<MessageResponse, Map<String, Object>>() {
	          @Override
	          public Map<String, Object> apply(MessageResponse message) {
	            return message.getOutput();
	          }
	        }).thenAccept(new CompletableFuture.Action<Map<String, Object>>() {
	          @Override
	          public void accept(Map<String, Object> output) {
	            System.out.println(output);
	          }
	        });

	    // rx sync
	    MessageResponse rxMessageResponse = service.message("<workspace-id>", newMessage).rx().get();
	    System.out.println(rxMessageResponse);
	  }

	}