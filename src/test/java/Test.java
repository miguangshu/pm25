import com.bupt.pm25.model.WeatherDataEntity;
import com.bupt.pm25.util.FetchAirStatusClient;
import com.bupt.pm25.model.AirStatus;
import com.bupt.pm25.util.excel.ExportExcel;
import com.google.common.collect.Lists;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.poi.ss.usermodel.Row;
import org.omg.CORBA.Object;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by miguangshu on 2016/6/21.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        //mybatis的配置文件
        String resource = "mybatis.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = Test.class.getClassLoader().getResourceAsStream(resource);
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
        String statement = "com.bupt.pm25.dao.WeatherDataDao.findList";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        int pageNo = 0;
        int pageSize =30000;

//        while (true){
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
            Map<String,Integer> params = new HashMap<String,Integer>();
            params.put("pageNo",(pageNo*pageSize));
            params.put("pageSize",pageSize);
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
//            pageNo++;
//            if(weatherDataEntities.size()<pageSize) break;
//        }

    }
    /*public ExportExcel exportExcel() {
        List<String> headerList = Lists.newArrayList();
        headerList.add("序号");
        headerList.add("故障设备专业");
        headerList.add("故障分类");
        headerList.add("故障标题");
        headerList.add("设备责任部门");
        headerList.add("上报人");
        headerList.add("接报时间");
        headerList.add("上报类型");
        headerList.add("线路");
        headerList.add("故障区间(始)");
        headerList.add("故障区间(终)");
        headerList.add("行别");
        headerList.add("公里标");
        headerList.add("百米标");
        headerList.add("车辆段(主变电所)");
        headerList.add("车站");
        headerList.add("其它具体地点");
        headerList.add("故障详情描述");



        ExportExcel ee = new ExportExcel("天气与空气质量", headerList);

        for (int i = 0; i < faultRepairList.size(); i++) {
            Row row = ee.addRow();
            FaultRepair faultRepair = faultRepairList.get(i);
            MetroFault param = faultRepair.getMetroFault();
            MetroFault metroFault = metroFaultService.get(param.getFaultId());
            int j = 0;
            int k = i+1;
            ee.addCell(row, j++,k+"");// 序号
            List<FaultProRelation> faultProRelations = metroFault.getFaultProRelationList();
            String proString = "";
            for(FaultProRelation faultProRelation:faultProRelations){
                proString += DictUtils.getDictLabel(faultProRelation.getProfessionValue(),"fault_equipment_major","") + " ";
            }
            ee.addCell(row, j++,proString);// 故障设备专业
            ee.addCell(row, j++,DictUtils.getDictLabel(metroFault.getFaultClassify(),"fault_classify",""));// 故障分类
            ee.addCell(row, j++,metroFault.getTitle());// 故障标题
            if(metroFault.getOffice()==null){
                ee.addCell(row, j++,"");//故障设备责任部门
            }else{
                ee.addCell(row, j++,metroFault.getOffice().getName());//故障设备责任部门
            }
            ee.addCell(row, j++,metroFault.getUser().getName());//上报人
            ee.addCell(row, j++,metroFault.getCreateDate());//接报时间
            ee.addCell(row, j++,DictUtils.getDictLabel(metroFault.getIsNeedRepair(),"fault_commit_type",""));//接报类型，是否需要抢修
            ee.addCell(row, j++,metroFault.getLineName());//线路
            ee.addCell(row, j++,metroFault.getFaultRegionStartName());//故障区间 始
            ee.addCell(row, j++,metroFault.getFaultRegionEndName());//故障区间 终
            ee.addCell(row, j++,metroFault.getLineRegionName());//行别
            ee.addCell(row, j++,metroFault.getKilometerPost());//公里标
            ee.addCell(row, j++,metroFault.getHundredmeterPost());//百米标
            ee.addCell(row, j++,metroFault.getSubstationName());//车辆段主变电所
            ee.addCell(row, j++,metroFault.getStationName());//车站
            ee.addCell(row, j++,metroFault.getOtherLocation());//其它具体地点
            ee.addCell(row, j++,metroFault.getDescription());//故障详情描述
        }
        return ee;
    }*/
}
