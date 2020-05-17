package com.online.store.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.online.store.demo.model.PurchaseOrder;
/**
 * @author rasrivastava
 *
 */


@RepositoryRestResource (collectionResourceRel = "orders", path = "orders")
public interface OrderRepository extends JpaRepository <PurchaseOrder, Long> {
}
