interface IData {
    void show();
    }

class DataManager implements IData {
    public void show() { 
    System.out.println("Show Data");
    }
}
/*
    Method trong interface mặc định là public
    còn trong class mặc định là default (< public) nên đoạn code trên mắc lỗi 
    *Cannot reduce the visibility ò the inherited method from Idata;
 */