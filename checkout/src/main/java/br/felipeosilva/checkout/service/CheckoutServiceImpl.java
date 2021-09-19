package br.felipeosilva.checkout.service;

import br.felipeosilva.checkout.entity.CheckoutEntity;
import br.felipeosilva.checkout.repository.CheckoutRepository;
import br.felipeosilva.checkout.resource.checkout.CheckoutRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final CheckoutRepository checkoutRepository;

    @Override
    public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {
        final CheckoutEntity checkoutEntity = CheckoutEntity.builder()
                .code(UUID.randomUUID().toString())
                .status(CheckoutEntity.Status.CREATED)
                .build();
        return Optional.of(checkoutRepository.save(checkoutEntity));
    }
}
