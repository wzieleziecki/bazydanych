package pl.edu.agh.bazydanych2017.dao;

import pl.edu.agh.bazydanych2017.model.ProductsCategoriesVO;

import java.util.List;

public interface ProductsCategoriesVODao {

    List<ProductsCategoriesVO> productByCategory(String discontinued);
}
