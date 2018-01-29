package pl.edu.agh.bazydanych2017.dao.jdbc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcReportDao;
import pl.edu.agh.bazydanych2017.model.Report;

import java.util.List;

@Repository
public class JdbcReportVO implements JdbcReportDao
{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcReportVO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final RowMapper<Report> jdbcReportRowMapper  = (rs, rowNum) -> {
        Report report = new Report();
        report.setShipName(rs.getString("ShipName"));
        report.setShipAddress(rs.getString("ShipAddress"));
        report.setShipCity(rs.getString("ShipCity"));
        report.setShipRegion(rs.getString("ShipRegion"));
        report.setShipPostalCode(rs.getString("ShipPostalCode"));
        report.setShipCountry(rs.getString("ShipCountry"));
        report.setCustomerID(rs.getString("CustomerID"));
        report.setCustomersCompasnyName(rs.getString("customersCompasnyName"));
        report.setAddress(rs.getString("Address"));
        report.setCity(rs.getString("City"));
        report.setRegion(rs.getString("Region"));
        report.setPostalCode(rs.getString("PostalCode"));
        report.setCountry(rs.getString("Country"));
        report.setSalesperson(rs.getString("Salesperson"));
        report.setOrderID(rs.getString("OrderID"));
        report.setOrderDate(rs.getString("OrderDate"));
        report.setRequiredDate(rs.getString("RequiredDate"));
        report.setShippedDate(rs.getString("ShippedDate"));
        report.setShipersCompanyName(rs.getString("shipersCompanyName"));
        report.setProductID(rs.getString("ProductID"));
        report.setProductName(rs.getString("ProductName"));
        report.setUnitPrice(rs.getString("UnitPrice"));
        report.setQuantity(rs.getString("Quantity"));
        report.setDiscount(rs.getString("Discount"));
        report.setExtendedPrice(rs.getString("ExtendedPrice"));
        report.setFreight(rs.getString("Freight"));
        return report;
        };

    @Override
    public List<Report> detailInformationForInvoicePurpose() {
        String sql = "SELECT DISTINCT b.ShipName, \n" +
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
                "ORDER BY b.ShipName";
        return jdbcTemplate.query(sql, jdbcReportRowMapper);
    }
}

