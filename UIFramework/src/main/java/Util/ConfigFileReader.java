package Util;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {
    FileReader fileReader;
    String filepath=System.getProperty("user.dir")+"/src/test/resources/config/config.properties";
    public String getReportConfigPath() throws IOException {
        fileReader =new FileReader(filepath);
        Properties properties=new Properties();
        properties.load(fileReader);
        String reportConfigPath = properties.getProperty("reportConfigPath");
        if(reportConfigPath!= null)
            return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }
}
