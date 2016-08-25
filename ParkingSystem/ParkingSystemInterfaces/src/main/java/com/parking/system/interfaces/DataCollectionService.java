package com.parking.system.interfaces;

import com.parking.system.interfaces.domain.ParkingEventRequest;
import com.parking.system.interfaces.domain.ParkingUpdateResponse;
import com.parking.system.interfaces.exception.CreateServiceException;
import com.parking.system.interfaces.exception.ReadServiceException;
import com.parking.system.interfaces.exception.ServiceException;


public interface DataCollectionService {
	
	public void processParkingEvent(ParkingEventRequest serviceRequest) throws CreateServiceException, ServiceException;
	
	public ParkingUpdateResponse getParkingEvent(ParkingEventRequest serviceRequest) throws ReadServiceException, ServiceException;
}
