package com.bracketpy.website.utils;

public class ApiEndPoint {
	String method;
	String description;
	String route;
	
	String payload_Description;
	String payload_Body;
	String payload_Format;
	
	String response_Body;
	String response_Format;
	
	String name;

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getPayload_Description() {
		return payload_Description;
	}

	public void setPayload_Description(String payload_Description) {
		this.payload_Description = payload_Description;
	}

	public String getPayload_Body() {
		return payload_Body;
	}

	public void setPayload_Body(String payload_Body) {
		this.payload_Body = payload_Body;
	}

	public String getPayload_Format() {
		return payload_Format;
	}

	public void setPayload_Format(String payload_Format) {
		this.payload_Format = payload_Format;
	}

	public String getResponse_Body() {
		return response_Body;
	}

	public void setResponse_Body(String response_Body) {
		this.response_Body = response_Body;
	}

	public String getResponse_Format() {
		return response_Format;
	}

	public void setResponse_Format(String response_Format) {
		this.response_Format = response_Format;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ApiEndPoint(String method, String description, String route,
			String payload_Description, String payload_Body,
			String payload_Format, String response_Body,
			String response_Format, String name) {
		super();
		this.method = method;
		this.description = description;
		this.route = route;
		this.payload_Description = payload_Description;
		this.payload_Body = payload_Body;
		this.payload_Format = payload_Format;
		this.response_Body = response_Body;
		this.response_Format = response_Format;
		this.name = name;
	}
	
}
