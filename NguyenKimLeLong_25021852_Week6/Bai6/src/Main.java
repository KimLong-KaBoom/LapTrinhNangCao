import java.util.ArrayList;
import java.util.List;

// 1. Component: Lop co so chung cho tat ca cac loai phan tu
abstract class FileSystemItem {
    protected String name;
    protected Folder parent; // Luu tham chieu den thu muc cha de truy xuat duong dan

    public FileSystemItem(String name) {
        this.name = name;
    }

    public void setParent(Folder parent) {
        this.parent = parent;
    }

    // Phuong thuc de quy de lay duong dan tuyet doi cua phan tu
    public String getPath() {
        if (parent == null) {
            return "/" + name;
        }
        return parent.getPath() + "/" + name;
    }

    // Phuong thuc in thong tin ma cac lop con phai ghi de
    public abstract void print(String indent);
}

// 2. Leaf: Lop dai dien cho mot file thuc te
class FileItem extends FileSystemItem {
    private int size;

    public FileItem(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "File: " + name + " (" + size + "KB)");
    }
}

// 3. Leaf: Lop dai dien cho mot shortcut
class Shortcut extends FileSystemItem {
    private FileSystemItem target;

    public Shortcut(String name, FileSystemItem target) {
        super(name);
        this.target = target;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Shortcut: " + name + " -> " + target.getPath());
    }
}

// 4. Composite: Lop dai dien cho thu muc (co the chua cac FileSystemItem khac)
class Folder extends FileSystemItem {
    private List<FileSystemItem> children;

    public Folder(String name) {
        super(name);
        this.children = new ArrayList<>();
    }

    // Phuong thuc them phan tu con vao thu muc
    public void add(FileSystemItem item) {
        item.setParent(this); // Dat thu muc hien tai lam cha cua phan tu moi
        children.add(item);
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Folder: " + name);
        // Tang khoang trang (indent) len 2 dau cach khi in cac phan tu con
        for (FileSystemItem child : children) {
            child.print(indent + "  ");
        }
    }
}

// 5. Chuong trinh chay thu (Main)
public class Main {
    public static void main(String[] args) {
        // Tao cac thu muc
        Folder root = new Folder("root");
        Folder docs = new Folder("docs");

        // Tao cac file va shortcut
        FileItem aTxt = new FileItem("a.txt", 12);
        FileItem bTxt = new FileItem("b.txt", 8);
        Shortcut aShortcut = new Shortcut("a-shortcut", aTxt);
        
        FileItem readmeMd = new FileItem("readme.md", 4);

        // Xay dung cay thu muc
        // Them file vao docs
        docs.add(aTxt);
        docs.add(bTxt);
        docs.add(aShortcut);

        // Them docs va readme vao root
        root.add(docs);
        root.add(readmeMd);

        // Bat dau in tu thu muc goc voi khoang trang ban dau la chuoi rong
        root.print("");
    }
}