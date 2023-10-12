package org.example;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    //@Setter(value = AccessLevel.PROTECTED)
    private String id;

    private String name;

}
