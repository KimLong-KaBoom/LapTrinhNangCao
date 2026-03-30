class electronic extends Product {
    int warrantyMonths;

    public electronic(String id, String name, int warrantyMonths) {
        super(id, name);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public void display() {
        System.out.println(name + " - " + warrantyMonths + " tháng bảo hành");
    }
}