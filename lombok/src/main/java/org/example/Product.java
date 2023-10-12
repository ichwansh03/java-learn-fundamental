package org.example;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "id")
public class Product {

    private final String id;

    private String name;

    private Long price;
}
