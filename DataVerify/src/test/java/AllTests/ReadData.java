package AllTests;

import Reporting.GenerateReport;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import org.generic.ReadValuesFromCSVAndAddToMap;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class ReadData extends GenerateReport {

    @Test
    public void compareData() {
        test = extent.createTest("ReadData From all files ");
        List<Map<String, String>> dv = ReadValuesFromCSVAndAddToMap.readDataFromDataCSV("DataVerify");
        test.log(Status.PASS, String.valueOf(dv));
        List<Map<String, String>> pdf = ReadValuesFromCSVAndAddToMap.readDataFromPositionCSV("PositionDetailsFile");
        test.log(Status.PASS, String.valueOf(pdf));
        List<Map<String, String>> opf = ReadValuesFromCSVAndAddToMap.readDataFromOutputCSV("OutputFile");
        test.log(Status.PASS, String.valueOf(opf));
        String univvalue = null;
        for (int i = 0; i < opf.size(); i++) {

            String pdfidval = pdf.get(i).get("ID");
            String opfpid = opf.get(i).get("PositionID");
            String opfisin = opf.get(i).get("ISIN");
            String opfqty = opf.get(i).get("Quantity");
            String opftp = opf.get(i).get("TotalPrice(Qty * Unit Price)");

            if (opfpid.equalsIgnoreCase(pdfidval)) {
                String pdfinstid = pdf.get(i).get("Instrument ID");
                System.out.println(pdfinstid);
                String pdfqtyval = pdf.get(i).get("Quantity");
                String str1 = "";
                for (int j = 0; j < dv.size(); j++) {
                    if (dv.get(j).get("ID").equalsIgnoreCase(pdfinstid)) {
                        univvalue = dv.get(j).get("UnitPrice");
                        str1 = dv.get(j).get("ISIN");
                        if (str1.equalsIgnoreCase(opfisin)) {
                            int twofileinputvalue = Integer.parseInt(pdfqtyval) * Integer.parseInt(univvalue);
                            Assert.assertEquals(twofileinputvalue, Integer.parseInt(opftp));
                            test.log(Status.PASS, " Data From Instrument Details and Position Details " + twofileinputvalue + " Is Equal To  " + Integer.parseInt(opftp));
                        }
                    }
                }
            }
        }
    }
}

