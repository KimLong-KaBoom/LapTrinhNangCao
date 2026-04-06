// 1. Component: Giao dien chuan cho tat ca cac loai Notifier
interface Notifier {
    void send(String msg);
}

// 2. Concrete Component: Kenh thong bao mac dinh (Loi co ban)
class EmailNotifier implements Notifier {
    @Override
    public void send(String msg) {
        System.out.println("[Email] Da gui: " + msg);
    }
}

// 3. Base Decorator: Lop trang tri truu tuong, giu mot tham chieu den Notifier khac
abstract class NotifierDecorator implements Notifier {
    // Bien wrappee (ke bi boc) chua doi tuong goc hoac doi tuong da duoc trang tri truoc do
    protected Notifier wrappee;

    public NotifierDecorator(Notifier wrappee) {
        this.wrappee = wrappee;
    }

    // Chuyen tiep cong viec cho doi tuong ben trong no
    @Override
    public void send(String msg) {
        wrappee.send(msg);
    }
}

// 4. Concrete Decorators: Cac lop bo sung them kenh gui thong bao
class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier wrappee) {
        super(wrappee); // Truyen doi tuong bi boc len lop cha
    }

    @Override
    public void send(String msg) {
        super.send(msg); // 1. Cho phep lop bi boc (Email/Facebook...) gui thong bao truoc
        System.out.println("[SMS] Da gui: " + msg); // 2. Tu minh thuc hien gui them qua SMS
    }
}

class FacebookNotifier extends NotifierDecorator {
    public FacebookNotifier(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public void send(String msg) {
        super.send(msg); // 1. Cho cac lop ben trong xu ly xong
        System.out.println("[Facebook] Da gui: " + msg); // 2. Bo sung tinh nang gui qua Facebook
    }
}

// 5. Chuong trinh chay thu (Main)
public class Main {
    public static void main(String[] args) {
        String message = "He thong dang bao tri, vui long luu lai cong viec!";

        System.out.println("=== Kich ban 1: Chi gui Email (Mac dinh) ===");
        Notifier simpleNotifier = new EmailNotifier();
        simpleNotifier.send(message);

        System.out.println("\n=== Kich ban 2: Gui Email + SMS ===");
        Notifier smsAndEmailNotifier = new SMSNotifier(new EmailNotifier());
        smsAndEmailNotifier.send(message);

        System.out.println("\n=== Kich ban 3: Gui Combo (Email + SMS + Facebook) ===");
        // Boc lop Email bang SMS, sau do lai boc tiep to hop do bang Facebook
        Notifier fullComboNotifier = new FacebookNotifier(new SMSNotifier(new EmailNotifier()));
        fullComboNotifier.send(message);
    }
}