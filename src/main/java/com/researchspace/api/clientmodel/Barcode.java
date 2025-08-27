package com.researchspace.api.clientmodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Barcode {
    private Long id;
    private String data;
    private String format;
    private String description;
    @Builder.Default
    private boolean newBarcodeRequest = true;
}