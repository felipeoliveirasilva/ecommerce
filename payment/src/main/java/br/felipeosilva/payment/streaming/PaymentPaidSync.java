package br.felipeosilva.payment.streaming;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface PaymentPaidSync {

    String INPUT = "payment-paid-input";

    @Input(INPUT)
    SubscribableChannel input();

}
