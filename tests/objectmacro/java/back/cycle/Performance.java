package back.cycle;

import graph_generator.GraphGenerator;

public class Performance {

    public static void main(String[] args){
        long start = System.nanoTime();
        GraphGenerator.exponantialCase(Performance.class.getPackage().getName(), 1000);
        long end = System.nanoTime();
        System.out.println("Total time taken : " + ((end - start)/ 1000000));


    }

}


