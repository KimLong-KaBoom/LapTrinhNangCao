public class Main {
    public static void main(String args) {
        Person p = new Person("Long");
        p.setMe(p);
        System.out.print(p.getMe().getName());
        p = null;

    }
}

class Person {
    private String name;
    private Person me;

    public Person(String name) {
        this.name = name;
    }
    public void setMe(Person other) {
            me = other;
        }
    public Person getMe() {
        return me;
    }
    public String getName() {
        return name;
    }
}