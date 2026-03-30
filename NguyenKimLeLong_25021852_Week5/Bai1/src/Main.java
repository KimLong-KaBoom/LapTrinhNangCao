public class Main {
    public static void useString() {
        long startTime = System.currentTimeMillis();
        String s = "";
        for (int i = 1; i <= 100000; ++i) {
            s = s + "Hello";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("useStringBuffer time: "+ (endTime - startTime));
    }

    public static void useStringBuffer() {
        long startTime = System.currentTimeMillis();
        StringBuffer s = new StringBuffer("");
        for (int i = 1; i <= 100000; ++i) {
            s.append(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("useStringBuffer time: "+ (endTime - startTime));
    }

    public static void contentAnalysis(String s) {
        long numberOfSentences = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '!' || s.charAt(i) == '?' || s.charAt(i) == '.') {
                numberOfSentences++;
            }
        }
        System.out.println(numberOfSentences);

        String replaced = s.replace("Java", "Python");
        System.out.println("After replaced: " + replaced);
    }

    public static void main(String[] args) {
        useString();
        useStringBuffer();
        contentAnalysis("Alo em có phải Java không? Ui Java ơi em đừng có chối. Thông tin về tên địa chỉ nhà, học trường gì, ở đâu, bố mẹ tên là gì anh có cả ở đây rồi.");
    }
}
