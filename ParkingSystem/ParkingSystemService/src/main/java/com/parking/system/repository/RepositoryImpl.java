package com.parking.system.repository;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.parking.system.repository.domain.ParkingEventEntity;
import com.parking.system.repository.domain.ParkingEventPK;
import com.parking.system.repository.exception.AlreadyExistsDomainException;
import com.parking.system.repository.exception.CreateDomainException;
import com.parking.system.repository.exception.FinderDomainException;
import com.parking.system.repository.exception.NoSuchEntityDomainException;

public class RepositoryImpl implements Repository {
	Logger logger = Logger.getLogger(RepositoryImpl.class.getName());

	@PersistenceContext
	private EntityManager em;

	@Override
	public void createParkingEvent(ParkingEventEntity entity)
			throws AlreadyExistsDomainException, CreateDomainException {
		logger.log(Level.FINER, "creating entity {0}", entity);
		try {
			em.persist(entity);
		} catch (EntityExistsException e) {
			logger.log(Level.INFO, "entity already exists");
			throw new AlreadyExistsDomainException("entity already exists");
		} catch (PersistenceException e) {
			logger.log(Level.SEVERE, "persistance error occured :{0}",
					e.getMessage());
			throw new CreateDomainException(
					"persistance error occured while persisting entity", e);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "persistance error occured :{0}",
					e.getMessage());
			throw new CreateDomainException(
					"error occured while persisting entity", e);
		}
		logger.log(Level.FINER, "created entity {0}", entity);
	}

	@Override
	public ParkingEventEntity findParkingEventsByKey(ParkingEventPK key) throws NoSuchEntityDomainException,
			FinderDomainException {
		logger.log(Level.FINE, "finding entity with key :{0}", key);
		try {
			ParkingEventEntity entity = em.find(ParkingEventEntity.class, key);
			if (entity == null) {
				throw new NoSuchEntityDomainException("entity not found");
			}
			return entity;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "error occured while finding entity :{0}",
					e.getMessage());
			throw new FinderDomainException(
					"error occured while finding  entity", e);
		}
	}
}
