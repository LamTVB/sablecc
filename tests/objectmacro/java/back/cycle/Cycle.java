package back.cycle;

import back.cycle.macro.*;

public class Cycle {

    public static void main(String[] args){

        System.out.print("---------- Cyclic Reference ----------\n");

        Macros m = new Macros();

        MA ma = m.newA();
        MB mb = m.newB();
        MC mc = m.newC();

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
    }
}
