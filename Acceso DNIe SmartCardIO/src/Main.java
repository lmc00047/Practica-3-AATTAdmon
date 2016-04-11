


import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
//import java.io.UnsupportedEncodingException;
//import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.bouncycastle.util.encoders.Base64;

//import java.util.logging.Formatter;
//import java.util.logging.LogRecord;



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
    
  public static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }

public static String cifrarBase64(String a){
        Base64.Encoder encoder = Base64.getEncoder();
        String b = encoder.encodeToString(a.getBytes(StandardCharsets.UTF_8) );        
        return b;
    }
    public static void main(String[] args) throws Exception{
        //ByteArrayInputStream bais=null;
       //read("cert.cer");
       
       //FileInputStream fis = new FileInputStream("cert.cer");
      
       
      // byte value[] = new byte[fis.available()];
         //fis.read(value);
        //bais = new ByteArrayInputStream(value);

        //TODO: Obtener los datos del DNIe
        ObtenerDatos od = new ObtenerDatos();
       // String nif = od.LeerNIF();
       String nif="Moreno Chicharro, Laura 26248707A" ;
       String nif1[]= nif.split(" ");//Cuando hay un espacio coge la variable y la mete en un vector
       String nombre=nif1[2].substring(0,1);
       String ap1=nif1[0];//cogemos el apellido entero
       String ap2=nif1[1].substring(0,1);
       String letraDni=nif1[3].substring(8);
       String completo=nombre+ap1+ap2+letraDni;
       completo=completo.toLowerCase();
       
       String hash= sha1(completo);
       Strinf base64=base64(hash);
       
       
       
       System.out.println("NIF: "+completo);
        System.out.println("Hash:"+hash);
       System.out.println("Base64:"+base64);
        //TODO: Autenticarse en el servidor
        
    
    }

}
