package com.online.store.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * @author rasrivastava
 *
 */

@SuppressWarnings("unused")
@Entity
@Data
@EqualsAndHashCode (exclude = "id")
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

	@Override
	public String toString() {
		return "PurchaseOrder [id=" + id + ", cname=" + cname + ", email=" + email + ", pname=" + pname + ", price="
				+ price + "]";
	}
}