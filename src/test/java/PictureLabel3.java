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
public class PictureLabel3 {
    private static Logger LOGGER = LoggerFactory.getLogger(PictureLabel.class);
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
    public static void main(String[] args) throws Exception {
        String resource = "mybatis.xml";
        InputStream is = ExportWeatherAndPM25.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();
        String statement = "com.bupt.pm25.dao.AirStatusDao.selectByStationId";//映射sql的标识字符串
        Map<String,Object> params = new HashMap<String,Object>();

        List<String> headerList = Lists.newArrayList();
        headerList.add("S1");
        headerList.add("S2");
        headerList.add("S3");
        headerList.add("S4");
        headerList.add("S5");
        headerList.add("S6");
        headerList.add("S7");
        headerList.add("S8");
        headerList.add("S9");
        headerList.add("S10");
        headerList.add("S11");
        headerList.add("S12");
        headerList.add("SID");
        headerList.add("PREDICT");
        headerList.add("picName");

        ExportExcel ee = new ExportExcel("图片PM25", headerList);
        int i= 1;
        File file = new File("/Users/katiemi/work/bupt/test_2017.txt");
        if(file.exists()){
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            String temp = "";
            try {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
                while((temp = bufferedReader.readLine()) != null){
                    try {
                        String[] lineSplit =temp.split("   ");
                        String picName = lineSplit[0];
                        String[] picNameSplit = picName.split("_");
                        String uploadDate = picNameSplit[0];
                        String lon = picNameSplit[1];
                        String lat = picNameSplit[2];
                        String predictValue = lineSplit[1];
                        Row row = ee.addRow();
                        params.put("createTime",uploadDate.substring(0,10));
                        params.put("stationId",1);
                        AirStatus as = session.selectOne(statement,params);
                        ee.addCell(row,0,as == null ? "":as.getPm25());
                        params.put("stationId",2);
                        as = session.selectOne(statement,params);
                        ee.addCell(row,1,as == null ? "":as.getPm25());
                        params.put("stationId",3);
                        as = session.selectOne(statement,params);
                        ee.addCell(row,2,as == null ? "":as.getPm25());
                        params.put("stationId",4);
                        as = session.selectOne(statement,params);
                        ee.addCell(row,3,as == null ? "":as.getPm25());

                        params.put("stationId",5);
                        as = session.selectOne(statement,params);
                        ee.addCell(row,4,as == null ? "":as.getPm25());

                        params.put("stationId",6);
                        as = session.selectOne(statement,params);
                        ee.addCell(row,5,as == null ? "":as.getPm25());

                        params.put("stationId",7);
                        as = session.selectOne(statement,params);
                        ee.addCell(row,6,as == null ? "":as.getPm25());

                        params.put("stationId",8);
                        as = session.selectOne(statement,params);
                        ee.addCell(row,7,as == null ? "":as.getPm25());

                        params.put("stationId",9);
                        as = session.selectOne(statement,params);
                        ee.addCell(row,8,as == null ? "":as.getPm25());

                        params.put("stationId",10);
                        as = session.selectOne(statement,params);
                        ee.addCell(row,9,as == null ? "":as.getPm25());

                        params.put("stationId",11);
                        as = session.selectOne(statement,params);
                        ee.addCell(row,10,as == null ? "":as.getPm25());

                        params.put("stationId",12);
                        as = session.selectOne(statement,params);
                        ee.addCell(row,11,as == null ? "":as.getPm25());
                        List<AirStatus> ases = session.selectList("com.bupt.pm25.dao.AirStatusDao.selectByDistance",params);
                        ee.addCell(row,12,ases == null ? "":ases.get(0).getStationId());
                        ee.addCell(row,13,predictValue);
                        ee.addCell(row,14,picName);

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
