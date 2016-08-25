package com.parking.system.service;


import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.parking.system.interfaces.domain.ParkingEventRequest;
import com.parking.system.interfaces.domain.ParkingStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/serviceApplicationContext.xml","/persistanceContext.xml"})
public class ServiceImplTest {

	@Autowired
	private com.parking.system.interfaces.DataCollectionService dataCollectionService; 
	   
	@Test
	public void test() throws Exception{
		ParkingEventRequest en = new ParkingEventRequest();
		en.setLotName(RandomStringUtils.randomAlphabetic(2));
		en.setSensorId(RandomStringUtils.randomNumeric(6));
		en.setStatus(ParkingStatus.PARKED);
        en.setTime(new Date());
        dataCollectionService.processParkingEvent(en);
        
        dataCollectionService.getParkingEvent(en);
	}
}
