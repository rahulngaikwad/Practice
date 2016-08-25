package com.parking.system.repository.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import com.parking.system.interfaces.domain.ParkingStatus;

@Entity
public class ParkingEventEntity {

	@EmbeddedId
    private ParkingEventPK key;
    
	private ParkingStatus status;
	
	public ParkingStatus getStatus() {
		return status;
	}

	public void setStatus(ParkingStatus status) {
		this.status = status;
	}

	public ParkingEventPK getKey() {
		return key;
	}

	public void setKey(ParkingEventPK key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "ParkingEventEntity [sensorId=" + key.getSensorId() + ", lotName="
				+ key.getLotName() + ", time=" + key.getTime() + ", status=" + status + "]";
	}
}
