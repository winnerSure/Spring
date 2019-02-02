package spring.transaction;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CashiserService {

    public void checkout(String username, List<Integer> isbns);
}
