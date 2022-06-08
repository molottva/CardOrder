package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CallBackTest {
    SelenideElement form = $("form.form");

    @BeforeTest
    public void setUp() {
        open("http://localhost:9999/");
    }

    @Test
    public void shouldCriticalPathTest() {
        form.$("[data-test-id=name] input").setValue("Гагарин Юрий");
        form.$("[data-test-id=phone] input").setValue("+79211234567");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        $("[data-test-id=order-success]").shouldNotHave(
                exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
