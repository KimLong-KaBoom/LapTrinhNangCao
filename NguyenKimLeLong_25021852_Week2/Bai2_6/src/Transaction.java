public class Transaction {
    private final String transactionId;
    private final String amount;
    private final String timestamp;
    
    public Transaction(String transactionId, String amount, String timestamp) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public String getTransactionId() { 
        return transactionId; 
    }
    public String getAmount() {
        return amount; 
    }
    public String getTimestamp() {
        return timestamp; 
    }
}

