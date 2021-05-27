package utils


import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class ExcelUtil {
    static String testDataExcelFile;


    static String[][] getTestData() {
        String[][] dataTable = null;
        if (System.getProperty("stage") == 'FHEOShakeOut'){

            testDataExcelFile = new File(ExcelUtil.class.getClassLoader().getResource("FHEO-Shakeoutdata.xlsx").getFile()).getAbsolutePath();
        }
        else if (System.getProperty("stage") == 'FHEORegressionSet1'){

            testDataExcelFile = new File(ExcelUtil.class.getClassLoader().getResource("FHEO-Testdata1.xlsx").getFile()).getAbsolutePath();
        }
        else if (System.getProperty("stage") == 'FHEORegressionSet2'){

            testDataExcelFile = new File(ExcelUtil.class.getClassLoader().getResource("FHEO-Testdata2.xlsx").getFile()).getAbsolutePath();
        }
        else if (System.getProperty("stage") == 'FHEORegressionSet3'){

            testDataExcelFile = new File(ExcelUtil.class.getClassLoader().getResource("FHEO-Testdata3.xlsx").getFile()).getAbsolutePath();
        }
        else if (System.getProperty("stage") == 'FHEORegressionSet4'){

            testDataExcelFile = new File(ExcelUtil.class.getClassLoader().getResource("FHEO-Testdata4.xlsx").getFile()).getAbsolutePath();
        }
        else if (System.getProperty("stage") == 'FHEORegression508Test'){

            testDataExcelFile = new File(ExcelUtil.class.getClassLoader().getResource("FHEO-Testdata508.xlsx").getFile()).getAbsolutePath();
        }
        else if (System.getProperty("stage") == 'FHEORegressionDeviceTest'){

            testDataExcelFile = new File(ExcelUtil.class.getClassLoader().getResource("FHEO-Devicedata.xlsx").getFile()).getAbsolutePath();
        }
        else if (System.getProperty("stage") == 'FHEORegressionSet5'){

            testDataExcelFile = new File(ExcelUtil.class.getClassLoader().getResource("FHEO-Testdata5.xlsx").getFile()).getAbsolutePath();
        }


        File file = new File(testDataExcelFile);
        try {
            // Create a file input stream to read Excel workbook and worksheet
            FileInputStream xlfile = new FileInputStream(file);
            XSSFWorkbook xlwb = new XSSFWorkbook(xlfile);
            XSSFSheet xlSheet = xlwb.getSheetAt(0);

            // Get the number of rows and columns
            int numRows = xlSheet.getLastRowNum() + 1;
            int numCols = xlSheet.getRow(0).getLastCellNum();

            // Create double array data table - rows x cols
            // We will return this data table
            dataTable = new String[numRows-1][numCols];

            // For each row, create a HSSFRow, then iterate through the "columns"
            // For each "column" create an HSSFCell to grab the value at the specified cell (i,j)
            for (int i = 1; i < numRows; i++) {
                XSSFRow xlRow = xlSheet.getRow(i);
                for (int j = 0; j < numCols; j++) {
                    XSSFCell xlCell = xlRow.getCell(j);
                    dataTable[i-1][j] = xlCell.toString();
                }
            }
            xlfile.close()
        } catch (IOException e) {
            System.out.println("error while reading data from Excel " + e.toString());
        }
        return dataTable;
    }

}