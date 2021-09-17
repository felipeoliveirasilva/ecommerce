package br.felipeosilva.checkout.service;

import br.felipeosilva.checkout.entity.CheckoutEntity;
import br.felipeosilva.checkout.resource.checkout.CheckoutRequest;

import java.util.Optional;

public interface CheckoutService {

    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);
}
