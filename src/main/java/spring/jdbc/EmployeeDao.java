package spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
注意，xml配置文件需要加入自动扫描
    <!--配置组件扫描目录-->
    <context:component-scan base-package="spring.jdbc"/>
 */
@Repository
public class EmployeeDao{

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public Employee getObject(Integer id){
        String sql = "SELECT id,last_name,email from employee WHERE id = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
        Employee employees = jdbcTemplate.queryForObject(sql,rowMapper,id);
        return  employees;
    }
    //查询实体类的集合
    public List<Employee> getQueryForList(Integer id){
        String sql = "SELECT id,last_name,email from employee WHERE id > ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
        List<Employee> employees = jdbcTemplate.query(sql,rowMapper,id);
        return employees;
    }
}
