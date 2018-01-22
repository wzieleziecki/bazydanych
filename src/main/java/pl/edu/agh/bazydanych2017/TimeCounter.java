package pl.edu.agh.bazydanych2017;

import org.springframework.stereotype.Component;
import pl.edu.agh.bazydanych2017.dao.jpa.JpaProductsDaoImpl;

import java.util.Arrays;
@Component
public class TimeCounter {

    private JpaProductsDaoImpl jpaProductsDaoImpl;

    public TimeCounter(JpaProductsDaoImpl jpaProductsDaoImpl) {
        this.jpaProductsDaoImpl = jpaProductsDaoImpl;
    }

    public Double AvarageTimelistProductsSortedByProductName(int numberOfTest){
        long[] time = new long [numberOfTest];
        for(int i=0; i < numberOfTest; i++)
        {
            long StartTime = System.nanoTime();
                jpaProductsDaoImpl.TimelistProductsSortedByProductName();
            long EndTime = System.nanoTime();
            long output = EndTime - StartTime;
            time[i] = output;
            System.out.println(time[i]);
        }
        Double avg = Arrays.stream(time).average().getAsDouble();
        return avg;
    }

}
