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
    public void compareData(){
        test=extent.createTest("ReadData From all files ");
        List<Map<String, String>> dv=ReadValuesFromCSVAndAddToMap.readDataFromDataCSV("DataVerify");
        test.log(Status.PASS,String.valueOf(dv));
        List<Map<String, String>> pdf=ReadValuesFromCSVAndAddToMap.readDataFromPositionCSV("PositionDetailsFile");
        test.log(Status.PASS,String.valueOf(pdf));
        List<Map<String, String>> opf=ReadValuesFromCSVAndAddToMap.readDataFromOutputCSV("OutputFile");
        test.log(Status.PASS,String.valueOf(opf));
        String dvisin=null;
        String univvalue=null;
        for(int i=0;i<opf.size();i++){
            String pdfidval=pdf.get(i).get("ID");
            String opfpid=opf.get(i).get("PositionID");
            String opfisin=opf.get(i).get("ISIN");
            String opfqty=opf.get(i).get("Quantity");
            String opftp=opf.get(i).get("TotalPrice(Qty * Unit Price)");



            //take opfpid from opf and then
            //compare it with pdfidval
            //at that time get the values, pdfidval related instrument id, and quantity from pdf
            //retrive the isin no and unitprice from dv

            //

            if(opfpid.equalsIgnoreCase(pdfidval)){
                String pdfinstid= pdf.get(i).get("Instrument ID");
                String pdfqtyval=pdf.get(i).get("Quantity");
               // if(i==dv.size()){
                    dvisin=dv.get(i).get("ISIN");
                    univvalue =dv.get(i).get("UnitPrice");
                //}else{

                //}

                if(opfisin.equalsIgnoreCase(dvisin)){
                    int twofileinputvalue = Integer.parseInt(pdfqtyval) * Integer.parseInt(univvalue);
                    Assert.assertEquals(twofileinputvalue,Integer.parseInt(opftp));
                    test.log(Status.PASS," Data From Instrument Details and Position Details " + twofileinputvalue +" Is Equal To  "+ Integer.parseInt(opftp)) ;
                }

            }




           /* if(dvisin.equalsIgnoreCase(opfisin) && pdfidval.equalsIgnoreCase(opfpid)){
                Assert.assertEquals( Integer.parseInt(univvalue) * Integer.parseInt(pdfqtyval), Integer.parseInt(opftp.trim()));
                test.log(Status.PASS,"Comparision Passed");
            }else{
                test.log(Status.FAIL," Comparision Failed");
            }*/
        }
    }
}
