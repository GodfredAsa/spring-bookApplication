package io.degreat.bookApplication.Service.serviceImp;

import io.degreat.bookApplication.Model.PurchaseHistory;
import io.degreat.bookApplication.Repository.Projection.PurchaseItem;
import io.degreat.bookApplication.Repository.PurchaseHistoryRepository;
import io.degreat.bookApplication.Service.Iservice.PurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseHistoryImplementation implements PurchaseHistoryService {
    @Autowired
    private PurchaseHistoryRepository purchaseHistoryRepository;

    @Override
    public PurchaseHistory saveHistory(PurchaseHistory purchaseHistory){
        purchaseHistory.setPurchaseTime(LocalDateTime.now());
        return purchaseHistoryRepository.save(purchaseHistory);
    }

    @Override
    public void deletePurchaseHistory(Long Id){
        purchaseHistoryRepository.deleteById(Id);
    }

    @Override
    public List<PurchaseItem> findPurchasesOfUser(Long userId){
        return purchaseHistoryRepository.findAllPurchasesOfUser(userId);

    }
}
