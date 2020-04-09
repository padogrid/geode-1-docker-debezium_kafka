package org.apache.geode.addon.demo.debezium.data;

import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

public class Product implements PdxSerializable
{
	private long id;
	private String name;
	private String description;
	private double weight;

	public Product()
	{
	}

	public void setId(long id) {
		this.id=id;
	}

	public long getId() {
		return this.id;
	}

	public void setName(String name) {
		this.name=name;
	}

	public String getName() {
		return this.name;
	}

	public void setDescription(String description) {
		this.description=description;
	}

	public String getDescription() {
		return this.description;
	}

	public void setWeight(double weight) {
		this.weight=weight;
	}

	public double getWeight() {
		return this.weight;
	}

	@Override
	public void toData(PdxWriter writer) {
		writer.writeLong("id", id);
		writer.writeString("name", name);
		writer.writeString("description", description);
		writer.writeDouble("weight", weight);
	}

	@Override
	public void fromData(PdxReader reader) {
		this.id = reader.readLong("id");
		this.name = reader.readString("name");
		this.description = reader.readString("description");
		this.weight = reader.readDouble("weight");
	}
	
	@Override
	public String toString()
	{
		return "[description=" + this.description
			 + ", id=" + this.id
			 + ", name=" + this.name
			 + ", weight=" + this.weight + "]";
	}
}
