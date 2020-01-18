package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;

	public BaseTest() {
		prop = new Properties();
		try {
			System.out.println(System.getProperty("user.dir"));
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/config/config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void initialization() {
		String browserName = prop.getProperty("browserName");
		switch (browserName) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			System.setProperty("webdriver.geko.driver", "");
			driver = new FirefoxDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "");
			driver = new ChromeDriver();
			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
	}

}
