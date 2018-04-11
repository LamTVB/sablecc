package back.cycle;

import graph_generator.GraphGenerator;

public class Performance {

    public static void main(
            String[] args){

        long total_time = 0;

        //Warm up
        for(int i = 0; i < 100; i++){
            GraphGenerator.exponentialCase(Performance.class.getPackage().getName(), 2000);
        }

        System.out.println("=========== EXPONENTIAL for 10 nodes ==============");

        for(int i = 0; i < 10; i++){
            long endTime = GraphGenerator.exponentialCase(Performance.class.getPackage().getName(), 10);
            System.out.println("End time taken : " + endTime);
            total_time += endTime;
        }

        System.out.println("Total time taken : " + total_time);
        System.out.println("Average total time taken : " + total_time / 10);

        System.out.println("=========== EXPONENTIAL for 20 nodes ==============");

        total_time = 0;

        for(int i = 0; i < 10; i++){
            long endTime = GraphGenerator.exponentialCase(Performance.class.getPackage().getName(), 20);
            System.out.println("End time taken : " + endTime);
            total_time += endTime;
        }

        System.out.println("Total time taken : " + total_time);
        System.out.println("Average total time taken : " + total_time / 10);

        System.out.println("=========== EXPONENTIAL for 50 nodes ==============");

        total_time = 0;

        for(int i = 0; i < 10; i++){
            long endTime = GraphGenerator.exponentialCase(Performance.class.getPackage().getName(), 50);
            System.out.println("End time taken : " + endTime);
            total_time += endTime;
        }

        System.out.println("Total time taken : " + total_time);
        System.out.println("Average total time taken : " + total_time / 10);

        System.out.println("=========== EXPONENTIAL for 100 nodes ==============");

        total_time = 0;

        for(int i = 0; i < 10; i++){
            long endTime = GraphGenerator.exponentialCase(Performance.class.getPackage().getName(), 100);
            System.out.println("End time taken : " + endTime);
            total_time += endTime;
        }

        System.out.println("Total time taken : " + total_time);
        System.out.println("Average total time taken : " + total_time / 10);

        System.out.println("=========== EXPONENTIAL for 200 nodes ==============");

        total_time = 0;

        for(int i = 0; i < 10; i++){
            long endTime = GraphGenerator.exponentialCase(Performance.class.getPackage().getName(), 200);
            System.out.println("End time taken : " + endTime);
            total_time += endTime;
        }

        System.out.println("Total time taken : " + total_time);
        System.out.println("Average total time taken : " + total_time / 10);

        System.out.println("=========== EXPONENTIAL for 300 nodes ==============");

        total_time = 0;

        for(int i = 0; i < 10; i++){
            long endTime = GraphGenerator.exponentialCase(Performance.class.getPackage().getName(), 300);
            System.out.println("End time taken : " + endTime);
            total_time += endTime;
        }

        System.out.println("Total time taken : " + total_time);
        System.out.println("Average total time taken : " + total_time / 10);

        System.out.println("=========== EXPONENTIAL for 500 nodes ==============");

        total_time = 0;

        for(int i = 0; i < 10; i++){
            long endTime = GraphGenerator.exponentialCase(Performance.class.getPackage().getName(), 500);
            System.out.println("End time taken : " + endTime);
            total_time += endTime;
        }

        System.out.println("Total time taken : " + total_time);
        System.out.println("Average total time taken : " + total_time / 10);

        System.out.println("=========== EXPONENTIAL for 1000 nodes ==============");

        total_time = 0;

        for(int i = 0; i < 10; i++){
            long endTime = GraphGenerator.exponentialCase(Performance.class.getPackage().getName(), 1000);
            System.out.println("End time taken : " + endTime);
            total_time += endTime;
        }

        System.out.println("Total time taken : " + total_time);
        System.out.println("Average total time taken : " + total_time / 10);

        System.out.println("=========== EXPONENTIAL for 2000 nodes ==============");

        total_time = 0;

        for(int i = 0; i < 10; i++){
            long endTime = GraphGenerator.exponentialCase(Performance.class.getPackage().getName(), 1000);
            System.out.println("End time taken : " + endTime);
            total_time += endTime;
        }

        System.out.println("Total time taken : " + total_time);
        System.out.println("Average total time taken : " + total_time / 10);
    }

}


