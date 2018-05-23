package back.cycle;

import back.cycle.macro.MF;
import back.cycle.macro.MH;
import back.cycle.macro.Macros;
import back.cycle.macro.ObjectMacroException;

public class Cycle5 {

    public static void main(String[] args){

        Macros m = new Macros();

        MF f = m.newF();
        MH h = m.newH();
        MH h2 = m.newH();
        MF f2 = m.newF();

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
