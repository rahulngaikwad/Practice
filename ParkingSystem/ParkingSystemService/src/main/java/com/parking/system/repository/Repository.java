package com.parking.system.repository;

import com.parking.system.repository.domain.ParkingEventEntity;
import com.parking.system.repository.domain.ParkingEventPK;
import com.parking.system.repository.exception.AlreadyExistsDomainException;
import com.parking.system.repository.exception.CreateDomainException;
import com.parking.system.repository.exception.FinderDomainException;
import com.parking.system.repository.exception.NoSuchEntityDomainException;

public interface Repository {

	public void createParkingEvent(ParkingEventEntity entity)
			throws AlreadyExistsDomainException, CreateDomainException;

	public ParkingEventEntity findParkingEventsByKey(ParkingEventPK key)
			throws NoSuchEntityDomainException, FinderDomainException;
}
