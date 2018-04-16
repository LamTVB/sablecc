package graph_generator;

import graph_generator.macro.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GraphGenerator {

    public static String sequentialCase(
            String package_name,
            String class_name,
            int nbNodes){

        MMain main = new MMain(class_name);

        if(package_name != null){
            main.addPackage(new MPackageDeclaration(package_name));
        }

        for(int i = 1; i <= nbNodes; i++){
            main.addMacroDeclarations(new MNewMacro("" + i));
            main.addInitMacros(new MInitMacro("" + i));
        }

        MLinkMethod mLinkMethod = new MLinkMethod("" + 0);
        main.addLinkMethods(mLinkMethod);
        main.addCallsLinkFunction(new MCallLinkFunction("" + 0));
        int nbAdd = 1;
        int nbMethod = 1;
        MAddMacro addMacro = new MAddMacro("" + (nbNodes - 1), "" + nbNodes);
        mLinkMethod.addMacroLinks(addMacro);

        for(int i = nbNodes - 1; i > 0; i--) {
            if(nbAdd >= 250){
                nbMethod++;
                mLinkMethod = new MLinkMethod("" + nbMethod);
                main.addLinkMethods(mLinkMethod);
                main.addCallsLinkFunction(new MCallLinkFunction("" + nbMethod));
                nbAdd = 0;
            }

            if(i - 1 > 0){
                addMacro = new MAddMacro("" + (i - 1), "" + i);
                mLinkMethod.addMacroLinks(addMacro);
                nbAdd++;
            }
        }

        mLinkMethod.addMacroLinks(new MAddMacro("" + nbNodes, "" + 1));
        return main.build();
    }

    public static String randomCase(
            String package_name,
            String class_name,
            int nbNodes){

        MMain main = new MMain(class_name);

        if(package_name != null){
            main.addPackage(new MPackageDeclaration(package_name));
        }

        for(int i = 1; i <= nbNodes; i++){
            main.addMacroDeclarations(new MNewMacro("" + i));
            main.addInitMacros(new MInitMacro("" + i));
        }

        MLinkMethod mLinkMethod = new MLinkMethod("" + 0);
        main.addLinkMethods(mLinkMethod);
        main.addCallsLinkFunction(new MCallLinkFunction("" + 0));
        int nbAdd = 0;
        int nbMethod = 1;
        MAddMacro addMacro;
        for(int i = 1; i <= nbNodes; i++) {
            if(nbAdd >= 250){
                nbMethod++;
                mLinkMethod = new MLinkMethod("" + nbMethod);
                main.addLinkMethods(mLinkMethod);
                main.addCallsLinkFunction(new MCallLinkFunction("" + nbMethod));
                nbAdd = 0;
            }

            int randomNum = ThreadLocalRandom.current().nextInt(1, nbNodes);

            if(i != randomNum){
                addMacro = new MAddMacro("" + i, "" + randomNum);
                mLinkMethod.addMacroLinks(addMacro);
                nbAdd++;
            }
        }

        return main.build();
    }
}
