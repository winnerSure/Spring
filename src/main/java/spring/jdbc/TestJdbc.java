package spring.jdbc;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJdbc {
    private ApplicationContext apx = null;
    private DataSource dataSource = null;
    private JdbcTemplate jdbcTemplate = null;
    private DepartmentsDao departmentsDao;
    private EmployeeDao employeeDao;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;

    {
        apx = new ClassPathXmlApplicationContext("beans-jdbc-property.xml");
        dataSource = (DataSource) apx.getBean("dataSource2");
        jdbcTemplate = (JdbcTemplate) apx.getBean("jdbcTemplate");
        //需要再xml文件中配置自动扫描的包    <context:component-scan base-package="spring.jdbc"/>
        departmentsDao = apx.getBean(DepartmentsDao.class);
        employeeDao = apx.getBean(EmployeeDao.class);
        namedParameterJdbcTemplate = apx.getBean(NamedParameterJdbcTemplate.class);
    }

    @Test
    public void testjdbc(){
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //可以为参数指定名字，适用于插入参数比较多的，避免乱序
    @Test
    public void testNamedParameterJdbcTemplate(){
        String sql = "INSERT INTO employee(id,last_name,email,dept_id) VALUES(:id,:lastName,:email,:deptid)";
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("id",9);
        map.put("lastName","testName");
        map.put("email","testName@email.com");
        map.put("deptid",5);
        namedParameterJdbcTemplate.update(sql,map);
    }

    @Test
    public void testNamedParameterJdbcTemplate2(){
        String sql = "INSERT INTO employee(id,last_name,email,dept_id) VALUES(:id,:last_name,:email,:dept_id)";
        Employee employee = new Employee();
        employee.setId(7);
        employee.setLast_name("test777");
        employee.setEmail("dsfda@dfadf.com");
        employee.setDept_id(5);
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(employee);
        namedParameterJdbcTemplate.update(sql,parameterSource);
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
    /*
    使用Sql中列的别名完成列名和类的属性名的映射，例如last_name lastname
    不支持级联属性，JdbcTemplate只是JDBC的一个小工具，而不是ORM
     */
    @Test
    public void testObject(){
        String sql = "SELECT id,last_name,email from employee WHERE id = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql,rowMapper,1);
        System.out.println(employee);
    }

    //统计
    @Test
    public void testqueryForObjectCount(){
        String sql = "SELECT count(id) from employee";
        Long count = jdbcTemplate.queryForObject(sql,Long.class);
        System.out.println(count);
    }

    //查询实体类的集合
    @Test
    public void testQueryForList(){
        String sql = "SELECT id,last_name,email from employee WHERE id > ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
        List<Employee> employees = jdbcTemplate.query(sql,rowMapper,2);
        System.out.println(employees);
    }

    @Test
    public void testDeotDao(){
        System.out.println(departmentsDao.get(1));
    }

    @Test
    public void testEmployeeDao(){
        System.out.println(employeeDao.getObject(2));
        System.out.println(employeeDao.getQueryForList(2));
    }


}
