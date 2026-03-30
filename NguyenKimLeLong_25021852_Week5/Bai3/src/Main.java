import java.util.*;

public class Main {
    public static void main(String[] args) {

        String text = "Alo em có phải Vũ không? Ui Vũ ơi em đừng có chối, thông tin về tên địa chỉ nhà, học trường gì, ở đâu, bố mẹ tên là gì anh có cả ở đây rồi.";

        text = text.toLowerCase();
        text = text.replaceAll("[^a-z\\s]", "");

        String[] words = text.split("\\s+");

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty()) continue;

            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }

        String maxWord = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxWord = entry.getKey();
            }
        }

        List<String> uniqueWords = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueWords.add(entry.getKey());
            }
        }

        System.out.println("Mostly appear word: " + maxWord + " (" + maxCount + " time)");
        System.out.println("One time appear word: " + uniqueWords);
    }
}