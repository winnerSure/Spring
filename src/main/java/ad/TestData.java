package ad;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

public class TestData {

    private AdResourceResultDao adResourceResultDao;
    private ApplicationContext applicationContext;
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    Common common = new Common();

    {
        applicationContext = new ClassPathXmlApplicationContext("beans-ad-property.xml");
        dataSource = (DataSource) applicationContext.getBean("dataSource");
        jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        adResourceResultDao = applicationContext.getBean(AdResourceResultDao.class);
    }

    @BeforeClass
    public static void beforeClass(){
        //pull屏端数据库
//        common.pullFile("10.1.106.26");
    }

    //针对e-dev数据库进行查询
    @Test
    public void testselectPlayCountResult(){
        List<AdResourceResult> obj1 = new ArrayList<>();
        List<AdResourceResult> obj2 = new ArrayList<>();
        obj1 = adResourceResultDao.selectPlayCountResultWithParam("b0:f1:ec:3d:bd:20",2824,20181106);
        obj2 = adResourceResultDao.selectPlayCountResult();
        System.out.println(obj1+"\n"+obj2);
        System.out.println(obj1.equals(obj2));
    }


    //比较播放数结果  参考https://www.cnblogs.com/shininguang/p/5294157.html
    @Test
    public void testPlayCountResult(){
        String result = adResourceResultDao.selectPlayCount("b0:f1:ec:3d:bd:20",2824,20181106);
        ReportDataDao reportDataDao = new ReportDataDao();
        String report = reportDataDao.selectByTask(-1,4222);
        System.out.println(report);
        common.compareValue(report,result);
    }

    //测试mysql数据库连接
    @Test
    public void testjdbc(){
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        common.pullFile("10.1.106.26");
    }


}
