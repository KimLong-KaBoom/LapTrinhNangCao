public class Main {
    public static void main(String[] args) {
        Account acc = new Account();
        acc.addTransaction(new Transaction("Long 1", "100000", "10:30"));
        acc.addTransaction(new Transaction("Long 2", "200000", "11:00"));
        acc.addTransaction(new Transaction("Long 3", "400000", "12:00"));

        Transaction[] hacker = acc.getHistory();
        hacker[0] = new Transaction(
            hacker[0].getTransactionId(),
            "999999999",
            hacker[0].getTimestamp()
        );
        Transaction[] history = acc.getHistory();
        System.out.println(history[0].getTransactionId() + " " + history[0].getAmount() + " " + history[0].getTimestamp());
        System.out.println(history[1].getTransactionId() + " " + history[1].getAmount() + " " + history[1].getTimestamp());
        System.out.print(history[2].getTransactionId() + " " + history[2].getAmount() + " " + history[2].getTimestamp());

    }
}
