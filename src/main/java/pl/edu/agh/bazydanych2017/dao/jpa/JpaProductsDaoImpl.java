package pl.edu.agh.bazydanych2017.dao.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.bazydanych2017.dao.JdbcProductsDao;
import pl.edu.agh.bazydanych2017.dao.JpaProductsDao;
import pl.edu.agh.bazydanych2017.model.Categories;
import pl.edu.agh.bazydanych2017.model.Products;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JpaProductsDaoImpl {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void createCategory(Categories categories){
        em.persist(categories);
    }

    @Transactional
    public void createProduct(Products products){
        em.persist(products);
    }

}
