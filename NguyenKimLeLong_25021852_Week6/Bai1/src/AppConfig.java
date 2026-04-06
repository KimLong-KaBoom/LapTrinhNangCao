public class AppConfig {
    private static volatile AppConfig instance = null;

    private String appName;
    private String version;
    private String logLevel;

    private AppConfig() {
        this.appName = "A";
        this.version = "1.1";
        this.logLevel = "2";
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            synchronized (AppConfig.class) {
                if (instance == null) {
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }
     public String getAppName() {
        return appName;
    }

    public String getVersion() {
        return version;
    }

    public String getLogLevel() {
        return logLevel;
    }
}
