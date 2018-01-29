package pl.edu.agh.bazydanych2017;

import org.springframework.stereotype.Component;
import pl.edu.agh.bazydanych2017.dao.jdbc.repository.JdbcProductsDaoImpl;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcReportDao;
import pl.edu.agh.bazydanych2017.dao.jpa.repository.JpaProductsDaoImpl;
import pl.edu.agh.bazydanych2017.dao.jpa.repository.JpaReportDaoImpl;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaTransactionDao;

import java.util.Arrays;
@Component
public class TimeCounterImpl implements TimeCounter {

    private JpaProductsDaoImpl jpaProductsDaoImpl;
    private JdbcProductsDaoImpl jdbcProductsDaoImpl;
    private JpaReportDaoImpl jpaReportDaoImpl;
    private JdbcReportDao jdbcReportDao;
    private JpaTransactionDao jpaTransactionDao;

    public TimeCounterImpl(JpaProductsDaoImpl jpaProductsDaoImpl, JdbcProductsDaoImpl jdbcProductsDaoImpl, JpaReportDaoImpl jpaReportDaoImpl, JdbcReportDao jdbcReportDao, JpaTransactionDao jpaTransactionDao) {
        this.jpaProductsDaoImpl = jpaProductsDaoImpl;
        this.jdbcProductsDaoImpl = jdbcProductsDaoImpl;
        this.jpaReportDaoImpl = jpaReportDaoImpl;
        this.jdbcReportDao = jdbcReportDao;
        this.jpaTransactionDao = jpaTransactionDao;
    }

    //ListProductsSortedByProductName#############################################
    //test potwierdzający że zapytanią są identyczne - checkIfQueryFindAllSortedIsEqualsInJpaJdbc
    @Override
    public Double avarageTimeJPAListProductsSortedByProductName(int numberOfTest){
        long[] time = new long [numberOfTest];
        for(int i=0; i < numberOfTest; i++)
        {
            long StartTime = System.nanoTime();
                jpaProductsDaoImpl.timeListProductsSortedByProductName();
            long EndTime = System.nanoTime();
            long output = EndTime - StartTime;
            //todo: przerobić na logowanie
            time[i] = output;
           // System.out.println(time[i]);
        }
        Double avg = Arrays.stream(time).average().getAsDouble();
        return avg;
    }


     @Override
     public Double avarageTimeJDBCListProductsSortedByProductName(int numberOfTest) {
         long[] time = new long[numberOfTest];
         for (int i = 0; i < numberOfTest; i++) {
             long StartTime = System.nanoTime();
             jdbcProductsDaoImpl.timeListProductsSortedByProductName();
             long EndTime = System.nanoTime();
             long output = EndTime - StartTime;
             time[i] = output;
         }
         Double avg = Arrays.stream(time).average().getAsDouble();
         return avg;
     }
    //ListProductsSortedByProductName#############################################

    //FindProductByProductName####################################################
    //test potwierdzający że zapytanią są identyczne - checkIfQueryFindByProductnameIsEqualsInJpaJdbc
    @Override
    public Double avarageTimeJPAFindProductByProductName(int numberOfTest, String productname) {
        long[] time = new long[numberOfTest];
        for (int i = 0; i < numberOfTest; i++) {
            long StartTime = System.nanoTime();
            //todo: dlaczego pracuję na implementacji a nie interfejsie
            jpaProductsDaoImpl.timeFindProductByProductName(productname);
            long EndTime = System.nanoTime();
            long output = EndTime - StartTime;
            time[i] = output;
        }
        Double avg = Arrays.stream(time).average().getAsDouble();
        return avg;
    }

    @Override
    public Double avarageTimeJDBCFindProductByProductName(int numberOfTest, String productname) {
        long[] time = new long[numberOfTest];
        for (int i = 0; i < numberOfTest; i++) {
            long StartTime = System.nanoTime();
            jdbcProductsDaoImpl.timeFindProductByProductName(productname);
            long EndTime = System.nanoTime();
            long output = EndTime - StartTime;
            time[i] = output;
        }
        Double avg = Arrays.stream(time).average().getAsDouble();
        return avg;
    }
    //FindProductByProductName####################################################

    //DetailInformationForInvoicePurpose##########################################
    //test potwierdzający że zapytanią są identyczne - checkIfQueryReportIsEqualsInJpaJdbc przechodzi po normalnym uruchomieniu aplikacji
    @Override
    public Double avarageTimeJDBCReport(int numberOfTest) {
        long[] time = new long[numberOfTest];
        for (int i = 0; i < numberOfTest; i++) {
            long StartTime = System.nanoTime();
            jdbcReportDao.detailInformationForInvoicePurpose();
            long EndTime = System.nanoTime();
            long output = EndTime - StartTime;
            time[i] = output;
        }
        Double avg = Arrays.stream(time).average().getAsDouble();
        return avg;
    }

    @Override
    public Double avarageTimeJPAReport(int numberOfTest) {
        long[] time = new long[numberOfTest];
        for (int i = 0; i < numberOfTest; i++) {
            long StartTime = System.nanoTime();
            jpaReportDaoImpl.detailInformationForInvoicePurpose();
            long EndTime = System.nanoTime();
            long output = EndTime - StartTime;
            time[i] = output;
        }
        Double avg = Arrays.stream(time).average().getAsDouble();
        return avg;
    }
    //DetailInformationForInvoicePurpose##########################################

    //ChangeProductsUnitPriceForCategoryname######################################
    //todo: brak testu potwierdzającego że to działa tak samo w JDBC i JPA
    @Override
    public Double avarageTimeJDBCChangeProductsUnitPriceForCategoryname(int numberOfTest, String categoryname, Double addToUnitPrice) {
        long[] time = new long[numberOfTest];
        for (int i = 0; i < numberOfTest; i++) {
            long StartTime = System.nanoTime();
            jdbcProductsDaoImpl.timeChangeProductsUnitPriceForCategoryname(categoryname, addToUnitPrice);
            long EndTime = System.nanoTime();
            long output = EndTime - StartTime;
            time[i] = output;
        }
        Double avg = Arrays.stream(time).average().getAsDouble();
        return avg;
    }

    @Override
    public Double avarageTimeJPAChangeProductsUnitPriceForCategoryname(int numberOfTest, String categoryname, Double addToUnitPrice) {
        long[] time = new long[numberOfTest];
        for (int i = 0; i < numberOfTest; i++) {
            long StartTime = System.nanoTime();
            jpaProductsDaoImpl.timeChangeProductsUnitPriceForCategoryname(categoryname, addToUnitPrice);
            long EndTime = System.nanoTime();
            long output = EndTime - StartTime;
            time[i] = output;
        }
        Double avg = Arrays.stream(time).average().getAsDouble();
        return avg;
    }
    //ChangeProductsUnitPriceForCategoryname######################################

    //CreateNewProduct############################################################
    @Override
    public Double avarageTimeJPACreateNewProduct(int numberOfTest, String productname, String companyname, String categoryname, String quantityperunit, Double unitprice, Long unitsinstock, Long unitsonorder, Long reorderlevel, boolean discontinued) {
        long[] time = new long[numberOfTest];
        for (int i = 0; i < numberOfTest; i++) {
            long StartTime = System.nanoTime();
            jpaTransactionDao.timeCreateNewProduct( productname, companyname, categoryname, quantityperunit, unitprice, unitsinstock, unitsonorder, reorderlevel, discontinued);
            long EndTime = System.nanoTime();
            long output = EndTime - StartTime;
            time[i] = output;
        }
        Double avg = Arrays.stream(time).average().getAsDouble();
        return avg;
    }

    @Override
    public Double avarageTimeJDBCCreateNewProduct(int numberOfTest, String productname, String companyname, String categoryname, String quantityperunit, Double unitprice, Long unitsinstock, Long unitsonorder, Long reorderlevel, boolean discontinued) {
        long[] time = new long[numberOfTest];
        for (int i = 0; i < numberOfTest; i++) {
            long StartTime = System.nanoTime();
            jdbcProductsDaoImpl.timeCreateNewProduct( productname, companyname, categoryname, quantityperunit, unitprice, unitsinstock, unitsonorder, reorderlevel, discontinued);
            long EndTime = System.nanoTime();
            long output = EndTime - StartTime;
            time[i] = output;
        }
        Double avg = Arrays.stream(time).average().getAsDouble();
        return avg;
    }
    //createNewProduct############################################################

}
