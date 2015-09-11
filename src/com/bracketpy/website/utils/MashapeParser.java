package com.bracketpy.website.utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MashapeParser {

	private String fetchData() {

		String url = "https://api-new.mashape.com/v1/accounts/bracketPy/apis/brac"
				+ "ketPy/versions/current?arrayCount=true&include=endpoints&inclu"
				+ "de=endpoints.headers&include=endpoints.routeparameters&include"
				+ "=endpoints.parameters&include=endpoints.payload&include=endpoi"
				+ "nts.response&include=endpoints.response.headers&include=endpoi"
				+ "nts.payload.headers&include=endpoints.group";

		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			
			con.setRequestMethod("GET");
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			return response.toString();
		} catch (Exception e) {
			return "";
		}
	}
	
	public List<ApiEndPoint> mashapeAPIs() {
		String data = fetchData();
		
		List<ApiEndPoint> endpoints = new ArrayList<ApiEndPoint>();
		
		ApiEndPoint additionToList;
		
		JsonElement jelement = new JsonParser().parse(data);
		JsonObject jobject = jelement.getAsJsonObject();
		JsonArray jarray = jobject.getAsJsonObject("endpoints").getAsJsonArray("data");
		
		JsonObject iterableObject;
		
		System.out.println(jarray.size());
		for (JsonElement jsonElement : jarray) {
			
			iterableObject = jsonElement.getAsJsonObject();
			
			String method = iterableObject.get("method").toString();
			String description = iterableObject.get("description").toString();
			String route = iterableObject.get("route").toString();
			String name = iterableObject.get("name").toString();
			
			String payload_Description = iterableObject
					.getAsJsonObject("payload").get("description")
					.toString();
			String payload_Body = iterableObject
					.getAsJsonObject("payload").get("body")
					.toString();
			String payload_Format = iterableObject
					.getAsJsonObject("payload").get("format")
					.toString();
			
			String response_Body = iterableObject
					.getAsJsonObject("response").get("body")
					.toString();
			String response_Format = iterableObject
					.getAsJsonObject("payload").get("format")
					.toString();
			
			additionToList = new ApiEndPoint(method, description,
					route, payload_Description, payload_Body,
					payload_Format, response_Body,
					response_Format, name);
			
			endpoints.add(additionToList);
			
		}
		
		return endpoints;
	}
}
