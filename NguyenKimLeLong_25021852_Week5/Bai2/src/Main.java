import java.util.*;

class Customer {
    int id;
    String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "Customer{id=" + id + ", name='" + name + "'}";
    }
}

class Message {
    int id;
    String content;

    public Message(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public String toString() {
        return "Message{id=" + id + ", content='" + content + "'}";
    }
}

class Ticket {
    int id;
    String content;
    Date timestamp;

    public Ticket(int id, String content) {
        this.id = id;
        this.content = content;
        this.timestamp = new Date();
    }
}

class CustomerQueue {
    Queue<Customer> queue = new LinkedList<>();

    public void addCustomer(Customer c) {
        queue.offer(c);
        System.out.println("Add: " + c);
    }

    public Customer processCustomer() {
        Customer c = queue.poll();
        if (c == null) {
            System.out.println("No one remaining.");
        } else {
            System.out.println("Current: " + c);
        }
        return c;
    }
}

class MessageHistory {
    Stack<Message> stack = new Stack<>();

    public void addMessage(Message m) {
        stack.push(m);
        System.out.println("Type: " + m.content);
    }

    public void undo() {
        if (stack.isEmpty()) {
            System.out.println("Nothing to undo");
        } else {
            Message m = stack.pop();
            System.out.println("Undo: " + m.content);
        }
    }

    public void viewLast() {
        if (stack.isEmpty()) {
            System.out.println("Empty");
        } else {
            System.out.println("Lastest message: " + stack.peek().content);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Customer current;
        CustomerQueue cq = new CustomerQueue();
        while ((current = cq.processCustomer()) != null) {
        MessageHistory history = new MessageHistory();

        System.out.println("Processing: " + current.name);

        history.addMessage(new Message(1, "Hi " + current.name));
        history.addMessage(new Message(2, "Need help?"));
        history.addMessage(new Message(3, "Please write down your problem."));

        history.undo();
        history.viewLast();

        System.out.println("---- Completed: " + current.name + " ----\n");
        }
    
    }
}