public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero();
        CanSwim swimmer = hero;
        CanFight fighter = hero;
        swimmer.swim();
        fighter.fight();
    }
}
