package pl.edu.agh.bazydanych2017.dao.jdbc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcProductsCategoriesVODao;
import pl.edu.agh.bazydanych2017.model.ProductsCategoriesVO;

import java.util.List;

@Repository
public class JdbcJdbcProductsCategoriesVO implements JdbcProductsCategoriesVODao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcJdbcProductsCategoriesVO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final RowMapper<ProductsCategoriesVO> productsCategoriesVORowMapper = (rs, rowNum) -> {
        ProductsCategoriesVO productsCategoriesVO = new ProductsCategoriesVO();
        productsCategoriesVO.setCategoryname(rs.getString("CategoryName"));
        productsCategoriesVO.setProductname(rs.getString("ProductName"));
        productsCategoriesVO.setQuantityperunit(rs.getString("QuantityPerUnit"));
        productsCategoriesVO.setUnitsinstock(rs.getLong("UnitsInStock"));
        productsCategoriesVO.setDiscontinued(rs.getString("Discontinued"));
        return productsCategoriesVO;
    };

    @Override
    public List<ProductsCategoriesVO> productByCategory(String discontinued) {
        String sql = "select distinct a.CategoryName, b.ProductName, b.QuantityPerUnit, b.UnitsInStock, b.Discontinued from Categories a inner join Products b on a.CategoryID = b.CategoryID where b.Discontinued = ? order by a.CategoryName, b.ProductName";
        return jdbcTemplate.query(sql, productsCategoriesVORowMapper,discontinued);
    }
}
