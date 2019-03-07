package ad;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class ReportDataDao {
    Connection conn=null;
    ResultSet resultSet = null;
    Statement statement=null;
    public String result;

    //连接Sqlite数据库
    private Connection connect(){
        try {
            String url = "jdbc:sqlite:E:\\workspace\\myself\\spring\\test\\src\\main\\resources\\Database\\ad-db";  //定义连接数据库的url
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
//            System.out.println(conn);
            System.out.println("连接成功");
        } catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
            System.out.println("连接失败"+e.getMessage());
        }
        return conn;
    }

    //按照taskid和show_track_time进行查找
    public String selectByTask(int show_track_time,int task_id) {
        connect();
        String sql="select count(show_track_time) as track from REPORT_DATA\n" +
                "where show_track_time= " +show_track_time+"\n"+
                "and task_id=" +task_id;
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            System.out.println("show_track_time:"+resultSet.getString("track"));
            result = resultSet.getString("track");
//            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //按照taskid和show_track_time进行查找
//    public ReportData selectByTask1(int show_track_time,int task_id) {
//        connect();
//        String sql="select count(show_track_time) as track from REPORT_DATA\n" +
//                "where show_track_time= " +show_track_time+"\n"+
//                "and task_id=" +task_id;
//        try {
//            statement = conn.createStatement();
//            resultSet = statement.executeQuery(sql);
//            System.out.println("show_track_time:"+resultSet.getString("track"));
//            ReportData result = resultSet.getObject("track");
////            return result;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }

    @Test
    public void getResult(){
        String result1 = selectByTask(-1,4222);
        System.out.println("result1:"+result1);
    }


}
