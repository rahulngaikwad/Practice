package com.parking.system.rest;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;


import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.parking.system.interfaces.domain.ParkingEventRequest;
import com.parking.system.interfaces.domain.ParkingUpdateResponse;
import com.parking.system.interfaces.exception.CreateServiceException;
import com.parking.system.interfaces.exception.ServiceException;

public class SampleRestClient{
 
	private static final String URL_SERVICE_BASE = "/parking";

	private static final String URL_SAMPLE_SERVICE_GET = URL_SERVICE_BASE
			+ "/get";

	private static final String URL_SAMPLE_SERVICE_POST = URL_SERVICE_BASE
			+ "/post";
	
	private Client client;
	
    private WebTarget webTarget =  getClient().target("http://localhost:8080/ParkingSystemRestApplication");
	 
	public ParkingUpdateResponse test() throws  Exception {
		Response response = webTarget.path("/test")
	                        .request().get();
		ParkingUpdateResponse serviceResponse = response.readEntity(ParkingUpdateResponse.class);
		return serviceResponse;
	}
	
	public ParkingUpdateResponse getService() throws CreateServiceException, ServiceException {
		Response response = webTarget.path(URL_SAMPLE_SERVICE_GET)
	                        .request().get();
		ParkingUpdateResponse serviceResponse = response.readEntity(ParkingUpdateResponse.class);
		return serviceResponse;
	}

	public ParkingUpdateResponse doService(ParkingEventRequest serviceRequest)
			throws CreateServiceException, ServiceException {
		Response response = webTarget.path(URL_SAMPLE_SERVICE_POST)
	                        .request().get();
		ParkingUpdateResponse serviceResponse = response.readEntity(ParkingUpdateResponse.class);
		return serviceResponse;
	}
	
	
	private Client getClient(){
		if(client == null){
		  ClientConfig clientConfig = new ClientConfig();
		  clientConfig.register(JacksonJsonProvider.class);
		  client=ClientBuilder.newClient(clientConfig);
		}
		 return client;
	}
}
