package com.dobedkina.selenide;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class IssueTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "68";

    @BeforeAll
    public static void setUp() {
        startMaximized = true;

    }

    @Test
    public void checkIfIssueExistsInRepository() {
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").setValue(REPOSITORY).pressEnter();
        $(By.linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText("#" + ISSUE_NUMBER)).shouldBe(Condition.visible);


    }
}
