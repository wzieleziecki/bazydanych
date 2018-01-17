package pl.edu.agh.bazydanych2017.dao;

import pl.edu.agh.bazydanych2017.model.Products;

import java.util.List;

public interface JdbcProductsDao{

    Products findByProductname(String productname);
    List<Products> sortByProductname();
    int setUnitPrice(Double addToUnitPrice, String categroryname );

}
