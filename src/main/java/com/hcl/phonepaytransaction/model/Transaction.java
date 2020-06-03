package com.hcl.phonepaytransaction.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "transaction")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	@Column
	private Date transactionDate;
	@Column
	private double transactionamount;
	private long fromMobileNumber;
	@ManyToOne(optional = false)
	@JoinColumn(name = "userId")
	private User user;
	@Column
	private long toMobileNumber;
	@Column
	private String txnMsg;

	public Transaction() {

	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getTransactionamount() {
		return transactionamount;
	}

	public void setTransactionamount(double transactionamount) {
		this.transactionamount = transactionamount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getToMobileNumber() {
		return toMobileNumber;
	}

	public void setToMobileNumber(long toMobileNumber) {
		this.toMobileNumber = toMobileNumber;
	}

	public String getTxnMsg() {
		return txnMsg;
	}

	public void setTxnMsg(String txnMsg) {
		this.txnMsg = txnMsg;
	}

	public Transaction(Date transactionDate, double transactionamount, User l, long toMobileNumber, String txnMsg) {
		super();
		this.transactionDate = transactionDate;
		this.transactionamount = transactionamount;
		this.user = l;
		this.toMobileNumber = toMobileNumber;
		this.txnMsg = txnMsg;
	}

	public Transaction(Date transactionDate, double transactionamount, long fromMobileNumber, User user,
			long toMobileNumber, String txnMsg) {
		super();
		this.transactionDate = transactionDate;
		this.transactionamount = transactionamount;
		this.fromMobileNumber = fromMobileNumber;
		this.user = user;
		this.toMobileNumber = toMobileNumber;
		this.txnMsg = txnMsg;
	}

	public Transaction(Date date, double ammount, long fromMobileNumber2, long toMobileNumber2, String string) {
		// TODO Auto-generated constructor stub
	}

	public long getFromMobileNumber() {
		return fromMobileNumber;
	}

	public void setFromMobileNumber(long fromMobileNumber) {
		this.fromMobileNumber = fromMobileNumber;
	}

}
