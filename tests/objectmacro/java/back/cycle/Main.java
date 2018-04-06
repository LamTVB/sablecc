package back.cycle;

import back.cycle.macro.*;

public class Main {

    public static void main(String[] args){

        System.out.print("---------- Cyclic Reference ----------\n");

        MA ma = new MA();
        MB mb = new MB();
        MC mc = new MC();
        MC mc1 = new MC();
        MA ma1 = new MA();
        MB mb1 = new MB();
        MA ma2 = new MA();

        ma.addX(mb);
        mb.addY(mc);

        try{
            mc.addY(ma);
            System.err.println("It should throw an exception here");
            System.exit(1);
        }
        catch(ObjectMacroException e){
            e.printStackTrace();
        }

        mc.addY(ma1);
        mb.addY(mc);
        mb.addY(mc1);
        mc1.addY(ma2);

        try{
            ma2.addX(mb);
            System.err.println("It should throw an exception here");
            System.exit(1);
        }
        catch(ObjectMacroException e){
            e.printStackTrace();
        }

        mc1.addZ(mb1);
        mb1.addY(mc);

        try{
            ma1.addX(mb1);
            System.err.println("It should throw an exception here");
            System.exit(1);
        }
        catch(ObjectMacroException e){
            e.printStackTrace();
        }

        ma.addX(mb1);
        MC mc2 = new MC();
        mc2.addY(ma);

        try{
            mb1.addY(mc2);
            System.err.println("It should throw an exception here");
            System.exit(1);
        }
        catch(ObjectMacroException e){
            e.printStackTrace();
        }

        MF f = new MF();
        MH h = new MH();
        MH h2 = new MH();
        MF f2 = new MF();

        f.addY(h);
        h.addLala(f2);
        f2.addY(h2);

        try{
            h2.addLala(f);
            System.err.println("It should throw an exception here");
            System.exit(1);
        }
        catch(ObjectMacroException e){
            e.printStackTrace();
        }
    }
}
