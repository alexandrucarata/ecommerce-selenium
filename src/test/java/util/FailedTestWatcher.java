package util;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.time.LocalDateTime;

import static util.BaseTest.browserInformation;
import static util.BaseTest.screenshot;

public class FailedTestWatcher implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        if (context.getExecutionException().isPresent()) {
            Allure.addAttachment("Date & Time", String.valueOf(LocalDateTime.now()));
            Allure.addAttachment("Browser Information", browserInformation);
            Allure.addByteAttachmentAsync("Failed Screenshot", "image/png", () -> screenshot);
        }
    }
}