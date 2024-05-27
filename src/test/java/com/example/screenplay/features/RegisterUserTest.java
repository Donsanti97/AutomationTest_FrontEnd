package com.example.screenplay.features;

import com.example.screenplay.tasks.RegisterUser;
import com.example.screenplay.utils.ExcelReader;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Map;

@RunWith(SerenityRunner.class)
public class RegisterUserTest {

    @Managed
    WebDriver browser;

    Actor user = Actor.named("User");

    @Before
    public void setUp() {
        user.can(BrowseTheWeb.with(browser));
    }

    @Test
    public void registerUser() throws IOException {
        Map<String, String> userData = ExcelReader.getUserData("src/test/resources/data.xlsx", "Sheet1");
        user.attemptsTo(
                Open.url("https://demoqa.com/login"),
                RegisterUser.withData(userData)
        );
        // Additional steps to verify and perform other tasks can be added here.
    }
}

