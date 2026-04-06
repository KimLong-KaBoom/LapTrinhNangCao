// Lop Logger ap dung mau thiet ke Singleton
class Logger {
    private static Logger instance;
    private Logger() {

    }

    // 3. Phuong thuc public static de lay instance (Lazy Initialization)
    public static Logger getInstance() {
        // Neu instance chua ton tai thi moi tao moi
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Cac phuong thuc ghi log theo format yeu cau
    public void logInfo(String msg) {
        System.out.println("[INFO] " + msg);
    }

    public void logError(String msg) {
        System.out.println("[ERROR] " + msg);
    }
}

// Lop Main de kiem thu he thong
public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Kiem tra hai bien co tro cung ve mot dia chi vung nho hay khong
        System.out.println("Logger instances equal: " + (logger1 == logger2));

        // Ghi nhieu log khac nhau de kiem tra
        logger1.logInfo("Application started");
        
        // Co tinh dung logger2 de ghi log chung minh ca 2 deu hoat dong nhu nhau 
        // tren cung mot doi tuong thuc te
        logger2.logInfo("Processing data...");
        
        logger1.logError("Something went wrong");
    }
}