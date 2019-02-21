package spring.transactionxmlserviceimpl;

import org.springframework.stereotype.Service;
import spring.transactionxmlservice.BookShopService;
import spring.transactionxmlservice.CashiserService;

import java.util.List;

@Service("cashiserService")
public class CasherServiceImpl implements CashiserService {

    private BookShopService bookShopService;

    public void setBookShopService(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    @Override
    public void checkout(String username, List<Integer> isbns) {
        for (Integer isbn:isbns) {
            bookShopService.purchase(username,isbn);
        }
    }
}
