package com.microservices.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class HotelRequest {

    private String id;
    private String name;
    private String location;
    private String about;
}
