package ad;

import java.util.List;

public class Common {

    //比较值是否相等
  /*
  关于对象结果，需要在属性方法中重写equals和hashCode方法，参考AdResourceResultDao
   */
  public void compare(List<Object> obj1,List<Object> obj2){
      if(obj1.equals(obj2)){
          System.out.println("值相等:"+obj1+"="+obj2);
      }else {
          System.out.println("值不相等："+obj1+"="+obj2);
          throw new MyException("值不相等");
      }
  }

}
