package org.apache.geode.addon.demo.debezium.data;

import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

public class Customer implements PdxSerializable
{
	private long id;
	private String firstName;
	private String lastName;
	private String email;

	public Customer()
	{
	}

	public void setId(long id) {
		this.id=id;
	}

	public long getId() {
		return this.id;
	}

	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setLastName(String lastName) {
		this.lastName=lastName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setEmail(String email) {
		this.email=email;
	}

	public String getEmail() {
		return this.email;
	}

	@Override
	public void toData(PdxWriter writer) {
		writer.writeLong("id", id);
		writer.writeString("firstName", firstName);
		writer.writeString("lastName", lastName);
		writer.writeString("email", email);
	}

	@Override
	public void fromData(PdxReader reader) {
		this.id = reader.readLong("id");
		this.firstName = reader.readString("firstName");
		this.lastName = reader.readString("lastName");
		this.email = reader.readString("email");
	}

	@Override
	public String toString()
	{
		return "[email=" + this.email
			 + ", firstName=" + this.firstName
			 + ", id=" + this.id
			 + ", lastName=" + this.lastName + "]";
	}
}
