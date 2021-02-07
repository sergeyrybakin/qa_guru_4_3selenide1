package tests;

import org.junit.jupiter.api.Test;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;

public class SelenideSoftAssertionsTest
{
    @Test
    void verificationOfPageOpening()
    {
        //      Откройте страницу Selenide в Github
        Selenide.open("https://github.com/selenide/selenide");

        //      Перейдите в раздел Wiki проекта
        $("span[data-content=Wiki]").click();
        $(".markdown-body h1").shouldHave(Condition.text("Welcome to the selenide wiki!"));

        //      Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $$(".markdown-body ul").filterBy(Condition.text("Soft Assertions")).shouldHave(CollectionCondition.size(1));

        //
        //                - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        sleep(2000);
    }
}
