package web;

import lombok.Getter;

import java.util.Properties;

@Getter
public class CustomConfig extends BaseTest{
    private final String webUrl;
    private final String username;
    private final String password;

    CustomConfig(Properties properties) {
        webUrl = properties.getProperty("web.url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }
}