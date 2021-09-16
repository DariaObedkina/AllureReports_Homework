package com.dobedkina.lambdaSteps;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class IssueTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "68";

    @BeforeAll
    public static void setUp() {
        startMaximized = true;

    }

    @Test
    public void checkIfIssueExistsInRepository() {
        step("Открываем страницу github", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY).pressEnter();
        });
        step("Переходим в репозиторий" + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Переходим во кладку Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие issue с номером " + ISSUE_NUMBER, () -> {
            $(withText("#" + ISSUE_NUMBER)).shouldBe(Condition.visible);
        });

    }
}
