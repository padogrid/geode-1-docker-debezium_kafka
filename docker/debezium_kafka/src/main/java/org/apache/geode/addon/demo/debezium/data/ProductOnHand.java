package org.apache.geode.addon.demo.debezium.data;

import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

public class ProductOnHand implements PdxSerializable
{
	private long productId;
	private long quantity;

	public ProductOnHand()
	{
	}

	public void setProductId(long productId) {
		this.productId=productId;
	}

	public long getProductId() {
		return this.productId;
	}

	public void setQuantity(long quantity) {
		this.quantity=quantity;
	}

	public long getQuantity() {
		return this.quantity;
	}

	@Override
	public void toData(PdxWriter writer) {
		writer.writeLong("productId", productId);
		writer.writeLong("quantity", quantity);
	}

	@Override
	public void fromData(PdxReader reader) {
		this.productId = reader.readLong("productId");
		this.quantity = reader.readLong("quantity");
	}
    
	@Override
	public String toString()
	{
		return "[productId=" + this.productId
			 + ", quantity=" + this.quantity + "]";
	}
}
