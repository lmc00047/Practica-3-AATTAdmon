

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

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
    public static void main(String[] args) throws Exception{
        ByteArrayInputStream bais=null;
       //read("cert.cer");
       
       FileInputStream fis = new FileInputStream("cert.cer");
      
       
       byte value[] = new byte[fis.available()];
         fis.read(value);
        bais = new ByteArrayInputStream(value);

        //TODO: Obtener los datos del DNIe
        ObtenerDatos od = new ObtenerDatos();
        String nif = od.LeerNIF();//tiene que devolver nif y usuario
        System.out.println("NIF: "+nif);
        //TODO: Autenticarse en el servidor
        // creamos clase adicional con una o dos funciones miembros que se encarguen de realizar la solicitud al servidor, tiene que llevar la url donde este el php y los parametros de nombre de usuario nif y contraseña
    //enviarDatosGet  enviarDatosPost    enviarDatosMac   1.enviar datos 2.clase httpURLconnection 3.enviar solicitud con un outPrintf    4. conecction   5.leer la respuesta si es correcta o no getresponse(formatear respuesta)
	//6.cerrar conexion
    }

}
