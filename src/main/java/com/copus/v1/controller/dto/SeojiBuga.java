package com.copus.v1.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * All Fields Default == Null
 * When Has Data, Value is Seoji Id
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeojiBuga {
    private String beomrye;
    private String chapter;
    private String haejae;
}
