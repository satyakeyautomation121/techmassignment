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

    /*@Test()
    public void readdataFromAllFiles(){
        test=extent.createTest("ReadData From all files ");
        String[] allcsvs={"DataVerify","PositionDetailsFile","OutputFile"};
        for(int i=0;i<allcsvs.length;i++){
            List<Map<String, String>> dataverify= ReadValuesFromCSVAndAddToMap.readDataFromC(allcsvs[i]);
            test.log(Status.PASS, "From File is =" + allcsvs[i] + " :- And The Datas are " +String.valueOf(dataverify));
            ReadValuesFromCSVAndAddToMap.data.clear();
        }
    }*/
    @Test
    public void compareData(){
        test=extent.createTest("ReadData From all files ");
        List<Map<String, String>> dv=ReadValuesFromCSVAndAddToMap.readDataFromDataCSV("DataVerify");
        test.log(Status.PASS,String.valueOf(dv));
        List<Map<String, String>> pdf=ReadValuesFromCSVAndAddToMap.readDataFromPositionCSV("PositionDetailsFile");
        test.log(Status.PASS,String.valueOf(pdf));
        List<Map<String, String>> opf=ReadValuesFromCSVAndAddToMap.readDataFromOutputCSV("OutputFile");
        test.log(Status.PASS,String.valueOf(opf));
        String univvalue=null;
        String dvisin=null;
        for(int i=0;i<opf.size();i++){
            univvalue=dv.get(i).get("UnitPrice");
            dvisin=dv.get(i).get("ISIN");
            String pdfidval=pdf.get(i).get("ID");
            String pdfqtyval=pdf.get(i).get("Quantity");
            String opfpid=opf.get(i).get("PositionID");
            String opfisin=opf.get(i).get("ISIN");
            String opfqty=opf.get(i).get("Quantity");
            String opftp=opf.get(i).get("TotalPrice(Qty * Unit Price)");
            String tpvalu=opftp.split("=")[1];
            if(dvisin.equalsIgnoreCase(opfisin) && pdfidval.equalsIgnoreCase(opfpid)){
                Assert.assertEquals( Integer.parseInt(univvalue) * Integer.parseInt(pdfqtyval), Integer.parseInt(tpvalu.trim()));
                test.log(Status.PASS,"Comparision Passed");
            }else{
                test.log(Status.FAIL," Comparision Failed");
            }
        }
    }
}
