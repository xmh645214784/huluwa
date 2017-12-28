package Position;

import Settings.Settings;

import java.util.ArrayList;
import java.util.List;

public class TwoDimePositionSet {
    private static int NRX= Settings.getInstance().getNRX();
    private static int NRY=Settings.getInstance().getNRY();

    public static List<PositionInterface> getPositionInterfaces() {
        return positionInterfaces;
    }

    static List<PositionInterface> positionInterfaces=new ArrayList<PositionInterface>();

   static {
       for (int j = 0; j < Settings.getInstance().getNRY(); j++)
           for (int i = 0; i < Settings.getInstance().getNRX(); i++) {
               PositionInterface positionInterface=new TwoDimePosition(i,j,null);
               positionInterfaces.add(positionInterface);
           }
    }

    public static PositionInterface getPositionInterface(int x,int y){
            if(isOutOfBound(x,y))
                return null;
            return positionInterfaces.get(y*NRY+x);
    }

    public static boolean isOutOfBound(int x,int y) {
        if(x<0||x>=Settings.getInstance().getNRX()||y<0||y>=Settings.getInstance().getNRY())
            return true;
        else
            return false;
    }
}
