package com.ibm.watson.language;

import com.ibm.watson.developer_cloud.concept_insights.v2.ConceptInsights;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Annotations;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Graph;

public class ConceptInsightsExample {

	  public static void main(String[] args) {
	    ConceptInsights service = new ConceptInsights();
	    service.setUsernameAndPassword("a2f2c497-19a2-4317-b90c-b6a633ae874c", "VHw8dqib0Qns");

	    Annotations annotations =
	      service.annotateText(Graph.WIKIPEDIA,
	        "IBM Watson won the Jeopardy television show hosted by Alex Trebek").execute();

	    System.out.println(annotations);
	  }

	}