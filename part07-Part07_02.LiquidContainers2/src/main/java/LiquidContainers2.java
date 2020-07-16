
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {

        Container con1= new Container();
        Container con2= new Container();

        UserInterface ui= new UserInterface(con1,con2);
        ui.start();
    }

}
