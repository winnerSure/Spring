package spring.property;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class TestProperty {
    @Test
    public void testProperty(){
        ApplicationContext apx = new ClassPathXmlApplicationContext("beans-property.xml");
        DataSource dataSource = (DataSource) apx.getBean("dataSource");
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
