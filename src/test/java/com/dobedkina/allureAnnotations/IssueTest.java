package com.dobedkina.allureAnnotations;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Configuration.startMaximized;

@Feature("Issue")
@Owner("dobedkina")
public class IssueTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "68";

    @BeforeAll
    public static void setUp() {
        startMaximized = true;

    }

    @Test
    @DisplayName("На странице Issues присутствует issue с номером " + ISSUE_NUMBER)
    @Severity(SeverityLevel.CRITICAL)
    public void checkIfIssueExistsInRepository() {
        WebSteps steps = new WebSteps();
        steps.openGitHub();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.goToIssuesPage();
        steps.shouldBeVisibleIssueWithNumber(ISSUE_NUMBER);
        takeScreenshot();
        takePageSource();

    }

    @Attachment(value = "Скриншот", type = "image/png")
    public byte[] takeScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }

    @Attachment(value = "Страница", type = "text/html")
    public byte[] takePageSource() {
        return WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }
}
