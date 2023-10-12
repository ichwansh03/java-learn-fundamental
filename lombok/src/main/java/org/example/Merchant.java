package org.example;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor //constructor untuk field yg final
public class Merchant {

    private final String id;

    private String address;
}
