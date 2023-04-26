package AllTests;

import Reporting.GenerateReport;
import com.aventstack.extentreports.Status;
import com.opencsv.CSVReader;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CompareTwoCSVs extends GenerateReport {
    @Test
    public static void threeCSVCompare() throws IOException {
        test=extent.createTest("Two CSV File Compare");
        CSVReader reader1 = new CSVReader(new FileReader(System.getProperty("user.dir")+"/src/test/resources/DataVerify.csv"));
        CSVReader reader2 = new CSVReader(new FileReader(System.getProperty("user.dir")+"/src/test/resources/PositionDetailsFile.csv"));
        CSVReader reader3 = new CSVReader(new FileReader(System.getProperty("user.dir")+"/src/test/resources/OutputFile.csv"));

        List<String[]> rows1 = reader1.readAll();
        List<String[]> rows2 = reader2.readAll();
        List<String[]> rows3 = reader3.readAll();

        if(rows1.size() != rows2.size() || rows1.size() != rows3.size()) {
            test.log(Status.PASS,"CSV files have different number of rows.");
        } else {
            boolean isEqual = true;
            for(int i = 0; i < rows1.size(); i++) {
                String[] row1 = rows1.get(i);
                String[] row2 = rows2.get(i);
                String[] row3 = rows3.get(i);
                if(row1.length != row2.length || row1.length != row3.length) {
                    isEqual = false;
                    test.log(Status.PASS,"Row " + (i+1) + " has different number of cells.");
                } else {
                    for(int j = 0; j < row1.length; j++) {
                        if(!row1[j].equals(row2[j]) || !row1[j].equals(row3[j])) {
                            isEqual = false;
                            test.log(Status.PASS,"Row " + (i+1) + ", cell " + (j+1) + " is different.");
                        }
                    }
                }
            }
            if(isEqual) {
                test.log(Status.PASS,"CSV files have the same content.");
            }
        }
    }
}
