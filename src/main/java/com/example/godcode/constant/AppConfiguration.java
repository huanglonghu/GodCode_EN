package com.example.godcode.constant;

public class AppConfiguration {
    private AppConfiguration() {
    }
    private static AppConfiguration defaultInstance;
    public static AppConfiguration getDefault() {
        AppConfiguration appConfiguration = defaultInstance;
        if (defaultInstance == null) {
            synchronized (AppConfiguration.class) {
                if (defaultInstance == null) {
                    appConfiguration = new AppConfiguration();
                    defaultInstance = appConfiguration;
                }
            }
        }
        return appConfiguration;
    }

    private int appLanguage;

    public int getAppLanguage() {
        return appLanguage;
    }

    public void setAppLanguage(int appLanguage) {
        this.appLanguage = appLanguage;
    }
}
