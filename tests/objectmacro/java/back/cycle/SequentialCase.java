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
            writer = new BufferedWriter(new FileWriter("Result.txt", true));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(
            String[] args)throws IOException {

        String package_name = SequentialCase.class.getPackage().getName();
        String class_name = "LineCase";
        String content = GraphGenerator.sequentialCase(package_name, class_name, 10);
        int nbClasses = 0;

        compileAndRun(package_name, class_name, content, true);

        System.out.println("=========== SEQUENTIAL for 10 nodes ==============");
        writer.write("=========== SEQUENTIAL for 10 nodes ==============\n");

        long total_time = 0;

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 10);
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


        System.out.println("=========== SEQUENTIAL for 20 nodes ==============");
        writer.write("=========== SEQUENTIAL for 20 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 20);
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


        System.out.println("=========== SEQUENTIAL for 50 nodes ==============");
        writer.write("=========== SEQUENTIAL for 50 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 50);
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

        System.out.println("=========== SEQUENTIAL for 100 nodes ==============");
        writer.write("=========== SEQUENTIAL for 100 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 100);
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

        System.out.println("=========== SEQUENTIAL for 200 nodes ==============");
        writer.write("=========== SEQUENTIAL for 200 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 200);
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

        System.out.println("=========== SEQUENTIAL for 300 nodes ==============");
        writer.write("=========== SEQUENTIAL for 300 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 300);
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

        System.out.println("=========== SEQUENTIAL for 500 nodes ==============");
        writer.write("=========== SEQUENTIAL for 500 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 500);
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

        System.out.println("=========== SEQUENTIAL for 1000 nodes ==============");
        writer.write("=========== SEQUENTIAL for 1000 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 1000);
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

        System.out.println("=========== SEQUENTIAL for 2000 nodes ==============");
        writer.write("=========== SEQUENTIAL for 2000 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 2000);
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

        System.out.println("=========== SEQUENTIAL for 4000 nodes ==============");
        writer.write("=========== SEQUENTIAL for 4000 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 4000);
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

        System.out.println("=========== SEQUENTIAL for 6500 nodes ==============");
        writer.write("=========== SEQUENTIAL for 6500 nodes ==============\n");

        for(int i = nbClasses; i < nbClasses + 30; i++){
            content = GraphGenerator.sequentialCase(package_name, class_name + i, 6500);
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


