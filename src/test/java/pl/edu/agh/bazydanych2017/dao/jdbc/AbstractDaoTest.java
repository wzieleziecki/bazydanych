package pl.edu.agh.bazydanych2017.dao.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.bazydanych2017.dao.GenericCrudDao;

import java.io.Serializable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public abstract class AbstractDaoTest<DAO extends GenericCrudDao<T, PK>, T, PK extends Serializable> {

    DAO crudDao;

    public abstract void setCrudDao(DAO crudDao);

    abstract PK getPK(T entity);

    abstract T getSampleExistingEntity();

    abstract T getSampleNewEntity();

    abstract T getModifiedExistingEntity();

    @Test
    public void create() throws Exception {
        //given
        T newEntity = getSampleNewEntity();
        PK key = getPK(newEntity);
        //when
        T createdEntity = crudDao.create(newEntity);
        //then
        assertThat(createdEntity).isEqualTo(newEntity);
        T readEntity = crudDao.read(key);
        assertThat(readEntity).isEqualTo(newEntity);
    }

    @Test
    public void read() throws Exception {
        //given
        T existingEntity = getSampleExistingEntity();
        PK key = getPK(existingEntity);
        //when
        T entity = crudDao.read(key);
        //then
        assertThat(entity).isEqualTo(existingEntity);
    }

    @Test
    public void update() throws Exception {
        //given
        T modifiedEntity = getModifiedExistingEntity();
        PK key = getPK(modifiedEntity);
        //when
        T updatedEntity = crudDao.update(modifiedEntity);
        //then
        assertThat(updatedEntity).isEqualTo(modifiedEntity);
        T readEntity = crudDao.read(key);
        assertThat(readEntity).isEqualTo(modifiedEntity);
    }

    @Test
    public void delete() throws Exception {
        //given
        T entity = getSampleExistingEntity();
        PK key = getPK(entity);
        //when
        crudDao.delete(entity);
        //then
        Throwable throwable = catchThrowable(() -> crudDao.read(key));
        assertThat(throwable).isInstanceOf(EmptyResultDataAccessException.class);
    }
}