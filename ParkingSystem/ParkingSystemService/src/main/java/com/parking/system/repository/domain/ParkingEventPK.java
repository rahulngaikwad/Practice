package com.parking.system.repository.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class ParkingEventPK implements Serializable{

	private static final long serialVersionUID = 990903227919259157L;

	private String sensorId;
	
	private String lotName;

	private Date time;
	
	
	public ParkingEventPK() {
		super();
	}
	
	public ParkingEventPK(String sensorId, String lotName, Date time) {
		super();
		this.sensorId = sensorId;
		this.lotName = lotName;
		this.time = time;
	}

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	public String getLotName() {
		return lotName;
	}

	public void setLotName(String lotName) {
		this.lotName = lotName;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "ParkingEventPK [sensorId=" + sensorId + ", lotName="
				+ lotName + ", time=" + time + "]";
	}
}
