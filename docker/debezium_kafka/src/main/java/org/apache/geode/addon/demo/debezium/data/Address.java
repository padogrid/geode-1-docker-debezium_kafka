package org.apache.geode.addon.demo.debezium.data;

import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

public class Address implements PdxSerializable
{
	private long id;
	private long customerId;
	private String street;
	private String city;
	private String state;
	private long zip;
	private String type;

	public Address()
	{
	}

	public void setId(long id) {
		this.id=id;
	}

	public long getId() {
		return this.id;
	}

	public void setCustomerId(long customerId) {
		this.customerId=customerId;
	}

	public long getCustomerId() {
		return this.customerId;
	}

	public void setStreet(String street) {
		this.street=street;
	}

	public String getStreet() {
		return this.street;
	}

	public void setCity(String city) {
		this.city=city;
	}

	public String getCity() {
		return this.city;
	}

	public void setState(String state) {
		this.state=state;
	}

	public String getState() {
		return this.state;
	}

	public void setZip(long zip) {
		this.zip=zip;
	}

	public long getZip() {
		return this.zip;
	}

	public void setType(String type) {
		this.type=type;
	}

	public String getType() {
		return this.type;
	}
	
	@Override
	public void toData(PdxWriter writer) {
		writer.writeLong("id", id);
		writer.writeLong("customerId", customerId);
		writer.writeString("street", street);
		writer.writeString("city", city);
		writer.writeString("state", state);
		writer.writeLong("zip", zip);
		writer.writeString("type", type);
	}

	@Override
	public void fromData(PdxReader reader) {
		this.id = reader.readLong("id");
		this.customerId = reader.readLong("customerId");
		this.street = reader.readString("street");
		this.city = reader.readString("city");
		this.state = reader.readString("state");
		this.zip = reader.readLong("zip");
		this.type = reader.readString("type");
	}
    
	@Override
	public String toString()
	{
		return "[city=" + this.city
			 + ", customerId=" + this.customerId
			 + ", id=" + this.id
			 + ", state=" + this.state
			 + ", street=" + this.street
			 + ", type=" + this.type
			 + ", zip=" + this.zip + "]";
	}
}
