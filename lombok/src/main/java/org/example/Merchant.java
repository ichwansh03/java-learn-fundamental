package org.example;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor //constructor untuk field yg final
@ToString(exclude = "id")
@EqualsAndHashCode(exclude = {"id"})
@Value
public class Merchant {

    String id;

    String address;
}
