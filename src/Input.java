import java.util.InputMismatchException;
import java.util.Scanner;

public interface Input {
    Scanner s = new Scanner(System.in);

    static int inpNumber(){
        while(true){
            try{
                System.out.println("inserta Numero");
                return  s.nextInt();
            }catch (InputMismatchException iMME){
                System.out.println("debe insertar un valor numerico");
                s.next();
            }
        }
    }
}
