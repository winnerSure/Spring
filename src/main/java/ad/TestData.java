package ad;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

public class TestData {

    private AdResourceResultDao adResourceResultDao;
    private ApplicationContext applicationContext;
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    {
        applicationContext = new ClassPathXmlApplicationContext("beans-ad-property.xml");
        dataSource = (DataSource) applicationContext.getBean("dataSource");
        jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        adResourceResultDao = applicationContext.getBean(AdResourceResultDao.class);
    }

    @Test
    public void testselectPlayCountResult(){
        List<AdResourceResult> obj1 = new ArrayList<>();
        List<AdResourceResult> obj2 = new ArrayList<>();
        obj1 = adResourceResultDao.selectPlayCountResultWithParam("b0:f1:ec:3d:bd:20",2824,20181106);
        obj2 = adResourceResultDao.selectPlayCountResult();
       System.out.println(obj1+"\n"+obj2);

        Arrays.sort(new List[]{obj1});
        Arrays.sort(new List[]{obj2});
        boolean result = Arrays.equals(new List[]{obj1},new List[]{obj2});
        System.out.println(result);

    }

    //比较结果  参考https://www.cnblogs.com/shininguang/p/5294157.html
    public void testResult(){
        Map<AdResourceResult,AdResourceResult> m1 = new HashMap<AdResourceResult, AdResourceResult>();
        Map<AdResourceResult,AdResourceResult> m2 = new HashMap<AdResourceResult, AdResourceResult>();
//        m1 = adResourceResultDao.selectPlayCountResultWithParam("b0:f1:ec:3d:bd:20",2824,20181106);

    }

    @Test
    public void testjdbc(){
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
