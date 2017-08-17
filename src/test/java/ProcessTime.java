import com.bupt.pm25.model.AirStatus;
import com.bupt.pm25.model.ResultDataEntity;
import com.bupt.pm25.util.LogsReaderUtils;
import com.bupt.pm25.util.excel.ExportExcel;
import com.google.common.collect.Lists;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by katiemi on 2017/1/12.
 */
public class ProcessTime {
    private static Logger LOGGER = LoggerFactory.getLogger(PictureLabel.class);
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    public static void main(String[] args) throws Exception {
        String ss1 = LogsReaderUtils.readFromFile("/Users/katiemi/work/bupt/logs/20161031.log",".jpeg","time");
        LogsReaderUtils.writeIntoFile(ss1,"/Users/katiemi/work/bupt/logs/logs.out",true);

        String ss2 = LogsReaderUtils.readFromFile("/Users/katiemi/work/bupt/logs/20161102.log",".jpeg","time");
        LogsReaderUtils.writeIntoFile(ss2,"/Users/katiemi/work/bupt/logs/logs.out",true);

        String ss3 = LogsReaderUtils.readFromFile("/Users/katiemi/work/bupt/logs/20170221.log",".jpeg","time");
        LogsReaderUtils.writeIntoFile(ss3,"/Users/katiemi/work/bupt/logs/logs.out",true);

        String ss4 = LogsReaderUtils.readFromFile("/Users/katiemi/work/bupt/logs/20170427.log",".jpeg","time");
        LogsReaderUtils.writeIntoFile(ss4,"/Users/katiemi/work/bupt/logs/logs.out",true);

        String ss5 = LogsReaderUtils.readFromFile("/Users/katiemi/work/bupt/logs/20170428.log",".jpeg","time");
        LogsReaderUtils.writeIntoFile(ss5,"/Users/katiemi/work/bupt/logs/logs.out",true);

        String ss6 = LogsReaderUtils.readFromFile("/Users/katiemi/work/bupt/logs/20170528.log",".jpeg","time");
        LogsReaderUtils.writeIntoFile(ss6,"/Users/katiemi/work/bupt/logs/logs.out",true);

        String ss7 = LogsReaderUtils.readFromFile("/Users/katiemi/work/bupt/logs/20170531.log",".jpeg","time");
        LogsReaderUtils.writeIntoFile(ss7,"/Users/katiemi/work/bupt/logs/logs.out",true);

        String ss8 = LogsReaderUtils.readFromFile("/Users/katiemi/work/bupt/logs/20170609.log",".jpeg","time");
        LogsReaderUtils.writeIntoFile(ss8,"/Users/katiemi/work/bupt/logs/logs.out",true);

        String ss9 = LogsReaderUtils.readFromFile("/Users/katiemi/work/bupt/logs/20170620.log",".jpeg","time");
        LogsReaderUtils.writeIntoFile(ss9,"/Users/katiemi/work/bupt/logs/logs.out",true);
    }

}
