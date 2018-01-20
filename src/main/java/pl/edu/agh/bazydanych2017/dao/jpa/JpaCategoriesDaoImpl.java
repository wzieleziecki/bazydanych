package pl.edu.agh.bazydanych2017.dao.jpa;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.bazydanych2017.dao.JpaCategoriesDao;
import pl.edu.agh.bazydanych2017.model.Categories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class JpaCategoriesDaoImpl implements JpaCategoriesDao{

    private final JpaCategoriesRepository jpaCategoriesRepository;
    private final Logger logger = Logger.getLogger(JpaProductsDaoImpl.class);

    public JpaCategoriesDaoImpl(JpaCategoriesRepository jpaCategoriesRepository) {
        this.jpaCategoriesRepository = jpaCategoriesRepository;
    }

    @PersistenceContext
    private EntityManager em;

    //transakcja krok 2
    @Override
    public int deleteCategoryByCategoryname(String categoryname){
        long StartTime = System.nanoTime();
        int i = jpaCategoriesRepository.deleteCategroryByCategoryname(categoryname);
        long EndTime = System.nanoTime();
        long output = EndTime - StartTime;
        logger.info("JPA delete category by categoryname - time "+ output);
        return i;
    }

    //transakcja step 3
    @Override
    @Transactional
    public void createNewCategory(String categoryname, String description){
        Categories categories = new Categories( categoryname, description);
        long StartTime = System.nanoTime();
        em.persist(categories);
        long EndTime = System.nanoTime();
        long output = EndTime - StartTime;
        logger.info("JPA create new category - time "+ output);
    }


}
