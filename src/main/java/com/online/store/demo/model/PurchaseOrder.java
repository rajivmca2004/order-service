package com.online.store.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author rasrivastava
 *
 */

@Entity
public class PurchaseOrder {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String cname;
    
    @Column
    private String email;
    
    @Column
    private String pname;
    
    @Column
    private Double price;
    
    public PurchaseOrder() {
		super();
	}

	public PurchaseOrder(String cname, String email, String pname, Double price) {
		this.cname = cname;
		this.email = email;
		this.pname = pname;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "PurchaseOrder [id=" + id + ", cname=" + cname + ", email=" + email + ", pname=" + pname + ", price="
				+ price + "]";
	}
}