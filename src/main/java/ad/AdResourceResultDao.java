package ad;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import spring.jdbc.Employee;

import java.util.HashMap;
import java.util.List;

@Repository
public class AdResourceResultDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*  t_resource_result表
        根据条件查询广告数据库中播放数据
        Param:code:mac地址
        task：任务id
        date:日期
     */
    public List<AdResourceResult> selectPlayCountResultWithParam(String code, int task, int date){
        String sql = "SELECT SUM(A.play_count) as play_count,SUM(A.valid_cpm_play_count) as valid_cpm_play_count,SUM(A.play_sec) as play_sec,A.date_id,A.task_id" +
                " FROM (" +
                "SELECT t.media_resource_code,t.play_count,t.valid_cpm_play_count,t.play_sec,t.date_id,t.task_id FROM t_resource_result t" +
                " WHERE t.media_resource_code=?" +
                " AND task_id=? AND date_id >= ?" +
                " ORDER BY t.date_id) AS A" +
                " GROUP BY A.date_id";
        RowMapper<AdResourceResult> rowMapper = new BeanPropertyRowMapper<AdResourceResult>(AdResourceResult.class);
        List<AdResourceResult> adResourceResults = jdbcTemplate.query(sql,rowMapper,code,task,date);
        return adResourceResults;
    }

    //查询广告数据库中播放数据(条件写死)  t_resource_result表
    public List<AdResourceResult> selectPlayCountResult(){
        String sql = "SELECT SUM(A.play_count) as play_count,SUM(A.valid_cpm_play_count) as valid_cpm_play_count,SUM(A.play_sec) as play_sec,A.date_id,A.task_id" +
                " FROM (" +
                "SELECT t.media_resource_code,t.play_count,t.valid_cpm_play_count,t.play_sec,t.date_id,t.task_id FROM t_resource_result t" +
                " WHERE t.media_resource_code IN ('b0:f1:ec:3d:bd:20')" +
                "AND date_id >= 20181106 AND task_id=2824" +
                " ORDER BY t.date_id) AS A" +
                " GROUP BY A.date_id";
        RowMapper<AdResourceResult> rowMapper = new BeanPropertyRowMapper<AdResourceResult>(AdResourceResult.class);
        List<AdResourceResult> adResourceResults = jdbcTemplate.query(sql,rowMapper);
        return adResourceResults;
    }

    //获取播放数
    public String selectPlayCount(String code,int task,int date){
        String sql = "SELECT SUM(A.play_count) as play_count" +
                " FROM (" +
                "SELECT t.media_resource_code,t.play_count,t.valid_cpm_play_count,t.play_sec,t.date_id,t.task_id FROM t_resource_result t " +
                "WHERE t.media_resource_code=? " +
                "AND task_id=? AND date_id =? " +
                "ORDER BY t.date_id) AS A " +
                "GROUP BY A.date_id";
        String playCount = jdbcTemplate.queryForObject(sql,String.class,code,task,date);
        System.out.println(playCount);
        return playCount;
    }


//    @Test
//    public void testSelectPlayCount(){
//        new ReportDataDao().selectPlayCount();
//    }

}
