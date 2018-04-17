package back.cycle;

import graph_generator.DynamicJavaExecutor;
import graph_generator.GraphGenerator;

import javax.tools.JavaFileObject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class SequentialCase {

    private static BufferedWriter writer;

    static {
        try {
            writer = new BufferedWriter(new FileWriter("ResultSequentialDelta.txt", true));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(
            String[] args)throws IOException {

        String package_name = SequentialCase.class.getPackage().getName();
        String class_name = "LineCase";
        String content = GraphGenerator.sequentialCase(package_name, class_name, 100);
        int nbClasses = 0;

        compileAndRun(package_name, class_name, content, true);

        long total_time = 0;

        System.out.println("=========== SEQUENTIAL for 250 nodes ==============");
        writer.write("=========== SEQUENTIAL for 250 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 250);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        writer.write( total_time / 30 + "\n");
        System.out.println("Total time taken : " + total_time + " ns\n");
        System.out.println("Average total time taken : " + total_time / 30 + " ns\n");

        total_time = 0;

        System.out.println("=========== SEQUENTIAL for 500 nodes ==============");
        writer.write("=========== SEQUENTIAL for 500 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 500);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        writer.write( total_time / 30 + "\n");
        System.out.println("Total time taken : " + total_time + " ns\n");
        System.out.println("Average total time taken : " + total_time / 30 + " ns\n");

        total_time = 0;

        System.out.println("=========== SEQUENTIAL for 750 nodes ==============");
        writer.write("=========== SEQUENTIAL for 750 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 750);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        writer.write( total_time / 30 + "\n");
        System.out.println("Total time taken : " + total_time + " ns\n");
        System.out.println("Average total time taken : " + total_time / 30 + " ns\n");

        total_time = 0;

        System.out.println("=========== SEQUENTIAL for 1000 nodes ==============");
        writer.write("=========== SEQUENTIAL for 1000 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 1000);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        writer.write( total_time / 30 + "\n");
        System.out.println("Total time taken : " + total_time + " ns\n");
        System.out.println("Average total time taken : " + total_time / 30 + " ns\n");

        total_time = 0;

        System.out.println("=========== SEQUENTIAL for 1250 nodes ==============");
        writer.write("=========== SEQUENTIAL for 1250 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 1250);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        writer.write( total_time / 30 + "\n");
        System.out.println("Total time taken : " + total_time + " ns\n");
        System.out.println("Average total time taken : " + total_time / 30 + " ns\n");

        total_time = 0;

        System.out.println("=========== SEQUENTIAL for 1500 nodes ==============");
        writer.write("=========== SEQUENTIAL for 1500 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 1500);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        writer.write( total_time / 30 + "\n");
        System.out.println("Total time taken : " + total_time + " ns\n");
        System.out.println("Average total time taken : " + total_time / 30 + " ns\n");

        total_time = 0;

        System.out.println("=========== SEQUENTIAL for 1750 nodes ==============");
        writer.write("=========== SEQUENTIAL for 1750 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 1750);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        writer.write( total_time / 30 + "\n");
        System.out.println("Total time taken : " + total_time + " ns\n");
        System.out.println("Average total time taken : " + total_time / 30 + " ns\n");

        total_time = 0;

        System.out.println("=========== SEQUENTIAL for 2000 nodes ==============");
        writer.write("=========== SEQUENTIAL for 2000 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 2000);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        writer.write( total_time / 30 + "\n");
        System.out.println("Total time taken : " + total_time + " ns\n");
        System.out.println("Average total time taken : " + total_time / 30 + " ns\n");

        total_time = 0;

        System.out.println("=========== SEQUENTIAL for 2250 nodes ==============");
        writer.write("=========== SEQUENTIAL for 2250 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 2250);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        writer.write( total_time / 30 + "\n");
        System.out.println("Total time taken : " + total_time + " ns\n");
        System.out.println("Average total time taken : " + total_time / 30 + " ns\n");

        total_time = 0;

        System.out.println("=========== SEQUENTIAL for 2500 nodes ==============");
        writer.write("=========== SEQUENTIAL for 2500 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 2500);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        writer.write( total_time / 30 + "\n");
        System.out.println("Total time taken : " + total_time + " ns\n");
        System.out.println("Average total time taken : " + total_time / 30 + " ns\n");

        total_time = 0;

        System.out.println("=========== SEQUENTIAL for 2750 nodes ==============");
        writer.write("=========== SEQUENTIAL for 2750 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 2750);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        writer.write( total_time / 30 + "\n");
        System.out.println("Total time taken : " + total_time + " ns\n");
        System.out.println("Average total time taken : " + total_time / 30 + " ns\n");

        total_time = 0;

        System.out.println("=========== SEQUENTIAL for 3000 nodes ==============");
        writer.write("=========== SEQUENTIAL for 3000 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 3000);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        writer.write( total_time / 30 + "\n");
        System.out.println("Total time taken : " + total_time + " ns\n");
        System.out.println("Average total time taken : " + total_time / 30 + " ns\n");

        total_time = 0;

        System.out.println("=========== SEQUENTIAL for 3250 nodes ==============");
        writer.write("=========== SEQUENTIAL for 3250 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 3250);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        writer.write( total_time / 30 + "\n");
        System.out.println("Total time taken : " + total_time + " ns\n");
        System.out.println("Average total time taken : " + total_time / 30 + " ns\n");

        total_time = 0;

        System.out.println("=========== SEQUENTIAL for 3500 nodes ==============");
        writer.write("=========== SEQUENTIAL for 3500 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 3500);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        writer.write( total_time / 30 + "\n");
        System.out.println("Total time taken : " + total_time + " ns\n");
        System.out.println("Average total time taken : " + total_time / 30 + " ns\n");

        total_time = 0;

        System.out.println("=========== SEQUENTIAL for 3750 nodes ==============");
        writer.write("=========== SEQUENTIAL for 3750 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 3750);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        writer.write( total_time / 30 + "\n");
        System.out.println("Total time taken : " + total_time + " ns\n");
        System.out.println("Average total time taken : " + total_time / 30 + " ns\n");

        total_time = 0;

        System.out.println("=========== SEQUENTIAL for 4000 nodes ==============");
        writer.write("=========== SEQUENTIAL for 4000 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 4000);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        writer.write( total_time / 30 + "\n");
        System.out.println("Total time taken : " + total_time + " ns\n");
        System.out.println("Average total time taken : " + total_time / 30 + " ns\n");

        total_time = 0;

        System.out.println("=========== SEQUENTIAL for 4250 nodes ==============");
        writer.write("=========== SEQUENTIAL for 4250 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 4250);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        writer.write( total_time / 30 + "\n");
        System.out.println("Total time taken : " + total_time + " ns\n");
        System.out.println("Average total time taken : " + total_time / 30 + " ns\n");

        total_time = 0;

        System.out.println("=========== SEQUENTIAL for 4500 nodes ==============");
        writer.write("=========== SEQUENTIAL for 4500 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 4500);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        writer.write( total_time / 30 + "\n");
        System.out.println("Total time taken : " + total_time + " ns\n");
        System.out.println("Average total time taken : " + total_time / 30 + " ns\n");

        total_time = 0;

        System.out.println("=========== SEQUENTIAL for 4750 nodes ==============");
        writer.write("=========== SEQUENTIAL for 4750 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 4750);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        writer.write( total_time / 30 + "\n");
        System.out.println("Total time taken : " + total_time + " ns");
        System.out.println("Average total time taken : " + total_time / 30 + " ns");

        total_time = 0;

        System.out.println("=========== SEQUENTIAL for 5000 nodes ==============");
        writer.write("=========== SEQUENTIAL for 5000 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 5000);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        writer.write( total_time / 30 + "\n");
        System.out.println("Total time taken : " + total_time + " ns\n");
        System.out.println("Average total time taken : " + total_time / 30 + " ns\n");

        writer.close();

        System.out.println();
        System.out.println();
    }

    private static long compileAndRun(
            String package_name,
            String class_name,
            String mainContent,
            boolean warm_up){

        JavaFileObject mainFile = DynamicJavaExecutor.getJavaFileObject(package_name, class_name, mainContent);
        Iterable<? extends JavaFileObject> files = Arrays.asList(mainFile);

        if (warm_up) {
            if(DynamicJavaExecutor.compile(files)){
                for(int i = 0; i < 100; i++){
                    DynamicJavaExecutor.run(package_name, class_name);
                }
            }
        }
        else{
            if(DynamicJavaExecutor.compile(files)){
                return DynamicJavaExecutor.run(package_name, class_name);
            }
        }

        return 0;
    }
}


