import com.bupt.pm25.constant.DataConstant;
import com.bupt.pm25.model.AirStatus;
import com.bupt.pm25.model.ResultDataEntity;
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
 * Created by katiemi on 2016/10/25.
 */
public class ExportResultData {
    public static void main(String[] args) throws IOException {
        //mybatis的配置文件
        String resource = "mybatis.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = ExportResultData.class.getClassLoader().getResourceAsStream(resource);
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
        String statement = "com.bupt.pm25.dao.ResultDataDao.findList";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        int pageNo = 0;
        int pageSize = 120;

//        while (true){
        List<String> headerList = Lists.newArrayList();
        headerList.add("序号");
        headerList.add("拍摄城市");
        headerList.add("拍摄地点");
        headerList.add("拍摄地点编码");
        headerList.add("手机型号");
        headerList.add("图片名称");
        headerList.add("预测值");
        headerList.add("当地PM2.5站点检测值");
        headerList.add("拍摄时间");
        headerList.add("拍摄地点经度");
        headerList.add("拍摄地点纬度");
        headerList.add("距离");
        ExportExcel ee = new ExportExcel("预测值与真实值对比", headerList);
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("pageNo", (pageNo * pageSize));
        params.put("pageSize", pageSize);
        List<ResultDataEntity> resultDataEntities = session.selectList(statement, params);
        int i = 1;
        for (ResultDataEntity entity:resultDataEntities){
            AirStatus airStatus = new AirStatus();
            if (entity == null) continue;
            if (entity.getDistrictCode() != null) {
                entity.setDistrictName(entity.getDistrictCode().trim());
            }

//                //海淀区
//            if ("00101".equals(entity.getDistrictCode())) {
//                airStatus.setStationId("7");
//                //密云
//            } else if ("00115".equals(entity.getDistrictCode())) {
//                airStatus.setDic("00110");
//                //门头沟
//            } else if ("00112".equals(entity.getDistrictCode())) {
//                airStatus.setDic("00102");
//                //延庆
//            } else if ("00116".equals(entity.getDistrictCode())) {
//                airStatus.setDic("00111");
//                //平谷
//            } else if ("00113".equals(entity.getDistrictCode())) {
//                airStatus.setDic("00110");
//                //大兴
//            } else if ("00108".equals(entity.getDistrictCode())) {
//                airStatus.setDic("00103");
//                //通州
//            } else if ("00109".equals(entity.getDistrictCode())) {
//                airStatus.setDic("00103");
//            } else {
//                airStatus.setDic(entity.getDistrictCode());
//            }
            airStatus.setDic(entity.getDistrictCode());
            airStatus.setLat(entity.getLatitude());
            airStatus.setLon(entity.getLongitude());
            airStatus.setCreateTime(entity.getCreateDate());
            List<AirStatus> airStatuses = session.selectList("com.bupt.pm25.dao.AirStatusDao.selectByDistance", airStatus);
            Row row = ee.addRow();
            int k = 0;
            int n = 1;
            ee.addCell(row, k++, i++);
            ee.addCell(row, k++, "北京");
            ee.addCell(row, k++, DataConstant.CITY_CODE_NAME_MAP.get(entity.getDistrictCode()));
            ee.addCell(row, k++, entity.getDistrictCode());
            ee.addCell(row, k++, entity.getPhoneType());
            ee.addCell(row, k++, entity.getPicName());
            ee.addCell(row, k++, entity.getPredictValue());
            if (airStatuses != null && airStatuses.size() > 0) {
                AirStatus as = airStatuses.get(0);
                if(as != null)
                ee.addCell(row, k++, as.getPm25());
            }
            ee.addCell(row, k++, entity.getCreateDate());
            ee.addCell(row, k++, entity.getLongitude());
            ee.addCell(row, k++, entity.getLatitude());
            if (airStatuses != null && airStatuses.size() > 0) {
                AirStatus as = airStatuses.get(0);
                if(as != null)
                    ee.addCell(row, k++, as.getDistance());
            }
        }
        String fileName = "预测值与真实值对比.xlsx";
        ee.writeFile(fileName);
        System.out.println("pageNo = [" + pageNo + "]");
    }

}
