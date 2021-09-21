<h2>API de Checkout e Pagamentos com microserviços e Kafka</h2>

API Checkout - Recebe os dados do cartao do cliente, salva no banco e gera a mensagem Kafka.
API Payment - Escuta através do Kafka as mensagens geradas pela API Checkout. Processa o pagamento e gera uma mensagem com o status do pagamento.


