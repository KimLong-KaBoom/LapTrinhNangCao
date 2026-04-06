// ==========================================
// 1. SINGLETON: Lop Logger
// ==========================================
class Logger {
    private static volatile Logger instance;

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

// ==========================================
// 2. FACTORY METHOD: He thong Export
// ==========================================
interface Export {
    void exportFile();
}

class PdfExport implements Export {
    @Override
    public void exportFile() {
        System.out.println("Dang xuat file dinh dang PDF...");
    }
}

class ExcelExport implements Export {
    @Override
    public void exportFile() {
        System.out.println("Dang xuat file dinh dang Excel...");
    }
}

// Lop Factory chiu trach nhiem tao doi tuong Export
class ExportFactory {
    public Export createExport(String type) {
        if (type.equalsIgnoreCase("PDF")) {
            return new PdfExport();
        } else if (type.equalsIgnoreCase("EXCEL")) {
            return new ExcelExport();
        }
        throw new IllegalArgumentException("Loai file khong duoc ho tro!");
    }
}

// ==========================================
// 3. ADAPTER: He thong Player
// ==========================================
// He thong cu (Khong duoc sua)
class OldPlayer {
    void playFile(String name) {
        System.out.println("OldPlayer dang phat file: " + name);
    }
}

// Giao dien he thong moi yeu cau
interface Player {
    void play(String name);
}

// Trinh chuyen doi (Adapter)
class PlayerAdapter implements Player {
    private OldPlayer oldPlayer;

    public PlayerAdapter(OldPlayer oldPlayer) {
        this.oldPlayer = oldPlayer;
    }

    @Override
    public void play(String name) {
        // Chuyen doi loi goi ham tu he thong moi sang he thong cu
        oldPlayer.playFile(name);
    }
}

// ==========================================
// 4. PROTOTYPE: Sao chep doi tuong cau hinh
// ==========================================
class SystemConfig implements Cloneable {
    private String theme;
    private int timeout;

    public SystemConfig(String theme, int timeout) {
        this.theme = theme;
        this.timeout = timeout;
    }

    @Override
    public SystemConfig clone() {
        try {
            return (SystemConfig) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public void setTheme(String theme) { this.theme = theme; }
    public void setTimeout(int timeout) { this.timeout = timeout; }

    public void printConfig(String label) {
        System.out.println(label + " -> Theme: " + theme + ", Timeout: " + timeout + "ms");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 1. KIEM TRA SINGLETON (Logger) ===");
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log("He thong khoi dong.");
        System.out.println("hashCode logger1: " + logger1.hashCode());
        System.out.println("hashCode logger2: " + logger2.hashCode());
        System.out.println("Tro cung doi tuong: " + (logger1 == logger2));
        System.out.println();

        System.out.println("=== 2. KIEM TRA FACTORY METHOD (Export) ===");
        ExportFactory exportFactory = new ExportFactory();
        // Tao doi tuong thong qua Factory thay vi dung tu khoa 'new' truc tiep cho PdfExport/ExcelExport
        Export pdf = exportFactory.createExport("PDF");
        Export excel = exportFactory.createExport("EXCEL");
        pdf.exportFile();
        excel.exportFile();
        System.out.println();

        System.out.println("=== 3. KIEM TRA ADAPTER (Player) ===");
        OldPlayer legacyPlayer = new OldPlayer();
        // He thong moi su dung giao dien Player
        Player player = new PlayerAdapter(legacyPlayer);
        player.play("bai_hat_hay_nhat.mp3");
        System.out.println();

        System.out.println("=== 4. KIEM TRA PROTOTYPE (System Config) ===");
        SystemConfig originalConfig = new SystemConfig("Dark Mode", 5000);
        
        // Tao ban sao va chinh sua ma khong lam doi ban goc
        SystemConfig customConfig = originalConfig.clone();
        customConfig.setTheme("Light Mode");
        customConfig.setTimeout(3000);

        originalConfig.printConfig("Cau hinh goc");
        customConfig.printConfig("Cau hinh ban sao");
    }
}