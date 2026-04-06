import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Lop ReportTemplate trien khai interface Cloneable cua Java de danh dau no co the nhan ban
class ReportTemplate implements Cloneable {
    private String title;
    private String footer;
    private List<String> sections;

    public ReportTemplate(String title, String footer, List<String> sections) {
        this.title = title;
        this.footer = footer;
        this.sections = sections;
    }

    @Override
    public ReportTemplate clone() {
        try {
            // Buoc 1: Shallow Copy (Sao chep nong) - chep cac kieu du lieu nguyen thuy va String
            ReportTemplate cloned = (ReportTemplate) super.clone();
            
            // Buoc 2: Deep Copy (Sao chep sau) - TAO MOI danh sach sections
            // Neu khong co dong nay, ca ban goc va ban sao se cung tro chung vao mot List trong bo nho.
            // Khi ban sao them/xoa section, ban goc cung bi anh huong!
            cloned.sections = new ArrayList<>(this.sections);
            
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Lop nay khong ho tro clone", e);
        }
    }

    // Getters & Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getFooter() { return footer; }
    public void setFooter(String footer) { this.footer = footer; }

    public List<String> getSections() { return sections; }
    public void setSections(List<String> sections) { this.sections = sections; }

    // Phuong thuc in thong tin bao cao
    public void printReport(String label) {
        System.out.println("--- " + label + " ---");
        System.out.println("Title: " + title);
        System.out.println("Sections: " + sections);
        System.out.println("Footer: " + footer);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        // Tao mot mau bao cao goc (Template)
        List<String> defaultSections = Arrays.asList("Phan 1: Mo dau", "Phan 2: Noi dung chinh", "Phan 3: Ket luan");
        ReportTemplate originalTemplate = new ReportTemplate(
                "Bao cao Mau (Chua co tieu de)", 
                "Ban quyen thuoc ve Cong ty ABC", 
                defaultSections
        );

        // Tao ban sao so 1 va chinh sua
        ReportTemplate report1 = originalTemplate.clone();
        report1.setTitle("Bao cao Doanh thu Thang 1");
        
        // Thu them 1 muc vao ban sao 1 de chung minh Deep Copy hoat dong hieu qua
        report1.getSections().add("Phan phu luc: Bang ke chi tiet"); 

        // Tao ban sao so 2 va chinh sua
        ReportTemplate report2 = originalTemplate.clone();
        report2.setTitle("Bao cao Nhan su Thang 2");

        // In ra 3 bao cao de kiem tra
        System.out.println("=== KIEM TRA MAU THIET KE PROTOTYPE ===\n");
        
        originalTemplate.printReport("BAN GOC (ORIGINAL)");
        report1.printReport("BAN SAO 1 (CLONE 1)");
        report2.printReport("BAN SAO 2 (CLONE 2)");
    }
}