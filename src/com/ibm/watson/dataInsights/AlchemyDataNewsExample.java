package com.ibm.watson.dataInsights;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyDataNews;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentsResult;

public class AlchemyDataNewsExample {
	 public static void main(String[] args) {
		    AlchemyDataNews service = new AlchemyDataNews();
		    service.setApiKey("5fc91e98eacfa5ebf83440e8c6a61d0f60fa380b");
		    Map<String, Object> params = new HashMap<String, Object>();
		    String[] fields =
		        new String[] {"enriched.url.title", "enriched.url.url", "enriched.url.author",
		            "enriched.url.publicationDate", "enriched.url.enrichedTitle.entities",
		            "enriched.url.enrichedTitle.docSentiment"};
		    params.put(AlchemyDataNews.RETURN, StringUtils.join(fields, ","));
		    params.put(AlchemyDataNews.START, "1440720000");
		    params.put(AlchemyDataNews.END, "1441407600");
		    params.put(AlchemyDataNews.COUNT, 7);

		    //Query on adjacent nested fields: 
		    params.put("q.enriched.url.enrichedTitle.entities.entity", "|text=IBM,type=company|");
		    params.put("q.enriched.url.enrichedTitle.docSentiment.type", "positive");
		    params.put("q.enriched.url.enrichedTitle.taxonomy.taxonomy_.label", "technology and computing");

		    DocumentsResult result = service.getNewsDocuments(params).execute();

		    System.out.println(result);
		  }
}
