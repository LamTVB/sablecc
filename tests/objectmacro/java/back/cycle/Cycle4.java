package back.cycle;

import back.cycle.macro.*;

public class Cycle4 {

    public static void main(
            String[] args){

        Macros m = new Macros();

        MA ma = m.newA();
        MB mb = m.newB();
        MC mc = m.newC();
        MC mc1 = m.newC();
        MA ma1 = m.newA();
        MB mb1 = m.newB();
        MA ma2 = m.newA();

        ma.addX(mb);
        mb.addY(mc);
        mc.addY(ma1);
        mb.addY(mc);
        mb.addY(mc1);
        mc1.addY(ma2);
        mc1.addZ(mb1);
        mb1.addY(mc);
        ma.addX(mb1);
        MC mc2 = m.newC();
        mc2.addY(ma);

        try{
            mb1.addY(mc2);
            System.err.println("It should throw an exception here");
            System.exit(1);
        }
        catch(ObjectMacroException e){
            e.printStackTrace();
        }
    }

}
