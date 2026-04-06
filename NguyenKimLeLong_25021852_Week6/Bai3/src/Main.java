// 1. Cac giao dien san pham chung (Abstract Products)
interface Button {
    void render();
}

interface Checkbox {
    void render();
}

// 2. Tinh nang san pham danh cho Windows (Concrete Products - Windows)
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Dang ve [Windows Button] voi phong cach Metro.");
    }
}

class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Dang ve [Windows Checkbox] voi dau tich vuong.");
    }
}

// 3. Tinh nang san pham danh cho Mac (Concrete Products - Mac)
class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Dang ve [Mac Button] voi phong cach bo goc Aqua.");
    }
}

class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Dang ve [Mac Checkbox] voi dau tich tron.");
    }
}

// 4. (Abstract Factory)
interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// 5. Windows's (Concrete Factories)
class WindowsFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// 6. Mac's Concrete Factories
class MacFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// 7. Lop Application dong vai tro la Client su dung Factory
class Application {
    private Button button;
    private Checkbox checkbox;

    // Khoi tao cac thanh phan giao dien thong qua Factory duoc truyen vao
    public Application(UIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    // Hien thi toan bo giao dien
    public void renderUI() {
        button.render();
        checkbox.render();
    }
}

// 8. Lop Main chay chuong trinh
public class Main {
    public static void main(String[] args) {
        String osConfig = "win"; 
        
        UIFactory factory;

        if (osConfig.equalsIgnoreCase("win")) {
            factory = new WindowsFactory();
        } else if (osConfig.equalsIgnoreCase("mac")) {
            factory = new MacFactory();
        } else {
            throw new IllegalArgumentException("He dieu hanh khong duoc ho tro!");
        }

        // Tao ung dung voi bo Factory da chon va render giao dien
        Application app = new Application(factory);
        System.out.println("=== Bat dau Render UI cho he dieu hanh: " + osConfig.toUpperCase() + " ===");
        app.renderUI();
    }
}