package Utility;

import java.io.File;
import java.io.IOException;

import javax.swing.text.DefaultEditorKit.CopyAction;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {

	public void TakeAScreenshot(WebDriver driver,String TCID) throws IOException {
		
		File Src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File Dest = new File("D:\\Workspace3\\XYZ\\ScreenShots\\"+TCID+".jpg");
		
		FileHandler.copy(Src, Dest);
		
	}
}
