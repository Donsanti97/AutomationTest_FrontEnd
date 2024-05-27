package com.example.screenplay.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.By;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegisterUser implements Task {

    private final Map<String, String> userData;

    public RegisterUser(Map<String, String> userData) {
        this.userData = userData;
    }

    @Step("{0} registers a new user")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("https://demoqa.com/login"),
                Click.on(By.id("newUser")),
                Enter.theValue(userData.get("First Name")).into(By.id("firstname")),
                Enter.theValue(userData.get("Last Name")).into(By.id("lastname")),
                Enter.theValue(userData.get("UserName")).into(By.id("userName")),
                Enter.theValue(userData.get("Password")).into(By.id("password")),
                Click.on(By.id("register"))
        );
    }

    public static RegisterUser withData(Map<String, String> userData) {
        return instrumented(RegisterUser.class, userData);
    }
}

