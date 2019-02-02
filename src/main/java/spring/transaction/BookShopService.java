package spring.transaction;

import org.springframework.transaction.annotation.Transactional;

//添加事务注解
@Transactional
public interface BookShopService {

    public void purchase(String username,int isbn);

}
