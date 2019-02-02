package spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;


@Repository
public class DepartmentsDao extends JdbcDaoSupport {
    @Autowired
    private void setDataSource2(DataSource dataSource){
        setDataSource(dataSource);
    }

    public Departments get(Integer id){
        String sql = "select id,dept_name from departments where id = ?";
        RowMapper<Departments> rowMapper = new BeanPropertyRowMapper<Departments>(Departments.class);
        return getJdbcTemplate().queryForObject(sql,rowMapper,id);

    }
}
