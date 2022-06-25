package io.degreat.bookApplication.Repository.Projection;

import java.time.LocalDateTime;

public interface PurchaseItem {
    String getTitle();
    String getPrice();
    LocalDateTime getPurchaseTime();
}
