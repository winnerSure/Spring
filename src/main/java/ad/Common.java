package ad;

import org.junit.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Common {

    //比较值是否相等
  /*
  关于对象结果，需要在属性方法中重写equals和hashCode方法，参考AdResourceResultDao
   */
  public void compareObject(List<Object> obj1,List<Object> obj2){
      if(obj1.equals(obj2)){
          System.out.println("值相等:"+obj1+"="+obj2);
          assert true;
      }else {
          assert false;
          System.out.println("值不相等："+obj1+"="+obj2);
          throw new MyException("值不相等");
      }
  }

  public void compareValue(String value1,String value2){
      if(value1==value2){
          System.out.println(value1+"结果匹配"+value2);
          Assert.assertTrue(true);
      }else {
          Assert.assertTrue(value1+"结果不匹配"+value2,false);
      }
  }


    //           BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));

  //使用adb命令读取android屏端广告数据库
    //默认pull 路径：E:\workspace\myself\spring\test\src\main\resources\Database\ad-db
   public void pullFile(String ip) {
       try {
           Process process = Runtime.getRuntime().exec("cmd /c adb connect " + ip);
           System.out.println(process);
           Thread.sleep(3000);
           process = Runtime.getRuntime().exec("cmd /c adb remount");
           process = Runtime.getRuntime().exec("cmd /c adb pull /sdcard/advertisementAd/dbs/ad-db E:\\workspace\\myself\\spring\\test\\src\\main\\resources\\Database\\");
           Thread.sleep(30000);  //等待时间
           process = Runtime.getRuntime().exec("cmd /c adb disconnect");
           Thread.sleep(2000);
           process.destroy();
           System.out.println("ad-db文件拉取成功");
       } catch (InterruptedException | IOException e) {
           e.printStackTrace();
       }
   }
}
