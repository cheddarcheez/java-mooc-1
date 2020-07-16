
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grades grade= new Grades();
        UserInterface ui= new UserInterface(scanner,grade);
        ui.start();
        
    }
}
