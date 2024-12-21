package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path = ".\\testData\\Opencart_LoginData.xlsx";
		ExcelUtility xlutil = new ExcelUtility(path);
		int totalrow=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);
		String logindatat[][]= new String [totalrow][totalcols];
		for(int i=1;i<=totalrow;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				logindatat[i-1][j]=xlutil.getCellData("sheet1", i, j);
			}
		}
		return logindatat;
	}

}
