package com.parking.system.services;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.parking.system.interfaces.DataCollectionService;
import com.parking.system.interfaces.domain.ParkingEventRequest;
import com.parking.system.interfaces.domain.ParkingUpdateResponse;
import com.parking.system.interfaces.exception.CreateServiceException;
import com.parking.system.interfaces.exception.ReadServiceException;
import com.parking.system.interfaces.exception.ServiceException;
import com.parking.system.repository.Repository;
import com.parking.system.repository.domain.ParkingEventEntity;
import com.parking.system.repository.domain.ParkingEventPK;
import com.parking.system.repository.exception.AlreadyExistsDomainException;
import com.parking.system.repository.exception.CreateDomainException;
import com.parking.system.repository.exception.FinderDomainException;

public class DataCollectionServiceImpl implements DataCollectionService {

	Logger logger = Logger.getLogger(DataCollectionServiceImpl.class.getName());

	@Autowired
	private Repository repository;

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, timeout = 60)
	public void processParkingEvent(ParkingEventRequest serviceRequest) throws CreateServiceException,
			ServiceException {
		logger.log(Level.FINE, "request recieved : {0}", serviceRequest);

		// business logic goes here
		ParkingEventEntity entity = new ParkingEventEntity();
		entity.setKey(new ParkingEventPK(serviceRequest.getSensorId(), serviceRequest.getLotName(), serviceRequest.getTime()));
		entity.setStatus(serviceRequest.getStatus());

		try {
			repository.createParkingEvent(entity);
		} catch (AlreadyExistsDomainException e) {
			logger.log(Level.FINE, "entity already present");
		} catch (CreateDomainException e) {
			logger.log(Level.SEVERE, "failed to create entity : {0}",
					e.getMessage());
			throw new CreateServiceException("failed to create entity", e);
		}

	}

	@Override
	public ParkingUpdateResponse getParkingEvent(ParkingEventRequest req)
			throws ReadServiceException, ServiceException {
		try {
			ParkingEventEntity found = repository.findParkingEventsByKey(new ParkingEventPK(req.getSensorId(), req.getLotName(), req.getTime()));
			ParkingUpdateResponse response = new ParkingUpdateResponse();
			response.setSensorId(found.getKey().getSensorId());
			response.setLotName(found.getKey().getLotName());
			response.setStatus(found.getStatus());
			response.setTime(found.getKey().getTime());
			return response;
		} catch (FinderDomainException e) {
			logger.log(Level.SEVERE, "entity not found : {0}", e.getMessage());
			throw new CreateServiceException("entity not found", e);
		}
	}

}
