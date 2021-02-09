package tests;

import java.time.Duration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSoftAssertionsTest
{
    @BeforeAll
    static void setUp()
    {
        Configuration.startMaximized = true;
    }

    @Test
    void verificationOfPageOpening()
    {
        //Откройте страницу Selenide в Github
        Selenide.open("https://github.com");
        $("[name=q]").setValue("selenide").pressEnter();
        $$("ul.repo-list li a").filterBy(exactText("selenide/selenide")).first().click();

        //Перейдите в раздел Wiki проекта
        $("span[data-content=Wiki]").click();
        $(".markdown-body h1").shouldHave(text("Welcome to the selenide wiki!"));

        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        //Откройте страницу SoftAssertions
        $$(".markdown-body li a").filterBy(text("Soft assertions")).shouldHaveSize(1).first().click();
        $("#wiki-wrapper h1").shouldHave(text("SoftAssertions"), Duration.ofMillis(6000));

        //проверьте что внутри есть пример кода для JUnit5
        $$("#wiki-body li")
                .shouldHave(itemWithText("Using JUnit5 extend test class:"), Duration.ofSeconds(6));

        sleep(2000);
    }
}
