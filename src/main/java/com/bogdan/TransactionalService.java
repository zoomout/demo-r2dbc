package com.bogdan;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
class TransactionalService {

    private final @NonNull CustomerRepository repository;

    @Transactional
    public Mono<Customer> save(Customer customer) {

        return repository.save(customer).map(it -> {

            if (it.firstname.equals("Dave")) {
                throw new IllegalStateException();
            } else {
                return it;
            }
        });
    }
}
