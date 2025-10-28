package utils;

import com.codeborne.selenide.Configuration;

public class TestConfig {
    public static void setup() {
        Configuration.browser = "edge";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.timeout = 10000;
    }
}