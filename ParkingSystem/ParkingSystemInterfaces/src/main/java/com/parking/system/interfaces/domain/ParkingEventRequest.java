package com.parking.system.interfaces.domain;

import java.io.Serializable;
import java.util.Date;

public class ParkingEventRequest implements Serializable {

	private static final long serialVersionUID = 4606079756220761023L;
	
	private String sensorId;
	
	private String lotName;

	private ParkingStatus status;
	
	private Date time;

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

	public ParkingStatus getStatus() {
		return status;
	}

	public void setStatus(ParkingStatus status) {
		this.status = status;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "ParkingUpdateRequest [sensorId=" + sensorId + ", lotName=" + lotName
				+ ", status=" + status + ", time=" + time + "]";
	}
}
