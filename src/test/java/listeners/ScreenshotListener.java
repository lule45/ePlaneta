package listeners;

import common.BrowserManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.util.Date;

public class ScreenshotListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult iTestResult){
        try {
            Object currentClass = iTestResult.getInstance();
            WebDriver driver = ((BrowserManager) currentClass).getDriver();
            takesScreenshot(driver, iTestResult);
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
    private static void takesScreenshot(WebDriver driver, ITestResult iTestResult){
        TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
        File tempFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        Date date = new Date();
        String screenshotName = iTestResult.getName()+"_"+date.toString()
                .replace(":", "_").replace(" ", "_");

        try {
            FileUtils.copyFile(tempFile, new File("./Screenshots/"+screenshotName+".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
