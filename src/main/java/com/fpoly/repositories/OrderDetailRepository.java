package com.fpoly.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fpoly.beans.HistoryModel;
import com.fpoly.entities.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

	@Query(value = "SELECT new HistoryModel(p, od, o ) FROM OrderDetail od "
			+ "INNER JOIN od.order o INNER JOIN od.product p WHERE o.orderStatus = 0 AND o.account.id =:id")
	public List<HistoryModel> getHistory(@Param("id") int id);
	

	@Query(value = "SELECT new HistoryModel(p, od, o ) FROM OrderDetail od "
			+ "INNER JOIN od.order o INNER JOIN od.product p WHERE od.order.id =:id")
	public List<HistoryModel> getBill(@Param("id") int id);
}
