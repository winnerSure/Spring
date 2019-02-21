package spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("bookShopService")
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;

    //添加事务注解  @Transactional  (基于注解方式添加事务)
    /*
    1.propagation:指定事务的传播行为，当一个事务被另一个事务调用时，采取的措施
    默认为Propagation.REQUIRED，即调用方法的事务，当余额不足时，一本都买不成功
    REQUIRES_NEW:开启一个新的事务，当余额不足时，能买一本是一本
    2.使用isolation指定事务隔离级别，最常用的取值为READ_COMMITTED
    3.默认情况下，Spring的声明式事务对所有的运行式异常进行回滚，也可以通过对应的属性进行设置
    通常情况下取默认值即可  noRollbackFor = {UserAccountException.class}
    4.使用readOnly指定事务为只读，这样可以帮助数据库优化事务，若果真的是一个只读数据库的方法，应设置readOnly=true
    5.使用timeout指定强制回滚之前事务可以占用的时间
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,
    isolation = Isolation.READ_COMMITTED,
    readOnly = false,
    timeout = 1)
    @Override
    public void purchase(String username, int isbn) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);

        //更新库存
        bookShopDao.updateBookStock(isbn);

        //更新用户余额
        bookShopDao.updateUserAccount(username,price);

    }
}
