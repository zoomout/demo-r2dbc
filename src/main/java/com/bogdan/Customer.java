package com.bogdan;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
class Customer {

    @Id
    Integer id;
    String firstname, lastname;

    boolean hasId() {
        return id != null;
    }
}
