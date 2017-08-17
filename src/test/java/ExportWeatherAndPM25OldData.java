import com.bupt.pm25.model.AirStatus;
import com.bupt.pm25.model.WeatherDataEntity;
import com.bupt.pm25.util.excel.ExportExcel;
import com.google.common.collect.Lists;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by miguangshu on 2016/6/21.
 */
public class ExportWeatherAndPM25OldData {
    public static void main(String[] args) throws IOException {
        //mybatis的配置文件
        String resource = "mybatis.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = ExportWeatherAndPM25.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "com.bupt.pm25.dao.WeatherDataDao.findOldDataList";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        int pageNo = 0;
        int pageSize =10000;

        while (true){
            List<String> headerList = Lists.newArrayList();
            headerList.add("index");
            headerList.add("dicCode");
            headerList.add("dicName");
            headerList.add("temperature");
            headerList.add("pressure");
            headerList.add("humidity");
            headerList.add("windSpeed");
            headerList.add("windDirectionName");
            headerList.add("windDirection");
            headerList.add("weatherName");
            headerList.add("weatherCode");
            headerList.add("collectTime");
            headerList.add("stationDic");
            headerList.add("stationName");
            headerList.add("lon");
            headerList.add("lat");
            headerList.add("pm25");
            headerList.add("pm10");
            headerList.add("co");
            headerList.add("no2");
            headerList.add("o3");
            headerList.add("so2");
            headerList.add("createTime");
            ExportExcel ee = new ExportExcel("天气与空气质量", headerList);
            Map<String,Object> params = new HashMap<String,Object>();
            params.put("pageNo",(pageNo*pageSize));
            params.put("pageSize",pageSize);
//            params.put("collectTime","2017-01-01");
            List<WeatherDataEntity> weatherDataEntities = session.selectList(statement,params);
            for(int i=0;i<weatherDataEntities.size();i++){
                WeatherDataEntity entity = weatherDataEntities.get(i);
                AirStatus airStatus = new AirStatus();
                if(entity == null) continue;
                if(entity.getCityId()!=null){
                    entity.setCityId(entity.getCityId().trim());
                }
                if(entity.getCreateDate()!=null){
                    entity.setCreateDate(entity.getCreateDate().trim());
                }
                //房山
                if("00104".equals(entity.getCityId()))    {
                    airStatus.setDic("00102");
                //密云
                }else if("00115".equals(entity.getCityId())){
                    airStatus.setDic("00110");
                //门头沟
                }else if("00112".equals(entity.getCityId())){
                    airStatus.setDic("00102");
                //延庆
                }else if("00116".equals(entity.getCityId())){
                    airStatus.setDic("00111");
                //平谷
                }else if("00113".equals(entity.getCityId())){
                    airStatus.setDic("00110");
                //大兴
                }else if("00108".equals(entity.getCityId())){
                    airStatus.setDic("00103");
                //通州
                }else if("00109".equals(entity.getCityId())){
                    airStatus.setDic("00103");
                }else{
                    airStatus.setDic(entity.getCityId());
                }
                airStatus.setCreateTime(entity.getCreateDate());
                List<AirStatus> airStatuses = session.selectList("com.bupt.pm25.dao.AirStatusDao.selectByCityIdAndCreateTime",airStatus);
                Row row = ee.addRow();
                int k = 0;
                int n = 1;
                ee.addCell(row,k++,i);
                ee.addCell(row,k++,""+entity.getCityId());
                ee.addCell(row,k++,entity.getCityName());
                ee.addCell(row,k++,entity.getTemperature());
                ee.addCell(row,k++,entity.getPressure());
                ee.addCell(row,k++,entity.getHumidity());
                ee.addCell(row,k++,entity.getWindSpeed());
                ee.addCell(row,k++,entity.getWindDirectionName());
                ee.addCell(row,k++,entity.getWindDirection());
                ee.addCell(row,k++,entity.getWeatherName());
                ee.addCell(row,k++,entity.getWeather());
                ee.addCell(row,k++,entity.getCollectTime());
                if(airStatuses!=null && airStatuses.size()>0){
                    AirStatus as = airStatuses.get(0);
                    ee.addCell(row,k++,as.getDic());
                    ee.addCell(row,k++,as.getStationName());
                    ee.addCell(row,k++,"");
                    ee.addCell(row,k++,"");
                    ee.addCell(row,k++,as.getPm25());
                    ee.addCell(row,k++,as.getPm10());
                    ee.addCell(row,k++,as.getCo());
                    ee.addCell(row,k++,as.getNo2());
                    ee.addCell(row,k++,as.getO3());
                    ee.addCell(row,k++,as.getSo2());
                    ee.addCell(row,k++,as.getCreateTime());
                }
            }
            String fileName = "desc_data_"+pageNo+".xlsx";
            ee.writeFile(fileName);
            System.out.println("pageNo = [" + pageNo + "]");
            pageNo++;
            if(weatherDataEntities.size()<pageSize) break;
        }

    }

}
