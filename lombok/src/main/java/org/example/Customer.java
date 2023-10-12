package org.example;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Customer {

    //@Setter(value = AccessLevel.PROTECTED)
    private String id;

    private String name;

}
