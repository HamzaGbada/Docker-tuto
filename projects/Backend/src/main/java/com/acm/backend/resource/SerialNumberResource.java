package com.acm.backend.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SerialNumberResource {
    private Long value;
    private Boolean isActive;
    private Boolean isReserved;
}