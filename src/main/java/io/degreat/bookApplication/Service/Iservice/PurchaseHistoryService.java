package io.degreat.bookApplication.Service.Iservice;

import io.degreat.bookApplication.Model.PurchaseHistory;
import io.degreat.bookApplication.Repository.Projection.PurchaseItem;

import java.util.List;

public interface PurchaseHistoryService {
    PurchaseHistory saveHistory(PurchaseHistory purchaseHistory);

    void deletePurchaseHistory(Long Id);

    List<PurchaseItem> findPurchasesOfUser(Long userId);
}
