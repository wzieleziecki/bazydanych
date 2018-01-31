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

    //todo: uporządkować interfejsy
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

    //ListProductsSortedByProductName#############################################
    //test potwierdzający że zapytanią są identyczne - checkIfQueryFindAllSortedIsEqualsInJpaJdbc
    @Override
    public Double avarageTimeJPAListProductsSortedByProductName(int numberOfTest){
        long[] time = new long [numberOfTest];
        for(int i=0; i < numberOfTest; i++)
        {
            long StartTime = System.nanoTime();
                jpaProductsDao.listProductsSortedByProductName();
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
             jdbcProductsDao.listProductsSortedByProductName();
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
            jpaProductsDao.timeFindProductByProductName(productname);
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
            jdbcProductsDao.timeFindProductByProductName(productname);
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
            jdbcReportView.detailInformationForInvoice();
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
            jpaReportView.detailInformationForInvoice();
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
            jdbcProductsDao.timeChangeProductsUnitPriceForCategoryname(categoryname, addToUnitPrice);
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
            jpaProductsDao.timeChangeProductsUnitPriceForCategoryname(categoryname, addToUnitPrice);
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
            jdbcProductsDao.timeCreateNewProduct( productname, companyname, categoryname, quantityperunit, unitprice, unitsinstock, unitsonorder, reorderlevel, discontinued);
            long EndTime = System.nanoTime();
            long output = EndTime - StartTime;
            time[i] = output;
        }
        Double avg = Arrays.stream(time).average().getAsDouble();
        return avg;
    }
    //createNewProduct############################################################

}
