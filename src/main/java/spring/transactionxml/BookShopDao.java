package spring.transactionxml;

public interface BookShopDao {

    //根据书号获取书的单价
    public int findBookPriceByIsbn(int isbn);

    //更新书的库存，使书号对应的库存-1
    public void updateBookStock(int isbn);

    //更新用户的账户余额：使username的balance-price
    public void updateUserAccount(String username, int price);
}
