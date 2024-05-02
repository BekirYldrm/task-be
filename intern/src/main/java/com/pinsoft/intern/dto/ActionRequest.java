package com.pinsoft.intern.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActionRequest {
    private String description;
    private float money;
    private String type;
    private Long userId;
}
