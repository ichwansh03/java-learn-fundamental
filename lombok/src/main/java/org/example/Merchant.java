package org.example;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor //constructor untuk field yg final
@ToString(exclude = "id")
@EqualsAndHashCode(exclude = {"id"})
public class Merchant {

    private final String id;

    private String address;
}
