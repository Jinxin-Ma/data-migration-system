package com.jd.batch.domain;

import java.util.Date;

/**
 * Created by majinxin1 on 2017/8/27.
 * 订单表实体类
 */
public class Order {

	/**
	 * 主键ID
	 */
	private Long id ;

	/**
	 * 订单编号
	 */
	private String orderNumber ;

	/**
	 * 用户ID
	 */
	private Long uid ;

	/**
	 * 支付价格
	 */
	private Double payPrice ;

	/**
	 * 是否支付：-1未支付，1支付
	 */
	private int isPay ;

	/**
	 * 支付时间
	 */
	private Date payTime ;

	/**
	 * 是否收货：-1未收货，1已收货
	 */
	private int isShip ;

	/**
	 * 发货时间
	 */
	private Date shipTime ;

	/**
	 * 是否已经发货：-1未发货，1已发货
	 */
	private int isReceipt ;

	/**
	 * 收货时间
	 */
	private Date receiptTime ;

	/**
	 * 快递单号
	 */
	private String shipNumber ;

	/**
	 * 订单状态:-1删除订单，1正常订单
	 */
	private int status ;

	/**
	 * 创建时间
	 */
	private Date created ;

	/**
	 *  修改时间
	 */
	private Date modified ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Double getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(Double payPrice) {
		this.payPrice = payPrice;
	}

	public int getIsPay() {
		return isPay;
	}

	public void setIsPay(int isPay) {
		this.isPay = isPay;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public int getIsShip() {
		return isShip;
	}

	public void setIsShip(int isShip) {
		this.isShip = isShip;
	}

	public Date getShipTime() {
		return shipTime;
	}

	public void setShipTime(Date shipTime) {
		this.shipTime = shipTime;
	}

	public int getIsReceipt() {
		return isReceipt;
	}

	public void setIsReceipt(int isReceipt) {
		this.isReceipt = isReceipt;
	}

	public Date getReceiptTime() {
		return receiptTime;
	}

	public void setReceiptTime(Date receiptTime) {
		this.receiptTime = receiptTime;
	}

	public String getShipNumber() {
		return shipNumber;
	}

	public void setShipNumber(String shipNumber) {
		this.shipNumber = shipNumber;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", orderNumber='" + orderNumber + '\'' +
				", uid=" + uid +
				", payPrice=" + payPrice +
				", isPay=" + isPay +
				", payTime=" + payTime +
				", isShip=" + isShip +
				", shipTime=" + shipTime +
				", isReceipt=" + isReceipt +
				", receiptTime=" + receiptTime +
				", shipNumber='" + shipNumber + '\'' +
				", status=" + status +
				", created=" + created +
				", modified=" + modified +
				'}';
	}
}
