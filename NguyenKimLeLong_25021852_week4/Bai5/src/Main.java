public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> pair1 = new Pair<String,Integer>("Age", 20);
        Pair<String, String> pair2 = new Pair<String,String>("Student id", "SV001");
        Pair<Integer, Double> pair3 = new Pair<Integer,Double>(105, 21.5);

        System.out.println(pair1.toString() + "\n" + pair2.toString() + "\n" + pair3.toString());

        // pair1.setKey(123);
        // setKey(String) is not applicable for the argument (int)
    }
}
