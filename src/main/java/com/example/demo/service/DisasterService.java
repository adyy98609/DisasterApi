package com.example.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
//import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Service;

import com.example.demo.model.DisasterSummaries;
import com.google.gson.Gson;

@Service
public class DisasterService {
	
String csvFile = "src//main//resources//DisasterDeclarationsSummaries.csv";
	 
    @SuppressWarnings("unchecked")
	public String getDisasterSummaries() throws IOException {

          
           Object file=Files.readAllLines(Paths.get(csvFile)).stream()
           .map(s -> new DisasterSummaries(s.split("")[0], s.split(",")[1], s.split(",")[2], s.split(",")[3],
                        s.split(",")[4], s.split(",")[5], s.split(",")[6], s.split(",")[7], s.split(",")[8],
                        s.split(",")[9], s.split(",")[10], s.split(",")[11], s.split(",")[12], s.split(",")[13],
                        s.split(",")[14], s.split(",")[15], s.split(",")[16], s.split(",")[17]))
                        .collect(Collectors.toList());

           JSONArray objects = new JSONArray();         
           objects.add(file);
           String data=null;
           Gson gson=new Gson();
           data=gson.toJson(objects);
           //System.out.println("check "+objects);
           return data;
    }
    
	@SuppressWarnings("unchecked")
	public DisasterSummaries getDistrSmryByType(String disasterType)throws IOException {
    	
		 Object file=Files.readAllLines(Paths.get(csvFile)).stream()
		           .map(s -> new DisasterSummaries(s.split("")[0], s.split(",")[1], s.split(",")[2], s.split(",")[3],
		                        s.split(",")[4], s.split(",")[5], s.split(",")[6], s.split(",")[7], s.split(",")[8],
		                        s.split(",")[9], s.split(",")[10], s.split(",")[11], s.split(",")[12], s.split(",")[13],
		                        s.split(",")[14], s.split(",")[15], s.split(",")[16], s.split(",")[17]))
		                        .collect(Collectors.toList());

		           JSONArray objects = new JSONArray();         
		           objects.add(file);
		           String data=null;
		           Gson gson=new Gson();
		           data=gson.toJson(objects);
        List<DisasterSummaries> filterList=new ArrayList<DisasterSummaries>();
        DisasterSummaries summaries=new DisasterSummaries();
        summaries.setData(data);
        
        filterList.add(summaries);
        System.out.println("check"+filterList);
        for(DisasterSummaries summariesData:filterList) {
        	if(summariesData.getDisasterType()==disasterType){
        		
        		return summariesData;
        	}
        }
        
    	return null;
    }
  public String ping()
  {
	  return "pong";
  }
}
