package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	public Object[][] getData() throws EncryptedDocumentException, IOException {
		
		FileInputStream File = new FileInputStream("D:\\Workspace3\\XYZ\\TestData\\XYZTestData.xlsx");
		Sheet SH = WorkbookFactory.create(File).getSheet("Deposit");
		Object data[][] = new Object[SH.getLastRowNum()][SH.getRow(0).getLastCellNum()];
			
			for(int i = 0;i<SH.getLastRowNum();i++) {
				for(int j = 0;j<SH.getRow(0).getLastCellNum();j++) {
					data[i][j] = SH.getRow(i+1).getCell(j).toString();
				}
			}	
		return data;
	}
	
	
	
}
