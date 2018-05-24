package back.cycle;

import back.cycle.macro.*;

public class Cycle2 {

    public static void main(
            String[] args){

        Macros m = new Macros();

        MA ma = m.newA();
        MB mb = m.newB();
        MC mc = m.newC();
        MC mc1 = m.newC();
        MA ma1 = m.newA();
        MA ma2 = m.newA();

        ma.addX(mb);
        mb.addY(mc);
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
            System.out.println(e.getMessage());
        }
    }
}
