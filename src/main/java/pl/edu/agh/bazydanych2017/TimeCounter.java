package pl.edu.agh.bazydanych2017;

import org.springframework.stereotype.Component;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcProductsDao;
import pl.edu.agh.bazydanych2017.dao.jdbc.JdbcProductsDaoImpl;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaProductsDaoImpl;

import java.util.Arrays;
@Component
public class TimeCounter {

    private JpaProductsDaoImpl jpaProductsDaoImpl;
    private JdbcProductsDaoImpl jdbcProductsDaoImpl;

    public TimeCounter(JpaProductsDaoImpl jpaProductsDaoImpl, JdbcProductsDaoImpl jdbcProductsDaoImpl) {
        this.jpaProductsDaoImpl = jpaProductsDaoImpl;
        this.jdbcProductsDaoImpl = jdbcProductsDaoImpl;
    }


    public Double AvarageTimeJPAlistProductsSortedByProductName(int numberOfTest){
        long[] time = new long [numberOfTest];
        for(int i=0; i < numberOfTest; i++)
        {
            long StartTime = System.nanoTime();
                jpaProductsDaoImpl.TimelistProductsSortedByProductName();
            long EndTime = System.nanoTime();
            long output = EndTime - StartTime;
            //todo: przerobić na logowanie
            time[i] = output;
           // System.out.println(time[i]);
        }
        Double avg = Arrays.stream(time).average().getAsDouble();
        return avg;
    }
 //todo: testy listProductsSortedByProductName JDBC
    //todo:zła nazwa metody
     public Double AvarageTimeJDBClistProductsSortedByProductName(int numberOfTest) {
         long[] time = new long[numberOfTest];
         for (int i = 0; i < numberOfTest; i++) {
             long StartTime = System.nanoTime();
             jdbcProductsDaoImpl.TimelistProductsSortedByProductName();
             long EndTime = System.nanoTime();
             long output = EndTime - StartTime;
             time[i] = output;
             // System.out.println(time[i]);
         }
         Double avg = Arrays.stream(time).average().getAsDouble();
         return avg;
     }

    public Double AvarageTimeJPAFindProductByProductName(int numberOfTest, String productname) {
        long[] time = new long[numberOfTest];
        for (int i = 0; i < numberOfTest; i++) {
            long StartTime = System.nanoTime();
            jpaProductsDaoImpl.timeFindProductByProductName(productname);
            long EndTime = System.nanoTime();
            long output = EndTime - StartTime;
            time[i] = output;
            // System.out.println(time[i]);
        }
        Double avg = Arrays.stream(time).average().getAsDouble();
        return avg;
    }

    public Double AvarageTimeJDBCFindProductByProductName(int numberOfTest, String productname) {
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
}
