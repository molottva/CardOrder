package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CallBackTest {
    SelenideElement form = $(".form");

    @Test
    public void shouldCriticalPathTest() {
        open("http://localhost:9999/");
        form.$("[data-test-id=name] input").setValue("Гагарин Юрий");
        form.$("[data-test-id=phone] input").setValue("+79211234567");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        $("[data-test-id=order-success]").shouldHave(
                exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    //todo bug
    @Test
    public void shouldValidNameTestOne() {
        open("http://localhost:9999/");
        form.$("[data-test-id=name] input").setValue("Ёжикова Алёна");
        form.$("[data-test-id=phone] input").setValue("+79211234567");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        $("[data-test-id=order-success]").shouldHave(
                exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void shouldValidNameTestTwo() {
        open("http://localhost:9999/");
        form.$("[data-test-id=name] input").setValue("Римский-Корсаков Николай");
        form.$("[data-test-id=phone] input").setValue("+79211234567");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        $("[data-test-id=order-success]").shouldHave(
                exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void shouldValidNameTestThree() {
        open("http://localhost:9999/");
        form.$("[data-test-id=name] input").setValue("Ахмед ибн Абдуллах");
        form.$("[data-test-id=phone] input").setValue("+79211234567");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        $("[data-test-id=order-success]").shouldHave(
                exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void shouldInvalidNameTestOne() {
        open("http://localhost:9999/");
        form.$("[data-test-id=name] input").setValue("Ivan Ivanov");
        form.$("[data-test-id=phone] input").setValue("+79211234567");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        form.$("[data-test-id=name] .input__sub").shouldHave(
                exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    //todo bug
    @Test
    public void shouldInvalidNameTestTwo() {
        open("http://localhost:9999/");
        form.$("[data-test-id=name] input").setValue("Андрей");
        form.$("[data-test-id=phone] input").setValue("+79211234567");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        form.$("[data-test-id=name] .input__sub").shouldHave(
                exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    public void shouldInvalidNameTestThree() {
        open("http://localhost:9999/");
        form.$("[data-test-id=name] input").setValue("+79211234567");
        form.$("[data-test-id=phone] input").setValue("+79211234567");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        form.$("[data-test-id=name] .input__sub").shouldHave(
                exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    public void shouldInvalidPhoneTestOne() {
        open("http://localhost:9999/");
        form.$("[data-test-id=name] input").setValue("Гагарин Юрий");
        form.$("[data-test-id=phone] input").setValue("89211234567");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        form.$("[data-test-id=phone] .input__sub").shouldHave(
                exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void shouldInvalidPhoneTestTwo() {
        open("http://localhost:9999/");
        form.$("[data-test-id=name] input").setValue("Гагарин Юрий");
        form.$("[data-test-id=phone] input").setValue("+7921123456");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        form.$("[data-test-id=phone] .input__sub").shouldHave(
                exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void shouldInvalidPhoneTestThree() {
        open("http://localhost:9999/");
        form.$("[data-test-id=name] input").setValue("Гагарин Юрий");
        form.$("[data-test-id=phone] input").setValue("+792112345678");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        form.$("[data-test-id=phone] .input__sub").shouldHave(
                exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void shouldInvalidPhoneTestFour() {
        open("http://localhost:9999/");
        form.$("[data-test-id=name] input").setValue("Гагарин Юрий");
        form.$("[data-test-id=phone] input").setValue("Samsung");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        form.$("[data-test-id=phone] .input__sub").shouldHave(
                exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void shouldEmptyInputTestOne() {
        open("http://localhost:9999/");
        form.$("[data-test-id=phone] input").setValue("+79211234567");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        form.$("[data-test-id=name] .input__sub").shouldHave(
                exactText("Поле обязательно для заполнения"));
    }

    @Test
    public void shouldEmptyInputTestTwo() {
        open("http://localhost:9999/");
        form.$("[data-test-id=name] input").setValue("Гагарин Юрий");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        form.$("[data-test-id=phone] .input__sub").shouldHave(
                exactText("Поле обязательно для заполнения"));
    }

    @Test
    public void shouldEmptyCheckBoxTest() {
        open("http://localhost:9999/");
        form.$("[data-test-id=name] input").setValue("Гагарин Юрий");
        form.$("[data-test-id=phone] input").setValue("+79211234567");
        form.$("button.button").click();
        form.$("[data-test-id=agreement]").should(cssClass("input_invalid"));
    }
}
