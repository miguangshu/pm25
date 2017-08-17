import com.bupt.pm25.model.AirStatus;
import com.bupt.pm25.model.ResultDataEntity;
import com.bupt.pm25.model.WeatherDataEntity;
import com.bupt.pm25.util.excel.ExportExcel;
import com.google.common.collect.Lists;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by katiemi on 2017/1/12.
 */
public class PictureLabel2 {
    private static Logger LOGGER = LoggerFactory.getLogger(PictureLabel.class);
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    public static void main(String[] args) throws Exception {
        String resource = "mybatis.xml";
        InputStream is = ExportWeatherAndPM25.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();
        String statement = "com.bupt.pm25.dao.ResultDataDao.findList";//映射sql的标识字符串
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("createDate","2017");
        params.put("pageNo",0);
        params.put("pageSize",3000);
        List<ResultDataEntity> resultDataEntities = session.selectList(statement,params);
        System.out.printf(resultDataEntities.size()+"");
        List<String> headerList = Lists.newArrayList();
        headerList.add("index");
        headerList.add("picName");
        headerList.add("pm25");
        headerList.add("pm10");
        ExportExcel ee = new ExportExcel("天空图片", headerList);

        int i= 1;
        for (ResultDataEntity resultDataEntity:resultDataEntities){
            String picName = resultDataEntity.getPicName();
//            System.out.println(picName);
            String[] picSpilt = picName.split("_");
            if(picSpilt.length>4) {
                String timeStr = picSpilt[0].substring(0,10) ;
                String lon = picSpilt[1];
                String lat = picSpilt[2];
                System.out.println(timeStr + "," + lon + "," + lat);
                AirStatus airStatus = new AirStatus();
                airStatus.setLat(lat);
                airStatus.setLon(lon);
                airStatus.setCreateTime(timeStr);
                List<AirStatus> airStatuses = session.selectList("com.bupt.pm25.dao.AirStatusDao.selectByDistance", airStatus);
                if(airStatuses.size()>0) {
                    System.out.println(airStatuses.get(0).getPm25());
                    Row row = ee.addRow();
                    ee.addCell(row,0,i++);
                    ee.addCell(row,1,picName);
                    ee.addCell(row,2,airStatuses.get(0).getPm25());
                    ee.addCell(row,3,airStatuses.get(0).getPm10());
                }else{
                    timeStr = picSpilt[0].substring(0,8) ;
                    airStatus.setCreateTime(timeStr);
                    airStatuses = session.selectList("com.bupt.pm25.dao.AirStatusDao.selectByDistance", airStatus);
                    if(airStatuses.size()>0) {
                        Row row = ee.addRow();
                        ee.addCell(row, 0, i++);
                        ee.addCell(row, 1, picName);
                        ee.addCell(row, 2, airStatuses.get(0).getPm25());
                        ee.addCell(row, 3, airStatuses.get(0).getPm10());
                    }
                }
            }
        }
        String fileName = "pic.xlsx";
        ee.writeFile(fileName);
    }

}
