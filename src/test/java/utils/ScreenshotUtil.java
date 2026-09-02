package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String captureScreenshot(
            WebDriver driver,
            String screenshotName) {

        TakesScreenshot takesScreenshot =
                (TakesScreenshot) driver;

        File sourceFile =
                takesScreenshot.getScreenshotAs(OutputType.FILE);

        File targetFile = new File(
                "target/screenshots/" + screenshotName + ".png"
        );

        try {
            targetFile.getParentFile().mkdirs();

            java.nio.file.Files.copy(
                    sourceFile.toPath(),
                    targetFile.toPath(),
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING
            );

        } catch (IOException e) {
            throw new RuntimeException(
                    "Could not save screenshot",
                    e
            );
        }

        return targetFile.getAbsolutePath();
    }
}