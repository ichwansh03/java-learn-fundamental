package org.example;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor //constructor untuk field yg final
@ToString(exclude = "id")
public class Merchant {

    private final String id;

    private String address;
}
