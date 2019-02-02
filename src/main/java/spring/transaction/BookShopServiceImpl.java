package spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("bookShopService")
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;

    //添加事务注解
    /*
    propagation:指定事务的传播行为，当一个事务被另一个事务调用时，采取的措施
    默认为Propagation.REQUIRED，即调用方法的事务，当余额不足时，一本都买不成功
    REQUIRES_NEW:开启一个新的事务，当余额不足时，能买一本是一本
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void purchase(String username, int isbn) {
        //获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);

        //更新库存
        bookShopDao.updateBookStock(isbn);

        //更新用户余额
        bookShopDao.updateUserAccount(username,price);

    }
}
