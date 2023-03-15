import java.util.Scanner;

public class Main {
    public static int count = 0;

    static Scanner sc = new Scanner(System.in);

    static int c;

    public synchronized static void inconut(){

        /*No se pueden usar dos threads de forma sincrónica en este método*/

        count ++;

    }

    public static void main (String a[]){
        System.out.println("Ingrese el número de tickets");

        c = sc.nextInt();

        if (c>2000){
            System.out.println("Está ingresando más rickets de los permitidos");
            System.exit(0);
        } Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i>1000; i++){incount();
            }
        }});
        Thread t2 = new Thread((new Runnable() {
            @Override
            public void run() {
                for (int i=1; i<1000; i++){
                    inconut();
                }
            }
        }));

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Sus tickets son: "+count);

        System.out.println("Tickets permitidos: "+(count-c));
    }

    private static void incount() {
    }
}
