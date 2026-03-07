public class Account {
    private String accountId;
    private String balance;
    private Transaction[] history;

    public Account() {
        this.history = new Transaction[0];
    }

    public void addTransaction(Transaction t) {
        Transaction[] newHistory = new Transaction[history.length + 1];
        for (int i = 0; i < history.length; ++i)
            newHistory[i] = history[i];
        newHistory[history.length] = t;
        history = newHistory;
    }

    public Transaction[] getHistory() {
        Transaction[] newHistory = new Transaction[history.length];
        for (int i = 0; i < history.length; ++i)
            newHistory[i] = history[i];
        return newHistory;
    }
}