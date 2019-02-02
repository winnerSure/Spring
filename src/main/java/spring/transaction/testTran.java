package spring.transaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class testTran {

    private ApplicationContext apx=null;
    private BookShopDao bookShopDao=null;
    private BookShopService bookShopService=null;
    private CashiserService cashiserService=null;

    {
        apx = new ClassPathXmlApplicationContext("beans-transaction-property.xml");
        bookShopDao = apx.getBean(BookShopDao.class);
        bookShopService = apx.getBean(BookShopService.class);
        cashiserService = apx.getBean(CashiserService.class);
    }

    @Test
    public void testfindBookPriceByIsbn(){

        System.out.println(bookShopDao.findBookPriceByIsbn(1001));
    }

    @Test
    public void testUpdateBookStock(){
        bookShopDao.updateBookStock(1001);
    }

    @Test
    public void testUpdateUserAccount(){
        bookShopDao.updateUserAccount("AA",30);
    }

    @Test
    public void testBookShopService(){
        bookShopService.purchase("AA",1001);
    }

    //测试事务的传播行为
    @Test
    public void testTranscationPropagation(){
        cashiserService.checkout("AA",Arrays.asList(1001,1002));
    }
}
