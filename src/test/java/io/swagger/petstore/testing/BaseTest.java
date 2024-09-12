package io.swagger.petstore.testing;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        Config config = ConfigFactory.load();
        RestAssured.baseURI = config.getString("base.uri");
        RestAssured.basePath = config.getString("base.path");
        RestAssured.defaultParser = Parser.JSON;
    }

    @AfterAll
    public static void tearDown() {
        Properties envProp = new Properties();
        envProp.setProperty("github", "https://github.com/my-nickname/");
        envProp.setProperty("email", "myemail@example.com");
        envProp.setProperty("telegram", "@someuser");
        try (OutputStream out = new FileOutputStream("./build/allure-results/environment.properties")) {
            envProp.store(out, "environment.properties");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
