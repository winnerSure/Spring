package spring.transactionxmlservice;

import org.springframework.transaction.annotation.Transactional;

public interface BookShopService {

    @Transactional
    public void purchase(String username, int isbn);

}
