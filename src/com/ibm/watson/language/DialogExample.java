package com.ibm.watson.language;

import java.util.List;

import com.ibm.watson.developer_cloud.dialog.v1.DialogService;
import com.ibm.watson.developer_cloud.dialog.v1.model.Dialog;
import com.ibm.watson.developer_cloud.http.ServiceCallback;

import jersey.repackaged.jsr166e.CompletableFuture;

public class DialogExample {
  public static void main(String[] args) throws Exception{
    DialogService service = new DialogService();
    service.setUsernameAndPassword("8d2ca36f-7631-4ac7-bb7c-cc7aff177baf", "0y0P60FDGgdJ");

    // sync
    List<Dialog> dialogs = service.getDialogs().execute();
    System.out.println(dialogs);
    
    
    // async
    service.getDialogs().enqueue(new ServiceCallback<List<Dialog>>() {
      @Override
      public void onResponse(List<Dialog> response) {
        System.out.println(response);
      }

      @Override
      public void onFailure(Exception e) {
      }}
    );

    // rx callback
    service.getDialogs().rx().thenApply(new CompletableFuture.Fun<List<Dialog>, Integer>() {
      @Override
      public Integer apply(List<Dialog> dialogs) {
        return dialogs.size();
      }
    }).thenAccept(new CompletableFuture.Action<Integer>() {
      @Override
      public void accept(Integer integer) {
        System.out.println(integer);
      }
    });

    // rx async callback
    service.getDialogs().rx().thenApplyAsync(new CompletableFuture.Fun<List<Dialog>, Integer>() {
      @Override
      public Integer apply(List<Dialog> dialogs) {
        return dialogs.size();
      }
    }).thenAccept(new CompletableFuture.Action<Integer>() {
      @Override
      public void accept(Integer size) {
        System.out.println(size);
      }
    });

    // rx sync
    Integer size=service.getDialogs().rx().get().size();
    System.out.println(size);
  }

}