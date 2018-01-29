package pl.edu.agh.bazydanych2017.dao.jdbc;

import pl.edu.agh.bazydanych2017.model.ProductsCategoriesVO;

import java.util.List;

public interface JdbcProductsCategoriesVODao {

   List<ProductsCategoriesVO> productByCategory(String discontinued);
}
