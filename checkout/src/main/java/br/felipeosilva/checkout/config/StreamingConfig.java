package br.felipeosilva.checkout.config;

import br.felipeosilva.checkout.streaming.CheckoutCreatedSource;
import br.felipeosilva.checkout.streaming.PaymentPaidSynk;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(value = {
        CheckoutCreatedSource.class,
        PaymentPaidSynk.class
})
public class StreamingConfig {
}