// 1. Lop chua du lieu bao cao
class Report {
    private String title;
    private String content;

    public Report(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() { return title; }
    public String getContent() { return content; }
}

// 2. Interface dinh nghia chien luoc xuat dinh dang (Giai quyet OCP)
interface ReportFormatter {
    String format(Report data);
}

// 3. Cac lop cai dat dinh dang cu the (Moi lop dam nhan 1 trach nhiem - Giai quyet SRP)
class JsonFormatter implements ReportFormatter {
    @Override
    public String format(Report data) {
        return "{\n" +
               "  \"title\": \"" + data.getTitle() + "\",\n" +
               "  \"content\": \"" + data.getContent() + "\"\n" +
               "}";
    }
}

class XmlFormatter implements ReportFormatter {
    @Override
    public String format(Report data) {
        return "<report>\n" +
               "  <title>" + data.getTitle() + "</title>\n" +
               "  <content>" + data.getContent() + "</content>\n" +
               "</report>";
    }
}

// 4. Lop Dich vu da duoc tai cau truc
class ReportService {
    // Chua mot tham chieu den interface thay vi lop cu the
    private ReportFormatter formatter;

    // Dependency Injection thong qua constructor
    public ReportService(ReportFormatter formatter) {
        this.formatter = formatter;
    }

    public void setFormatter(ReportFormatter formatter) {
        this.formatter = formatter;
    }

    public String export(Report data) {
        if (this.formatter == null) {
            throw new IllegalStateException("Chua cau hinh Formatter!");
        }
        return this.formatter.format(data);
    }
}

public class Main {
    public static void main(String[] args) {
        // Tao du lieu bao cao
        Report myReport = new Report("Bao cao Thang 4", "Doanh thu tang truong tot.");

        System.out.println("=== Xuat bao cao dinh dang JSON ===");
        ReportService jsonService = new ReportService(new JsonFormatter());
        System.out.println(jsonService.export(myReport));

        System.out.println("\n=== Xuat bao cao dinh dang XML ===");
        // Co the thay doi chien luoc xuat mot cach linh hoat
        jsonService.setFormatter(new XmlFormatter());
        System.out.println(jsonService.export(myReport));
    }
}