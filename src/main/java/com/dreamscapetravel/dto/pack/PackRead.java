package com.dreamscapetravel.dto.pack;

import java.time.Instant;

public interface PackRead {
    String getName();
    String getDescription();
    Double getPrice();
    Integer getSlots();
    Instant getStart();
    Integer getDuration();
    String getImagePath();

    String getImageName();
}
