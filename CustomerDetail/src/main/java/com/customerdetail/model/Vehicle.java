package com.customerdetail.model;

import java.util.HashMap;
import java.util.Map;

public class Vehicle {

private String internalVehicleId;
private String vin;
private String region;
private String createdDateTime;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getInternalVehicleId() {
return internalVehicleId;
}

public void setInternalVehicleId(String internalVehicleId) {
this.internalVehicleId = internalVehicleId;
}

public String getVin() {
return vin;
}

public void setVin(String vin) {
this.vin = vin;
}

public String getRegion() {
return region;
}

public void setRegion(String region) {
this.region = region;
}

public String getCreatedDateTime() {
return createdDateTime;
}

public void setCreatedDateTime(String createdDateTime) {
this.createdDateTime = createdDateTime;
}

@Override
public String toString() {
return "Vehicle : " + vin;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}