package back.cycle;

import graph_generator.DynamicJavaExecutor;
import graph_generator.GraphGenerator;

import javax.tools.JavaFileObject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class PerformanceRandomCase {

    private static BufferedWriter writer;

    static {
        try {
            writer = new BufferedWriter(new FileWriter("Result.txt", true));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(
            String[] args)throws IOException {

        String package_name = PerformanceRandomCase.class.getPackage().getName();
        String class_name = "RandomCase";
        String content = GraphGenerator.randomCase(package_name, class_name, 10, true);
        int nbClasses = 0;

        compileAndRun(package_name, class_name, content, true);

        System.out.println("=========== RANDOM for 10 nodes ==============");
        writer.write("=========== RANDOM for 10 nodes ==============\n");

        long total_time = 0;
        System.out.println(GraphGenerator.randomCase(package_name, class_name + nbClasses, 10, true));
        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.randomCase(package_name, class_name + i, 10, false);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        try {
            writer.write("Total time taken : " + total_time + " ns\n");
            writer.write("Average total time taken : " + total_time / 30 + " ns\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total time taken : " + total_time + "ns");
        System.out.println("Average total time taken : " + total_time / 30 + "ns");


        System.out.println("=========== RANDOM for 20 nodes ==============");
        writer.write("=========== RANDOM for 20 nodes ==============\n");
        GraphGenerator.randomCase(package_name, class_name + nbClasses, 20, true);
        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.randomCase(package_name, class_name + i, 20, false);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        try {
            writer.write("Total time taken : " + total_time + " ns\n");
            writer.write("Average total time taken : " + total_time / 30 + " ns\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("=========== RANDOM for 50 nodes ==============");
        writer.write("=========== RANDOM for 50 nodes ==============\n");

        GraphGenerator.randomCase(package_name, class_name + nbClasses, 50, true);
        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.randomCase(package_name, class_name + i, 50, false);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        try {
            writer.write("Total time taken : " + total_time + " ns\n");
            writer.write("Average total time taken : " + total_time / 30 + " ns\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("=========== RANDOM for 100 nodes ==============");
        writer.write("=========== RANDOM for 100 nodes ==============\n");

        GraphGenerator.randomCase(package_name, class_name + nbClasses, 100, true);
        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.randomCase(package_name, class_name + i, 100, false);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        try {
            writer.write("Total time taken : " + total_time + " ns\n");
            writer.write("Average total time taken : " + total_time / 30 + " ns\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("=========== RANDOM for 200 nodes ==============");
        writer.write("=========== RANDOM for 200 nodes ==============\n");

        GraphGenerator.randomCase(package_name, class_name + nbClasses, 200, true);
        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.randomCase(package_name, class_name + i, 200, false);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        try {
            writer.write("Total time taken : " + total_time + " ns\n");
            writer.write("Average total time taken : " + total_time / 30 + " ns\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("=========== RANDOM for 300 nodes ==============");
        writer.write("=========== RANDOM for 300 nodes ==============\n");

        GraphGenerator.randomCase(package_name, class_name + nbClasses, 300, true);
        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.randomCase(package_name, class_name + i, 300, false);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        try {
            writer.write("Total time taken : " + total_time + " ns\n");
            writer.write("Average total time taken : " + total_time / 30 + " ns\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("=========== RANDOM for 500 nodes ==============");
        writer.write("=========== RANDOM for 500 nodes ==============\n");

        GraphGenerator.randomCase(package_name, class_name + nbClasses, 500, true);
        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.randomCase(package_name, class_name + i, 500, false);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        try {
            writer.write("Total time taken : " + total_time + " ns\n");
            writer.write("Average total time taken : " + total_time / 30 + " ns\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("=========== RANDOM for 1000 nodes ==============");
        writer.write("=========== RANDOM for 1000 nodes ==============\n");

        GraphGenerator.randomCase(package_name, class_name + nbClasses, 1000, true);
        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.randomCase(package_name, class_name + i, 1000, false);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        try {
            writer.write("Total time taken : " + total_time + " ns\n");
            writer.write("Average total time taken : " + total_time / 30 + " ns\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("=========== RANDOM for 2000 nodes ==============");
        writer.write("=========== RANDOM for 2000 nodes ==============\n");

        GraphGenerator.randomCase(package_name, class_name + nbClasses, 2000, true);
        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.randomCase(package_name, class_name + i, 2000, false);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        try {
            writer.write("Total time taken : " + total_time + " ns\n");
            writer.write("Average total time taken : " + total_time / 30 + " ns\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("=========== RANDOM for 4000 nodes ==============");
        writer.write("=========== RANDOM for 4000 nodes ==============\n");

        GraphGenerator.randomCase(package_name, class_name + nbClasses, 4000, true);
        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.randomCase(package_name, class_name + i, 4000, false);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }
        nbClasses += 30;

        try {
            writer.write("Total time taken : " + total_time + " ns\n");
            writer.write("Average total time taken : " + total_time / 30 + " ns\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("=========== RANDOM for 6500 nodes ==============");
        writer.write("=========== RANDOM for 6500 nodes ==============\n");

        GraphGenerator.randomCase(package_name, class_name + nbClasses, 6500, true);
        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.randomCase(package_name, class_name + i, 6500, false);
            total_time += compileAndRun(package_name, class_name + i, content, false);
        }

        try {
            writer.write("Total time taken : " + total_time + " ns\n");
            writer.write("Average total time taken : " + total_time / 30 + " ns\n\n\n\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
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
