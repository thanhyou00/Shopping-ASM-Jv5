package com.fpoly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpoly.entities.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

//	@Query(value = "SELECT p.name, p.categories, od.price, quantity, order FROM OrderDetail od "
//			+ "JOIN Order o ON o.id=od.order " + "JOIN Product p ON p.id=od.product WHERE o.account= :accountId")
//	List<OrderDetail> getHistory(@Param("accountId") int accountId);
//	@Query(value = "SELECT product.name,product.category_id,order_detail.price,quantity,order_id FROM order_detail "
//			+ "JOIN orders ON orders.id=order_detail.order_id "
//			+ "JOIN product ON product.id=order_detail.product_id WHERE orders.account_id=8", nativeQuery = true)
//	@Query(name = "OrderDetail.getHistory")
//	List<OrderDetail> getHistory();
}
