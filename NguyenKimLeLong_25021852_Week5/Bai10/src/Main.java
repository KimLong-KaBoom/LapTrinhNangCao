import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = null;

        try {
            System.out.print("Nhap duong dan file config: ");
            String path = sc.nextLine();

            br = new BufferedReader(new FileReader(path));
            Map<String, String> config = new HashMap<>();

            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split("=");

                if (parts.length != 2) {
                    throw new InvalidConfigException("Sai dinh dang dong: " + line);
                }

                String key = parts[0].trim();
                String value = parts[1].trim();

                config.put(key, value);
            }

            if (!config.containsKey("username")) {
                throw new InvalidConfigException("Thieu username");
            }

            if (!config.containsKey("timeout")) {
                throw new InvalidConfigException("Thieu timeout");
            }

            int timeout = Integer.parseInt(config.get("timeout"));
            if (timeout <= 0) {
                throw new InvalidConfigException("timeout phai > 0");
            }

            if (config.containsKey("maxConnections")) {
                int max = Integer.parseInt(config.get("maxConnections"));
                if (max < 1) {
                    throw new InvalidConfigException("maxConnections >= 1");
                }
            }

            System.out.println("Cau hinh doc duoc:");
            for (Map.Entry<String, String> entry : config.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }

            System.out.println("Config loaded successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Config file not found.");
        } catch (InvalidConfigException e) {
            System.out.println("Invalid config: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                System.out.println("Loi dong file.");
            }
            sc.close();
            System.out.println("Program finished.");
        }
    }
}