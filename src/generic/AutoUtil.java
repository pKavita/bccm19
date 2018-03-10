package generic;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AutoUtil {
	
	public static String getProperty(String path, String key) {
		String v="";
		try {
			Properties p=new Properties();
			p.load(new FileInputStream(path));
			v=p.getProperty(key);
		}
		catch(Exception e) {
			}
		return v;
	}
	public static String getPhoto(WebDriver driver,String folder) {
		String path="";
		try {
			String d = new Date().toString();
			String dateTime = d.replaceAll(":", "-");
			path=folder+dateTime+".png";
			TakesScreenshot t=(TakesScreenshot) driver;
			File src = t.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(path));
		}
		catch(Exception e) {
			}
		return path;
	}
	
}
