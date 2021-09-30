import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Prooceso {

    private static String mensaje = ""; 
    private static String letras = "";
    private static String fin = "fin";
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
    
            while(!letras.equals(fin) ){
                System.out.println("Introduce una palabra");
                letras = teclado.nextLine();
        
            for(int i = 0; i < letras.length(); i++){
                pb();
                
            }
            System.out.println(mensaje);
        }
        
    }

    public static void pb(){

        ProcessBuilder aleatorio = new ProcessBuilder();

       aleatorio.command("powershell.exe", "/c",  "java .\\aleatorio\\src\\Aleatorio.java");
      
        try {
            
            //Ejecutamos el proceso con .start()
            Process process = aleatorio.start();
            
            // blocked :(
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream(), "CP437"));
    
            String line ;
            
            while ((line = reader.readLine()) != null) {
                
                mensaje = mensaje +line;
               
            }
        
            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);

    
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
