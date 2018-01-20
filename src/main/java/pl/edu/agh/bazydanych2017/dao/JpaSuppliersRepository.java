package pl.edu.agh.bazydanych2017.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.agh.bazydanych2017.model.Suppliers;

public interface JpaSuppliersRepository extends JpaRepository<Suppliers, Long> {

    Suppliers findByCompanyname(String companyname);

}
