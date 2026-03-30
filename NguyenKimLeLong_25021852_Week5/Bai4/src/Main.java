import java.util.*;

public class Main {
    public static void main(String[] args) {
        String text = "Alo em có phải Vũ không? Ui Vũ ơi em đừng có chối, thông tin về tên địa chỉ nhà, học trường gì, ở đâu, bố mẹ tên là gì anh có cả ở đây rồi.";

        WordCounter wc = new WordCounter();
        wc.analyze(text);
        wc.displayResult();
    }
}

class WordCounter {
    private Map<String, Integer> map = new HashMap<>();

    public void analyze(String text) {
        text = text.toLowerCase();
        text = text.replaceAll("[^a-z\\s]", "");

        String[] words = text.split("\\s+");

        for (String word : words) {
            if (word.isEmpty()) continue;

            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
    }

    public void displayResult() {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        String maxWord = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxWord = entry.getKey();
            }
        }

        System.out.println("Mostly appear: " + maxWord + " (" + maxCount + ")");
    }
}