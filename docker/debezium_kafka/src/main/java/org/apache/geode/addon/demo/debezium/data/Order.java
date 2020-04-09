package org.apache.geode.addon.demo.debezium.data;

import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

public class Order implements PdxSerializable
{
	private long orderNumber;
	private String orderDate;
	private long purchaser;
	private long quantity;
	private long productId;

	public Order()
	{
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber=orderNumber;
	}

	public long getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate=orderDate;
	}

	public String getOrderDate() {
		return this.orderDate;
	}

	public void setPurchaser(long purchaser) {
		this.purchaser=purchaser;
	}

	public long getPurchaser() {
		return this.purchaser;
	}

	public void setQuantity(long quantity) {
		this.quantity=quantity;
	}

	public long getQuantity() {
		return this.quantity;
	}

	public void setProductId(long productId) {
		this.productId=productId;
	}

	public long getProductId() {
		return this.productId;
	}

	@Override
	public void toData(PdxWriter writer) {
		writer.writeLong("orderNumber", orderNumber);
		writer.writeString("orderDate", orderDate);
		writer.writeLong("purchaser", purchaser);
		writer.writeLong("quantity", quantity);
		writer.writeLong("productId", productId);
	}

	@Override
	public void fromData(PdxReader reader) {
		this.orderNumber = reader.readLong("orderNumber");
		this.orderDate = reader.readString("orderDate");
		this.purchaser = reader.readLong("purchaser");
		this.quantity = reader.readLong("quantity");
		this.productId = reader.readLong("productId");
	}
    
	@Override
	public String toString()
	{
		return "[orderDate=" + this.orderDate
			 + ", orderNumber=" + this.orderNumber
			 + ", productId=" + this.productId
			 + ", purchaser=" + this.purchaser
			 + ", quantity=" + this.quantity + "]";
	}
}
