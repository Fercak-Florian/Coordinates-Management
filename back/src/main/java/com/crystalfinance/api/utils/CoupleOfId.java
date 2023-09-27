package com.crystalfinance.api.utils;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CoupleOfId {
    @NotEmpty(message = "id must not be empty")
    private String idOne;
    @NotEmpty(message = "id must not be empty")
    private String idTwo;
}
