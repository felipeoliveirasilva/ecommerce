package br.felipeosilva.checkout.listener;

import br.felipeosilva.checkout.entity.CheckoutEntity;
import br.felipeosilva.checkout.repository.CheckoutRepository;
import br.felipeosilva.checkout.streaming.PaymentPaidSynk;
import br.felipeosilva.payment.event.PaymentCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

    private CheckoutRepository checkoutRepository;

    @StreamListener(PaymentPaidSynk.INPUT)
    public void handler(PaymentCreatedEvent event) {
        final CheckoutEntity checkoutEntity = checkoutRepository.findByCode(event.getCheckoutCode().toString()).orElseThrow();
        checkoutEntity.setStatus(CheckoutEntity.Status.APPROVED);
        checkoutRepository.save(checkoutEntity);
        event.getCheckoutCode();

    }
}
