package pl.edu.agh.bazydanych2017.dao.jpa.repository;

import org.springframework.stereotype.Repository;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaReportView;
import pl.edu.agh.bazydanych2017.model.Report;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class JpaReportViewImpl implements JpaReportView {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Report> detailInformationForInvoice(){
        Query query = em.createNativeQuery("SELECT DISTINCT b.ShipName, \n" +
                "    b.ShipAddress, \n" +
                        "    b.ShipCity, \n" +
                        "    b.ShipRegion, \n" +
                        "    b.ShipPostalCode, \n" +
                        "    b.ShipCountry, \n" +
                        "    b.CustomerID, \n" +
                        "    c.CompanyName as customersCompasnyName, \n" +
                        "    c.Address, \n" +
                        "    c.City, \n" +
                        "    c.Region, \n" +
                        "    c.PostalCode, \n" +
                        "    c.Country, \n" +
                        "    concat(d.FirstName,  ' ', d.LastName) AS Salesperson, \n" +
                        "    b.OrderID, \n" +
                        "    b.OrderDate, \n" +
                        "    b.RequiredDate, \n" +
                        "    b.ShippedDate, \n" +
                        "    a.CompanyName as shipersCompanyName, \n" +
                        "    e.ProductID, \n" +
                        "    f.ProductName, \n" +
                        "    e.UnitPrice, \n" +
                        "    e.Quantity, \n" +
                        "    e.Discount,\n" +
                        "    e.UnitPrice * e.Quantity * (1 - e.Discount) AS ExtendedPrice,\n" +
                        "    b.Freight\n" +
                        "FROM Shippers a \n" +
                        "INNER JOIN Orders b ON a.ShipperID = b.ShipVia \n" +
                        "INNER JOIN Customers c ON c.CustomerID = b.CustomerID\n" +
                        "INNER JOIN Employees d ON d.EmployeeID = b.EmployeeID\n" +
                        "INNER JOIN Order_Details e ON b.OrderID = e.OrderID\n" +
                        "INNER JOIN Products f ON f.ProductID = e.ProductID\n" +
                        "ORDER BY b.ShipName", "JpaReportMaping");
        List<Report> result = query.getResultList();
        return result;
    }

}
