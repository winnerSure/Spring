package spring.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestJdbc {
    private ApplicationContext apx = null;
    private DataSource dataSource = null;
    private JdbcTemplate jdbcTemplate = null;

    {
        apx = new ClassPathXmlApplicationContext("beans-jdbc-property.xml");
        dataSource = (DataSource) apx.getBean("dataSource2");
        jdbcTemplate = (JdbcTemplate) apx.getBean("jdbcTemplate");
    }

    @Test
    public void testjdbc(){
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


//    执行单条修改，删除，查询
    @Test
    public void testUpdate(){
        String sql = "UPDATE employee SET last_name = ? WHERE id = ?";
        jdbcTemplate.update(sql,"monkey",3);
    }

//    批量操作
    @Test
    public void testBatchUpdate(){
        String sql = "INSERT INTO employee(id,last_name,email,dept_id) VALUES(?,?,?,?)";
        List<Object[]> batchArgs = new ArrayList<Object[]>();  //重点
        batchArgs.add(new Object[]{4,"test1","test1@cd.com",4}); //重点
        batchArgs.add(new Object[]{5,"test2","test1@cd.com",5});
        batchArgs.add(new Object[]{6,"test26","test24@cd.com",6});
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    //获取一个对象

    @Test
    public void testObject(){
        String sql = "SELECT id,last_name,email from employee WHERE id = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql,rowMapper,1);
        System.out.println(employee);
    }
}
