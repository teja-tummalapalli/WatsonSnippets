package com.ibm.watson.language;


import java.io.File;

import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.RetrieveAndRank;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.Ranker;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.Ranker.Status;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.Ranking;

/**
 * Example of how to create a {@link Ranking} with {@link RetrieveAndRank}.
 */
public class CreateARankerExample {
  public static void main(String[] args) throws InterruptedException {
    // 1 create the service
    RetrieveAndRank service = new RetrieveAndRank();
    service.setUsernameAndPassword("<service>", "<password>");

    // 2 create a ranker
    Ranker ranker = service.createRanker("example-ranker-1", new File("<path_to_training_csv>")).execute();
    System.out.println("ranker: " + ranker);

    // 3 wait until is trained
    while (ranker.getStatus() == Status.TRAINING) {
      Thread.sleep(4000); // sleep 4 seconds
      ranker = service.getRankerStatus(ranker.getId()).execute();
      System.out.println("ranker status: " + ranker.getStatus());
    }

    // 4 rank answers
    Ranking ranking = service.rank(ranker.getId(), new File("<path_to_answer_csv>"), 5).execute();
    System.out.println("ranking: " + ranking);

    // 5 delete ranker
    service.deleteRanker(ranker.getId());

  }
}