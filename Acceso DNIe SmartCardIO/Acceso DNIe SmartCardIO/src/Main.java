


import static java.awt.SystemColor.text;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import org.bouncycastle.util.encoders.Base64;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author toni
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    /**
     * Es el método encargado de proporcionarnos la función hash y con ello 
     * encriptar la información que mandamos, en nuestro caso encriptamos el usuario, el dni y la contraseña.
     * @param input
     * @return
     * @throws NoSuchAlgorithmException 
     */
  public static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }

     // public static String Base64(String a){
     //Base64.Encoder encoder = Base64.getEncoder();
       // String b = encoder.encodeToString(a.getBytes(StandardCharsets.UTF_8) );        
        //return b;
    //}
 
/**
 * Es el programa principal
 * @param args
 * @throws Exception 
 */
    public static void main(String[] args) throws Exception{
      

        //TODO: Obtener los datos del DNIe
       ObtenerDatos od = new ObtenerDatos();
       String nif = od.LeerNIF();
   
       String nif1[]= nif.split(" ");           //Cuando hay un espacio coge la variable y la mete en un vector
       String nombre=nif1[2].substring(0,1);    //Coge la primera letra del numbre
       String ap1=nif1[0];                      //cogemos el primer apellido entero
       String ap2=nif1[1].substring(0,1);       //Cogemos la primera letra del segundo apellido
             
       String nif2=nif1[3].substring(6);
       nif2=nif2.trim();                        //Quitamos los espacios en blanco entre el dni y la contraseña
       System.out.println("Introduce la clave:");
       Scanner in= new Scanner(System.in);
       String clave=in.nextLine();
       String completo=nombre+ap1+ap2+nif2+clave;//Concatenamos todas nuestras variables para obtenerla en una sola
      
       completo=completo.toLowerCase();          //Lo ponemos todo en minúscula
       
       
       
        String hash= sha1(completo);             //Hacemos el hash a completo, que e snuestra variable
                                                 //con todos los datos concatenados
       //String base64=base64(hash);
       
       
   
       System.out.println("NIF: "+completo);
       
       System.out.println("Hash:"+hash);
      //System.out.println("Base64:"+base64);
        //TODO: Autenticarse en el servidor
    
/**
 * Este código permite hacer la conexión 
 */
    try{
        URL url = new URL("https://localhost/dnie/dnie/autenticaMac.php?datos=248970829432fed5b31bb2bb78c3b6093f88c057");
      URLConnection con = url.openConnection();
 
      BufferedReader input = new BufferedReader(
         new InputStreamReader(con.getInputStream()));
 
      String linea;
      while ((linea = input.readLine()) != null) {
         System.out.println(linea);
    }
    }catch(Exception e){
        
    }
    }
    
    
}

