import com.bupt.pm25.model.AirStatus;
import com.bupt.pm25.model.LgCompanyEntity;
import com.bupt.pm25.model.WeatherDataEntity;
import com.bupt.pm25.util.excel.ExportExcel;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.poi.ss.usermodel.Row;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by miguangshu on 2016/6/21.
 */
public class FetchLgCompanyData {
    public static ObjectMapper mapper = new ObjectMapper(); // create once, reuse

    public static void main(String[] args) throws IOException {
        //mybatis的配置文件
        String resource = "mybatis.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = FetchLgCompanyData.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "com.bupt.pm25.dao.LgCompanyDao.insertBatch";//映射sql的标识字符串
        String jsonResult = "{\"pageSize\":16,\"start\":\"16\",\"result\":[{\"companyId\":78892,\"companyFullName\":\"北京盈吉通电子商务有限公司\",\"companyShortName\":\"黄金管家\",\"companyLogo\":\"i/image/M00/47/41/CgqKkVePAVeAMWyGAAAfVDjxFIY504.jpg\",\"city\":\"北京\",\"industryField\":\"移动互联网,金融\",\"companyFeatures\":\"黄金投资理财服务第一平台\",\"financeStage\":\"成长型(A轮)\",\"interviewRemarkNum\":21,\"positionNum\":5,\"processRate\":100,\"approve\":1,\"countryScore\":0,\"cityScore\":0},{\"companyId\":37479,\"companyFullName\":\"南京易投贷金融信息服务有限公司\",\"companyShortName\":\"旺财谷\",\"companyLogo\":\"i/image/M00/27/BC/CgpEMlkb-L2AFCmjAADaAWmWw7Y428.png\",\"city\":\"北京\",\"industryField\":\"金融\",\"companyFeatures\":\"快乐 价值 成就 简单 高效\",\"financeStage\":\"成长型(A轮)\",\"interviewRemarkNum\":90,\"positionNum\":5,\"processRate\":9,\"approve\":1,\"countryScore\":0,\"cityScore\":0},{\"companyId\":99089,\"companyFullName\":\"天道计然（北京）信息科技有限责任公司\",\"companyShortName\":\"美利金融\",\"companyLogo\":\"i/image/M00/61/8A/Cgp3O1f8TveAKKXyAAAkQQWrCFg231.jpg\",\"city\":\"北京\",\"industryField\":\"移动互联网,金融\",\"companyFeatures\":\"以金融服务帮助年轻人一起创造美好生活，成为最具温度的互联网金融品牌！\",\"financeStage\":\"成长型(A轮)\",\"interviewRemarkNum\":128,\"positionNum\":103,\"processRate\":100,\"approve\":1,\"countryScore\":0,\"cityScore\":0},{\"companyId\":22884,\"companyFullName\":\"先花信息技术（北京）有限公司\",\"companyShortName\":\"先花花\",\"companyLogo\":\"image1/M00/00/2C/CgYXBlTUXHOAfPu9AABamTBrSeA589.png\",\"city\":\"北京\",\"industryField\":\"移动互联网,金融\",\"companyFeatures\":\"我们是社交金融和社交征信的领先者！\",\"financeStage\":\"成长型(A轮)\",\"interviewRemarkNum\":35,\"positionNum\":43,\"processRate\":100,\"approve\":1,\"countryScore\":0,\"cityScore\":0},{\"companyId\":43183,\"companyFullName\":\"天风天财（武汉）金融信息服务有限公司\",\"companyShortName\":\"甜菜金融\",\"companyLogo\":\"image1/M00/3B/B2/CgYXBlWxN4WAD-AEAABLy9vTBHE521.png\",\"city\":\"北京\",\"industryField\":\"金融\",\"companyFeatures\":\"打造领先的综合性金融信息服务平台\",\"financeStage\":\"成长型(不需要融资)\",\"interviewRemarkNum\":35,\"positionNum\":11,\"processRate\":82,\"approve\":1,\"countryScore\":0,\"cityScore\":0},{\"companyId\":113259,\"companyFullName\":\"北京熊猫盛世网络科技有限公司\",\"companyShortName\":\"熊猫金库\",\"companyLogo\":\"i/image/M00/33/5E/Cgp3O1dRNL2AUqIzAAAn8QpvcEo945.png\",\"city\":\"北京\",\"industryField\":\"移动互联网,金融\",\"companyFeatures\":\"做互联网金融颜值最高的产品 | 收获の不止是财富(。・`ω&acute;・)\",\"financeStage\":\"成长型(不需要融资)\",\"interviewRemarkNum\":72,\"positionNum\":12,\"processRate\":100,\"approve\":1,\"countryScore\":0,\"cityScore\":0},{\"companyId\":28277,\"companyFullName\":\"北京深度时代科技有限公司\",\"companyShortName\":\"深度数据\",\"companyLogo\":\"i/image/M00/32/89/Cgp3O1dOmZWAZz-fAAAdSC5IMY8128.png\",\"city\":\"北京\",\"industryField\":\"金融\",\"companyFeatures\":\"专注金融互联网数据挖掘分析\",\"financeStage\":\"成长型(A轮)\",\"interviewRemarkNum\":105,\"positionNum\":2,\"processRate\":100,\"approve\":1,\"countryScore\":0,\"cityScore\":0},{\"companyId\":17507,\"companyFullName\":\"北京花果信息技术有限公司\",\"companyShortName\":\"花果金融\",\"companyLogo\":\"i/image/M00/A0/B9/CgqKkVimpJiAAgM_AAEYhyQBNrI171.jpg\",\"city\":\"北京\",\"industryField\":\"金融\",\"companyFeatures\":\"花果金融 让你的财富开花结果\",\"financeStage\":\"成长型(A轮)\",\"interviewRemarkNum\":42,\"positionNum\":13,\"processRate\":100,\"approve\":1,\"countryScore\":0,\"cityScore\":0},{\"companyId\":49405,\"companyFullName\":\"蚂蚁白领（北京）投资管理有限公司\",\"companyShortName\":\"蚂蚁白领\",\"companyLogo\":\"image1/M00/3D/0E/Cgo8PFW3OOiAPk3eAABQnbn0W9U235.jpg\",\"city\":\"北京\",\"industryField\":\"移动互联网,金融\",\"companyFeatures\":\"蚂蚁白领是一家安全透明的互联网金融平台。创始团队来自华尔街和硅谷。\",\"financeStage\":\"成长型(A轮)\",\"interviewRemarkNum\":22,\"positionNum\":5,\"processRate\":100,\"approve\":1,\"countryScore\":0,\"cityScore\":0},{\"companyId\":43055,\"companyFullName\":\"北京轻松筹网络科技有限公司\",\"companyShortName\":\"轻松筹\",\"companyLogo\":\"image1/M00/2A/C0/CgYXBlVtOd6ADiZhAABMN1FvJIM082.png\",\"city\":\"北京\",\"industryField\":\"移动互联网,金融\",\"companyFeatures\":\"基于社交的全民众筹平台\",\"financeStage\":\"成熟型(C轮)\",\"interviewRemarkNum\":143,\"positionNum\":8,\"processRate\":100,\"approve\":1,\"countryScore\":0,\"cityScore\":0},{\"companyId\":106399,\"companyFullName\":\"北京神州微融金融信息服务有限公司\",\"companyShortName\":\"北京神州微融金融信息服务有限公司\",\"companyLogo\":\"i/image/M00/93/51/CgqKkViZho-AS_YBAAAoAH19rDA683.png\",\"city\":\"北京\",\"industryField\":\"金融\",\"companyFeatures\":\"顶级征信大数据平台，带薪年假、员工关怀、国内外旅、快速发展、为员工提供广阔晋升机会与发展\",\"financeStage\":\"成长型(A轮)\",\"interviewRemarkNum\":42,\"positionNum\":6,\"processRate\":100,\"approve\":1,\"countryScore\":0,\"cityScore\":0},{\"companyId\":23875,\"companyFullName\":\"北京盈衍网络科技有限公司\",\"companyShortName\":\"黄金钱包\",\"companyLogo\":\"i/image/M00/2E/86/CgpFT1k2Ym6AM59UAAAqn_YDrdg130.png\",\"city\":\"北京\",\"industryField\":\"移动互联网,金融\",\"companyFeatures\":\"互联网金融黄金垂直蓝海，全明星投资方，欢迎优秀的伙伴加入，专业靠谱的团队一起做专业靠谱的事情！\",\"financeStage\":\"成熟型(C轮)\",\"interviewRemarkNum\":59,\"positionNum\":22,\"processRate\":100,\"approve\":1,\"countryScore\":0,\"cityScore\":0},{\"companyId\":134210,\"companyFullName\":\"北京亿客财富信息技术服务有限公司\",\"companyShortName\":\"爱股票\",\"companyLogo\":\"i/image/M00/C2/44/CgqKkVjZzqSAe--sAAGiD622mx8257.png\",\"city\":\"北京\",\"industryField\":\"金融,移动互联网\",\"companyFeatures\":\"领导nice、氛围融洽、美女、帅锅一堆、提供横纵向发展空间、年节福利待遇好、弹性工作制\",\"financeStage\":\"成长型(B轮)\",\"interviewRemarkNum\":38,\"positionNum\":3,\"processRate\":100,\"approve\":1,\"countryScore\":0,\"cityScore\":0},{\"companyId\":69858,\"companyFullName\":\"武汉低温宝信息有限公司\",\"companyShortName\":\"天气宝\",\"companyLogo\":\"image1/M00/35/77/CgYXBlWbsAuAZrjVAAAf-OUfHZo324.jpg\",\"city\":\"北京\",\"industryField\":\"移动互联网,金融\",\"companyFeatures\":\"互联网天气衍生品（类保险），为用户的坏天气赔偿。\",\"financeStage\":\"成长型(A轮)\",\"interviewRemarkNum\":26,\"positionNum\":5,\"processRate\":75,\"approve\":1,\"countryScore\":0,\"cityScore\":0},{\"companyId\":136978,\"companyFullName\":\"北京玖富联银科技有限公司\",\"companyShortName\":\"玖富技术中心\",\"companyLogo\":\"i/image/M00/3F/16/CgqKkVd2JdKAewuuAAATpdprgrA613.jpg\",\"city\":\"北京\",\"industryField\":\"金融\",\"companyFeatures\":\"移动互联网金融综合服务平台\",\"financeStage\":\"成长型(A轮)\",\"interviewRemarkNum\":192,\"positionNum\":44,\"processRate\":100,\"approve\":0,\"countryScore\":0,\"cityScore\":0},{\"companyId\":59119,\"companyFullName\":\"君融贷（北京）信息技术服务有限公司\",\"companyShortName\":\"君融贷\",\"companyLogo\":\"i/image/M00/21/36/Cgp3O1cQU_-ADtiUAAAaLx-Z_J0830.jpg\",\"city\":\"北京\",\"industryField\":\"金融\",\"companyFeatures\":\"放心更走心！\",\"financeStage\":\"成长型(A轮)\",\"interviewRemarkNum\":88,\"positionNum\":5,\"processRate\":100,\"approve\":1,\"countryScore\":0,\"cityScore\":0}],\"totalCount\":\"1184\",\"pageNo\":2}";
        JsonNode root = mapper.readTree(jsonResult);
        JsonNode result = root.get("result");
        Iterator<JsonNode> companys =  result.elements();
        List<LgCompanyEntity> list = new ArrayList<LgCompanyEntity>();
        for(;companys.hasNext();){
            JsonNode companyNode = companys.next();
            LgCompanyEntity companyEntity = new LgCompanyEntity();
            companyEntity.setCompanyCode(companyNode.get("companyId").asText());
            companyEntity.setCompanyFullName(companyNode.get("companyFullName").asText());
            companyEntity.setCompanyShortName(companyNode.get("companyShortName").asText());
            companyEntity.setCompanyLogo(companyNode.get("companyLogo").asText());
            companyEntity.setCity(companyNode.get("city").asText());
            companyEntity.setIndustryField(companyNode.get("industryField").asText());
            companyEntity.setCompanyFeatures(companyNode.get("approve").asText());
            companyEntity.setFinanceStage(companyNode.get("financeStage").asText());
            companyEntity.setInterviewRemarkNum(companyNode.get("interviewRemarkNum").asInt());
            companyEntity.setProcessRate(companyNode.get("processRate").asInt());
            companyEntity.setApprove(companyNode.get("approve").asInt());
            companyEntity.setCityScore(companyNode.get("cityScore").asText());
            companyEntity.setCountryScore(companyNode.get("countryScore").asText());
            Document doc = Jsoup.connect(String.format("https://www.lagou.com/gongsi/%s.html",companyEntity.getCompanyCode())).get();
            Elements companyIntroText = doc.getElementsByClass("company_intro_text");
            list.add(companyEntity);
        }
        session.insert(statement,list);
        session.commit();
    }

}
