package utils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class Util {
    public static void takeSnapShot(WebDriver webdriver,String fileName) throws Exception{

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        File DestFile=new File(System.getProperty("user.dir") + "/src/test/resources/screenshots/" + fileName);

        FileUtils.copyFile(SrcFile, DestFile);

    }
}
