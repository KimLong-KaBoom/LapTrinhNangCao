public class Animal {
    public void makeSound() {
        System.out.println("Animal Sound");
    }

    public static void main(String[] args) {
        // Animal[] zoo = new Animal[4];
        // zoo[0] = new Dog();
        // zoo[1] = new Cat();
        // zoo[2] = new Duck();
        // zoo[3] = new Dog();

        // for (Animal i : zoo) {
        //     i.makeSound();
        // }

    Animal a = new Dog(); 
    /*
    Exception in thread "main" java.lang.ClassCastException: 
    class Dog cannot be cast to class Cat
     */
    if (a instanceof Cat) {
        Cat c = (Cat) a; 
        c.makeSound();
    } 
    else {
        System.out.println("Đây không phải là Mèo!");
    }
    }
}

class Dog extends Animal{
    public void makeSound() {
        System.out.println("Woof woof");
    }
}

class Cat extends Animal {
    public void makeSound() {
        System.out.println("Meows meows");
    }
}

class Duck extends Animal {

}