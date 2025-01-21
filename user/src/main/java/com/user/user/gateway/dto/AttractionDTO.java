package com.user.user.gateway.dto;

import lombok.Data;

@Data
public class AttractionDTO {

    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;
    private String description;

}
