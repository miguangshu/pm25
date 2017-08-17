import com.bupt.pm25.model.AirStatus;
import com.bupt.pm25.model.ResultDataEntity;
import com.bupt.pm25.util.excel.ExportExcel;
import com.google.common.collect.Lists;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by katiemi on 2017/1/12.
 */
public class ProcessTime2 {
    private static Logger LOGGER = LoggerFactory.getLogger(PictureLabel.class);
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    public static void main(String[] args) throws Exception {

        List<String> headerList = Lists.newArrayList();
        headerList.add("index");
        headerList.add("picName");
        headerList.add("processTime");
        headerList.add("picSize");
        headerList.add("date");
        ExportExcel ee = new ExportExcel("处理时间", headerList);
        int i= 1;
        File file = new File("/Users/katiemi/work/bupt/logs/logs.out");
        if(file.exists()){
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            String temp = "";
            try {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
                while((temp = bufferedReader.readLine()) != null){
                    try {
                        String[] lineSplit =temp.split(" ");
                        String picName = lineSplit[5];
                        String picSize = lineSplit[6];
                        String processTimeStr = lineSplit[11];
                        Double processTime = Double.parseDouble(processTimeStr);
                        Row row = ee.addRow();
                        ee.addCell(row,0,i++);
                        ee.addCell(row,1,picName);
                        ee.addCell(row,2,processTime);
                        ee.addCell(row,3,picSize);
                        ee.addCell(row,4,lineSplit[0]+" "+lineSplit[1]);

                    /*for(String ss : lineSplit){
                        System.out.printf(ss+",");
                    }*/
//                        System.out.println(String.format("%s,%s,%s",picName,picSize,processTime));
                    } catch (Exception e) {

                    }
                }
            } catch (FileNotFoundException e) {
                //e.printStackTrace();
            } catch (IOException e) {
                //e.printStackTrace();
            }finally{
                try {
                    fileReader.close();
                } catch (IOException e) {
                    //e.printStackTrace();
                }
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    //e.printStackTrace();
                }
            }
        }


        String fileName = "processTime.xlsx";
        ee.writeFile(fileName);
    }

}
