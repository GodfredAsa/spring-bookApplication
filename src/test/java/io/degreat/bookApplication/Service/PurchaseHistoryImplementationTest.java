package io.degreat.bookApplication.Service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.degreat.bookApplication.Model.PurchaseHistory;
import io.degreat.bookApplication.Repository.Projection.PurchaseItem;
import io.degreat.bookApplication.Repository.PurchaseHistoryRepository;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import io.degreat.bookApplication.Service.serviceImp.PurchaseHistoryImplementation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PurchaseHistoryImplementation.class})
@ExtendWith(SpringExtension.class)
class PurchaseHistoryImplementationTest {
    @Autowired
    private PurchaseHistoryImplementation purchaseHistoryImplementation;

    @MockBean
    private PurchaseHistoryRepository purchaseHistoryRepository;

    @Test
    void testSaveHistory() {
        PurchaseHistory purchaseHistory = new PurchaseHistory();
        purchaseHistory.setBookId(123L);
        purchaseHistory.setId(123L);
        purchaseHistory.setPrice(10.0);
        purchaseHistory.setPurchaseTime(LocalDateTime.of(1, 1, 1, 1, 1));
        purchaseHistory.setUserId(123L);
        when(this.purchaseHistoryRepository.save((PurchaseHistory) any())).thenReturn(purchaseHistory);

        PurchaseHistory purchaseHistory1 = new PurchaseHistory();
        purchaseHistory1.setBookId(123L);
        purchaseHistory1.setId(123L);
        purchaseHistory1.setPrice(10.0);
        purchaseHistory1.setPurchaseTime(LocalDateTime.of(1, 1, 1, 1, 1));
        purchaseHistory1.setUserId(123L);
        assertSame(purchaseHistory, this.purchaseHistoryImplementation.saveHistory(purchaseHistory1));
        verify(this.purchaseHistoryRepository).save((PurchaseHistory) any());
    }

    @Test
    void testDeletePurchaseHistory() {
        doNothing().when(this.purchaseHistoryRepository).deleteById((Long) any());
        this.purchaseHistoryImplementation.deletePurchaseHistory(123L);
        verify(this.purchaseHistoryRepository).deleteById((Long) any());
    }

    @Test
    void testFindPurchasesOfUser() {
        ArrayList<PurchaseItem> purchaseItemList = new ArrayList<>();
        when(this.purchaseHistoryRepository.findAllPurchasesOfUser((Long) any())).thenReturn(purchaseItemList);
        List<PurchaseItem> actualFindPurchasesOfUserResult = this.purchaseHistoryImplementation.findPurchasesOfUser(123L);
        assertSame(purchaseItemList, actualFindPurchasesOfUserResult);
        assertTrue(actualFindPurchasesOfUserResult.isEmpty());
        verify(this.purchaseHistoryRepository).findAllPurchasesOfUser((Long) any());
    }
}

