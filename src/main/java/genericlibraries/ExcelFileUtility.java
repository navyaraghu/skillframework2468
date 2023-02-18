package genericlibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class contains all the reusable methods to work on excel file
 * @author DELL
 *
 */
public class ExcelFileUtility
{
	private Workbook wb;
	private DataFormatter df;
/**
 * This method is used to intialize the excel workbook
 * @param path
 */
public void excelIntialization(String path) 
{
	FileInputStream fis=null;
try {
	fis=new FileInputStream(path);
} catch (FileNotFoundException e) {
	e.printStackTrace();
}
try {
	 wb=WorkbookFactory.create(fis);
} catch (EncryptedDocumentException | IOException e) {
	e.printStackTrace();
}
}
/**
 * This method is used to fetch the single data from excel
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @return
 */
public String readDataFromExcel(String sheetName, int rowNum, int cellNum) 
{
df=new DataFormatter();
Sheet sh=wb.getSheet(sheetName);
return df.formatCellValue(sh.getRow(rowNum).getCell(cellNum));
}
/**
 * This method is used to read multiple data from excel
 * @param sheetName
 * @return 
 */
public List<String> readDataFromExcel(String sheetName) 
{
	df=new DataFormatter();
	Sheet sh=wb.getSheet(sheetName);
	List<String> dataList=new ArrayList<>();
	for (int i = 0; i <= sh.getLastRowNum(); i++)
	{
		String data=df.formatCellValue(sh.getRow(i).getCell(1));
		dataList.add(data);
	}
	return dataList;
	
}
/**
 * This method is used to close the excel workbook
 */
public void closeExcel()
{
	try {
		wb.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

}
