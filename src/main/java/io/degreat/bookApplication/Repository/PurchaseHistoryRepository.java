package io.degreat.bookApplication.Repository;

import io.degreat.bookApplication.Model.PurchaseHistory;
import io.degreat.bookApplication.Repository.Projection.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long> {
/**
 * 1. create interface Package Projection under Repository Package
 * create methods relating to fields you need to retrieve
 */

@Query( " select " +
        " b.title as title, " +
        " ph.price as price," +
        " ph.purchaseTime as purchaseTime" +
        " from PurchaseHistory ph " +
        " left join " +
        " Book b on b.id = ph.book_Id " +
        " where ph.userId = :userId")
 List<PurchaseItem> findAllPurchasesOfUser(@Param("userId") Long userId);

}
