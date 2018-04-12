package graph_generator;

import back.cycle.macro.ObjectMacroException;
import graph_generator.macro.*;
import back.cycle.macro.MA;
import back.cycle.macro.MB;
import back.cycle.macro.MC;

import javax.tools.*;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.*;
import java.util.*;

public class GraphGenerator {

    public static long exponentialCase(
            String package_name,
            int nbDepth){

        String class_name = "ExponantialCase";
        MMain main = new MMain(class_name);

        if(package_name != null){
            main.addPackage(new MPackageDeclaration(package_name));
        }

        List<String> macro_names = new LinkedList<>();

        for(int i = 0; i < nbDepth / 3; i++){
            main.addMacroDeclarations(new MNewMacro(MA.class.getSimpleName(), "A" + i));
            macro_names.add("A" + i);
        }

        for(int i = 0; i < nbDepth / 3; i++){
            main.addMacroDeclarations(new MNewMacro(MB.class.getSimpleName(), "B" + i));
            macro_names.add("B" + i);
        }

        for(int i = 0; i < nbDepth / 3; i++){
            main.addMacroDeclarations(new MNewMacro(MC.class.getSimpleName(), "C" + i));
            macro_names.add("C" + i);
        }

        for(int i = 0; i < nbDepth / 3; i++) {
            MAddMacro addMacro;
            if(i + 1 < nbDepth / 3){
                addMacro = new MAddMacro("C" + i, "A" + (i + 1), "Y");
                main.addMacroLinks(addMacro);
            }

            addMacro = new MAddMacro("B" + i, "C" + i, "Y");
            main.addMacroLinks(addMacro);

            addMacro = new MAddMacro("A" + i, "B" + i, "X");
            main.addMacroLinks(addMacro);
        }

        main.addMacroLinks(new MAddMacro(macro_names.get(macro_names.size() - 1), macro_names.get(0), "Y"));
        main.addBuilders(new MBuilder(macro_names.get(0)));

//        System.out.println(main.build());
        JavaFileObject file = getJavaFileObject(package_name, class_name, main.build());
        Iterable<? extends JavaFileObject> files = Arrays.asList(file);

        if(compile(files)){
            return run(package_name, class_name);
        }

        return 0;
    }

    /** java File Object represents an in-memory java source file <br>
     * so there is no need to put the source file on hard disk  **/
    private static class InMemoryJavaFileObject extends SimpleJavaFileObject
    {
        private String contents = null;

        public InMemoryJavaFileObject(String className, String contents) throws Exception
        {
            super(URI.create("string:///" + className.replace('.', '/')
                    + Kind.SOURCE.extension), Kind.SOURCE);
            this.contents = contents;
        }

        public CharSequence getCharContent(boolean ignoreEncodingErrors)
                throws IOException
        {
            return contents;
        }
    }

    /** Get a simple Java File Object ,<br>
     * It is just for demo, content of the source code is dynamic in real use case */
    private static JavaFileObject getJavaFileObject(
            String package_name,
            String class_name,
            String content) {

        JavaFileObject so = null;
        try
        {
            so = new InMemoryJavaFileObject(package_name.concat(".").concat(class_name), content);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return so;
    }

    private static boolean compile(
            Iterable<? extends JavaFileObject> files){

        //get system compiler:
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        DiagnosticListener listener = new DiagnosticListener<JavaFileObject>() {

            @Override public void report(Diagnostic<? extends JavaFileObject> diagnostic) {
                System.out.println(diagnostic.getMessage(Locale.FRANCE));
//                System.out.println("Line Number->" + diagnostic.getLineNumber());
//                System.out.println("code->" + diagnostic.getCode());
//                System.out.println("Message->"
//                        + diagnostic.getMessage(Locale.ENGLISH));
//                System.out.println("Source->" + diagnostic.getSource());
//                System.out.println(" ");
            }
        };

        // for compilation diagnostic message processing on compilation WARNING/ERROR
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(listener
                , Locale.ENGLISH, null);
        //specify classes output folder
        Iterable options = Arrays.asList("-d", "classes/");
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager,
                listener, options, null,
                files);
        Boolean result = task.call();

        return result;
    }

    private static long run(
            String package_name,
            String class_name){

        // Create a File object on the root of the directory
        // containing the class file
        File file = new File("classes/");
        Class thisClass = null;

        try
        {
            // Convert File to a URL
            URL url = file.toURI().toURL(); // file:/classes/demo
            URL[] urls = new URL[] { url };

            // Create a new class loader with the directory
            ClassLoader loader = new URLClassLoader(urls);

            thisClass = loader.loadClass(package_name.concat(".").concat(class_name));

            Method method = thisClass.getMethod("main", String[].class);

            method.invoke(null, (Object) null);
        }
        catch(InvocationTargetException e){
            if(thisClass != null){
                try{
                    Field field = thisClass.getDeclaredField("exec_time");
                    return field.getLong(null);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        catch (MalformedURLException | ClassNotFoundException | NoSuchMethodException
                 | IllegalAccessException e)
        {
            e.printStackTrace();
        }

        return 0;
    }

}
