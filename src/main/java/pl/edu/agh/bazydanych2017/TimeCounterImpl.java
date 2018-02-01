package pl.edu.agh.bazydanych2017;

import org.springframework.stereotype.Component;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcProductsDao;
import pl.edu.agh.bazydanych2017.dao.jdbc.repository.JdbcProductsDaoImpl;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcReportView;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaProductsDao;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaReportView;
import pl.edu.agh.bazydanych2017.dao.jpa.repository.JpaProductsDaoImpl;
import pl.edu.agh.bazydanych2017.dao.jpa.repository.JpaReportViewImpl;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaTransactionDao;

import java.util.Arrays;
@Component
public class TimeCounterImpl implements TimeCounter {

    private JpaProductsDao jpaProductsDao;
    private JdbcProductsDao jdbcProductsDao;
    private JpaReportView jpaReportView;
    private JdbcReportView jdbcReportView;
    private JpaTransactionDao jpaTransactionDao;

    public TimeCounterImpl(JpaProductsDaoImpl jpaProductsDao, JdbcProductsDaoImpl jdbcProductsDao, JpaReportViewImpl jpaReportDao, JdbcReportView jdbcReportView, JpaTransactionDao jpaTransactionDao) {
        this.jpaProductsDao = jpaProductsDao;
        this.jdbcProductsDao = jdbcProductsDao;
        this.jpaReportView = jpaReportDao;
        this.jdbcReportView = jdbcReportView;
        this.jpaTransactionDao = jpaTransactionDao;
    }

    @Override
    public Double avarageTimeJPAListProductsSortedByProductName(int numberOfTest){
        long[] time = new long [numberOfTest];
        for(int i=0; i < numberOfTest; i++)
        {
            long StartTime = System.nanoTime();
                jpaProductsDao.listProductsSortedByProductName();
            long EndTime = System.nanoTime();
            long output = EndTime - StartTime;
            time[i] = output;
        }
        return Arrays.stream(time).average().getAsDouble();
    }


     @Override
     public Double avarageTimeJDBCListProductsSortedByProductName(int numberOfTest) {
         long[] time = new long[numberOfTest];
         for (int i = 0; i < numberOfTest; i++) {
             long StartTime = System.nanoTime();
             jdbcProductsDao.listProductsSortedByProductName();
             long EndTime = System.nanoTime();
             long output = EndTime - StartTime;
             time[i] = output;
         }
         return Arrays.stream(time).average().getAsDouble();
     }

    @Override
    public Double avarageTimeJPAFindProductByProductName(int numberOfTest, String productname) {
        long[] time = new long[numberOfTest];
        for (int i = 0; i < numberOfTest; i++) {
            long StartTime = System.nanoTime();
            jpaProductsDao.findProductByProductName(productname);
            long EndTime = System.nanoTime();
            long output = EndTime - StartTime;
            time[i] = output;
        }
        return Arrays.stream(time).average().getAsDouble();
    }

    @Override
    public Double avarageTimeJDBCFindProductByProductName(int numberOfTest, String productname) {
        long[] time = new long[numberOfTest];
        for (int i = 0; i < numberOfTest; i++) {
            long StartTime = System.nanoTime();
            jdbcProductsDao.findProductByProductName(productname);
            long EndTime = System.nanoTime();
            long output = EndTime - StartTime;
            time[i] = output;
        }
        return Arrays.stream(time).average().getAsDouble();
    }

    @Override
    public Double avarageTimeJDBCReport(int numberOfTest) {
        long[] time = new long[numberOfTest];
        for (int i = 0; i < numberOfTest; i++) {
            long StartTime = System.nanoTime();
            jdbcReportView.detailInformationForInvoice();
            long EndTime = System.nanoTime();
            long output = EndTime - StartTime;
            time[i] = output;
        }
        return Arrays.stream(time).average().getAsDouble();
    }

    @Override
    public Double avarageTimeJPAReport(int numberOfTest) {
        long[] time = new long[numberOfTest];
        for (int i = 0; i < numberOfTest; i++) {
            long StartTime = System.nanoTime();
            jpaReportView.detailInformationForInvoice();
            long EndTime = System.nanoTime();
            long output = EndTime - StartTime;
            time[i] = output;
        }
        return Arrays.stream(time).average().getAsDouble();
    }

    @Override
    public Double avarageTimeJDBCChangeProductsUnitPriceForCategoryname(int numberOfTest, String categoryname, Double addToUnitPrice) {
        long[] time = new long[numberOfTest];
        for (int i = 0; i < numberOfTest; i++) {
            long StartTime = System.nanoTime();
            jdbcProductsDao.changeProductsUnitPriceForCategoryname(categoryname, addToUnitPrice);
            long EndTime = System.nanoTime();
            long output = EndTime - StartTime;
            time[i] = output;
        }
        return Arrays.stream(time).average().getAsDouble();
    }

    @Override
    public Double avarageTimeJPAChangeProductsUnitPriceForCategoryname(int numberOfTest, String categoryname, Double addToUnitPrice) {
        long[] time = new long[numberOfTest];
        for (int i = 0; i < numberOfTest; i++) {
            long StartTime = System.nanoTime();
            jpaProductsDao.changeProductsUnitPriceForCategoryname(categoryname, addToUnitPrice);
            long EndTime = System.nanoTime();
            long output = EndTime - StartTime;
            time[i] = output;
        }
        return Arrays.stream(time).average().getAsDouble();
    }

    @Override
    public Double avarageTimeJPACreateNewProduct(int numberOfTest, String productname, String companyname, String categoryname, String quantityperunit, Double unitprice, Long unitsinstock, Long unitsonorder, Long reorderlevel, boolean discontinued) {
        long[] time = new long[numberOfTest];
        for (int i = 0; i < numberOfTest; i++) {
            long StartTime = System.nanoTime();
            jpaTransactionDao.createNewProduct( productname, companyname, categoryname, quantityperunit, unitprice, unitsinstock, unitsonorder, reorderlevel, discontinued);
            long EndTime = System.nanoTime();
            long output = EndTime - StartTime;
            time[i] = output;
        }
        return Arrays.stream(time).average().getAsDouble();
    }

    @Override
    public Double avarageTimeJDBCCreateNewProduct(int numberOfTest, String productname, String companyname, String categoryname, String quantityperunit, Double unitprice, Long unitsinstock, Long unitsonorder, Long reorderlevel, boolean discontinued) {
        long[] time = new long[numberOfTest];
        for (int i = 0; i < numberOfTest; i++) {
            long StartTime = System.nanoTime();
            jdbcProductsDao.createNewProduct( productname, companyname, categoryname, quantityperunit, unitprice, unitsinstock, unitsonorder, reorderlevel, discontinued);
            long EndTime = System.nanoTime();
            long output = EndTime - StartTime;
            time[i] = output;
        }
        return Arrays.stream(time).average().getAsDouble();
    }

}
