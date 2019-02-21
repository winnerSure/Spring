package spring.transactionxml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public class BookShopDaoImpl implements BookShopDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int findBookPriceByIsbn(int isbn) {
        String sql="SELECT price FROM book WHERE isbn=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,isbn);
    }

    public void updateBookStock(int isbn) {
        String sql1="SELECT stock FROM book_stock WHERE isbn=?";
        int stock = jdbcTemplate.queryForObject(sql1,Integer.class,isbn);
        if(stock==0){
            throw new BookShopDaoException("库存不足");
        }

        String sql = "UPDATE book_stock SET stock=stock-1 WHERE isbn=?";
        jdbcTemplate.update(sql,isbn);
    }

    public void updateUserAccount(String username, int price) {
        String sql1="SELECT balance FROM account WHERE username=?";
        int balance = jdbcTemplate.queryForObject(sql1,Integer.class,username);
        if(balance<price){
            System.out.println("balance:"+balance+"<"+"price"+price);
            throw new UserAccountException("余额不足！");
        }

        String sql = "UPDATE account SET balance=balance-? WHERE username=?";
        jdbcTemplate.update(sql,price,username);

    }
}
