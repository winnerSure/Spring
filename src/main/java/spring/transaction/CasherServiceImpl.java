package spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cashiserService")
public class CasherServiceImpl implements CashiserService {

    @Autowired
    private BookShopService bookShopService;

    @Override
    public void checkout(String username, List<Integer> isbns) {
        for (Integer isbn:isbns) {
            bookShopService.purchase(username,isbn);
        }
    }
}
