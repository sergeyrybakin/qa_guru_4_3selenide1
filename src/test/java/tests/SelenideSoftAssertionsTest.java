package tests;

import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class SelenideSoftAssertionsTest
{
    @Test
    void verificationOfPageOpening(){
//      Откройте страницу Selenide в Github
        Selenide.open("https://github.com/selenide/selenide");

//      Перейдите в раздел Wiki проекта
        $("span[data-content=Wiki]").click();

//        - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
//
//                - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        sleep(3000);
    }
}
