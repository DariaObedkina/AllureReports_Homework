package com.dobedkina.allureAnnotations;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step("Открываем страницу github")
    public void openGitHub() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").setValue(repository).pressEnter();
    }

    @Step("Переходим в репозиторий {repository}")
    public void goToRepository(String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Переходим во кладку Issues")
    public void goToIssuesPage() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие issue с номером {number}")
    public void shouldBeVisibleIssueWithNumber(String number) {
        $(withText("#" + number)).shouldBe(Condition.visible);
    }
}
