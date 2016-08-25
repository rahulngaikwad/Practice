package com.parking.system.rest;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import com.parking.system.interfaces.DataCollectionService;
import com.parking.system.interfaces.domain.ParkingEventRequest;
import com.parking.system.interfaces.domain.ParkingStatus;
import com.parking.system.interfaces.domain.ParkingUpdateResponse;

@Component
@Path("/")
public class ParkingSystemRestApplication {

	private static final String JSON = "json";

	public static final MediaType MEDIA_TYPE_JSON = new MediaType(
			"application", JSON);

	public static final String APPLICATION_JSON = "application/" + JSON;

	private static final String URL_SERVICE_BASE = "parking";

	private static final String URL_SAMPLE_SERVICE_GET = URL_SERVICE_BASE
			+ "/get";

	private static final String URL_SAMPLE_SERVICE_POST = URL_SERVICE_BASE
			+ "/post";

	private DataCollectionService service;

	@GET
	@Produces(APPLICATION_JSON)
	@Consumes(APPLICATION_JSON)
	@Path("/test")
	public Response test() throws Exception {
		ParkingEventRequest serviceRequest = new ParkingEventRequest();
		serviceRequest.setSensorId("765344");
		serviceRequest.setLotName("H");
		serviceRequest.setTime(new Date());
		serviceRequest.setStatus(ParkingStatus.FREE);
		getService().processParkingEvent(serviceRequest);
		ParkingUpdateResponse serviceResponse = getService().getParkingEvent(
				serviceRequest);
		return Response.status(Status.OK).entity(serviceResponse)
				.type(MEDIA_TYPE_JSON).build();
	}

	@GET
	@Produces(APPLICATION_JSON)
	@Consumes(APPLICATION_JSON)
	@Path(value = URL_SAMPLE_SERVICE_GET)
	public Response getSomething(ParkingEventRequest serviceRequest)
			throws Exception {
		ParkingUpdateResponse serviceResponse = getService().getParkingEvent(
				serviceRequest);
		return Response.status(Status.OK).entity(serviceResponse)
				.type(MEDIA_TYPE_JSON).build();
	}

	@POST
	@Produces(APPLICATION_JSON)
	@Consumes(APPLICATION_JSON)
	@Path(value = URL_SAMPLE_SERVICE_POST)
	public Response postSomething(ParkingEventRequest serviceRequest)
			throws Exception {
		getService().processParkingEvent(serviceRequest);
		return Response.status(Status.CREATED).type(MEDIA_TYPE_JSON).build();
	}

	public DataCollectionService getService() {
		return service;
	}

	@Required
	public void setService(DataCollectionService service) {
		this.service = service;
	}

}
