package com.ibm.watson.language;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.RetrieveAndRank;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrCluster;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrCluster.Status;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrClusterOptions;

public class CreateASolrClusterExample {
	  public static void main(String[] args) throws InterruptedException {

	    // 1 create the service
	    RetrieveAndRank service = new RetrieveAndRank();
	    service.setUsernameAndPassword("ab9611d7-a226-42a0-bc22-11549a3f727a", "BY4Fpgw8olil");

	    // 2 create the Solr Cluster
	    SolrClusterOptions options = new SolrClusterOptions("temp", 1);
	    SolrCluster cluster = service.createSolrCluster(options).execute();
	    System.out.println("SolrCluster: " + cluster);

	    // 2 wait until the Solr Cluster is available
	    while (cluster.getStatus() == Status.NOT_AVAILABLE) {
	      Thread.sleep(10000); // sleep 10 seconds
	      cluster = service.getSolrCluster(cluster.getId()).execute();
	      System.out.println("SolrCluster status: " + cluster.getStatus());
	    }

	    // 3 list Solr Clusters
	    System.out.println("Solr clusters: " + service.getSolrClusters().execute());

	  }
	}