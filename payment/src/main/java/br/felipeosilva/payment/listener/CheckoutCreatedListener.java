package br.felipeosilva.payment.listener;


import br.felipeosilva.payment.streaming.CheckoutProcessor;
import br.felipeosilva.payment.event.PaymentCreatedEvent;
import br.felipeosilva.payment.event.CheckoutCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CheckoutCreatedListener {

    private final CheckoutProcessor checkoutProcessor;

    @StreamListener(CheckoutProcessor.INPUT)
    public void handler(CheckoutCreatedEvent event) {

        final PaymentCreatedEvent paymentCreatedEvent = PaymentCreatedEvent.newBuilder()
                .setCheckoutCode(event.getCheckoutCode())
                .setCheckoutstatus(event.getStatus())
                .setPaymentCode(UUID.randomUUID().toString())
                .build();

        checkoutProcessor.output().send(MessageBuilder.withPayload(paymentCreatedEvent).build());

    }
}
