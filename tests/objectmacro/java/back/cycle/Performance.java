package back.cycle;

import graph_generator.GraphGenerator;

import java.lang.reflect.InvocationTargetException;


public class Performance {

    public static long endTime;

    public static void main(String[] args){
        long max_long = 0;

        for(int i = 0; i < 100; i++){
            GraphGenerator.exponantialCase(Performance.class.getPackage().getName(), 2000);
        }

        for(int i = 0; i < 10; i++){
            long endTime = GraphGenerator.exponantialCase(Performance.class.getPackage().getName(), 3000);
            System.out.println("End time taken : " + endTime);
            max_long += endTime;
        }

        System.out.println("Total time taken : " + max_long);
        System.out.println("Average total time taken : " + max_long / 10);
    }

}


