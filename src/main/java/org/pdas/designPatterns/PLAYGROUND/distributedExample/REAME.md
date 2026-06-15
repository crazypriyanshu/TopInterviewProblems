We need to publish critical financial transactions to a Kafka cluster. However:

In production, the payload must be encrypted due to regulatory mandates (PII compliance).

We need to prevent duplicate messages using an Idempotency Check (deduplication).

If Kafka is down, we must track the failure or route it to a local dead-letter storage.