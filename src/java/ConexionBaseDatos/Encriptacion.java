/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBaseDatos;

/**
 *
 * @author MARCS
 */
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


 public class Encriptacion {

    private SecretKey Clave;
    private Cipher cifrar;
    private Cipher descifrar;
    private String patroncifrado = "MD5";
    private String clavesecreta = "lmihacle#$%/°óú";

    public String Encriptar(String Encriptable) {
 
        String EncriptadoFinal = "";
 
        try {
 
            MessageDigest md = MessageDigest.getInstance(patroncifrado);
            byte[] valorContraseña = md.digest(clavesecreta.getBytes("utf-8"));
            byte[] BytesDeContraseña = Arrays.copyOf(valorContraseña, 24);
            Clave = new SecretKeySpec(BytesDeContraseña, "DESede");
            cifrar  = cifrar.getInstance("DESede");
            cifrar.init(Cipher.ENCRYPT_MODE, Clave);
 
            byte[] BytesDeTexto = Encriptable.getBytes("utf-8");
            byte[] buf = cifrar.doFinal(BytesDeTexto);
            String base64Bytes = new BASE64Encoder().encode(buf);
            EncriptadoFinal = new String(base64Bytes);
 
        } catch (Exception ex) {
              System.err.println(ex.getMessage());
        }
        return EncriptadoFinal;
    }
     public String Desencriptar(String textoEncriptado) throws Exception {
       
        String DesencriptadoFinal = "";
 
        try {
            byte[] valoresdecript = new BASE64Decoder().decodeBuffer(textoEncriptado);
            MessageDigest md = MessageDigest.getInstance(patroncifrado);
            byte[] ValorContraseña = md.digest(clavesecreta.getBytes("utf-8"));
            byte[] BytesDeContraseña = Arrays.copyOf(ValorContraseña, 24);
            Clave = new SecretKeySpec(BytesDeContraseña, "DESede");
            descifrar = descifrar.getInstance("DESede");
            descifrar.init(Cipher.DECRYPT_MODE, Clave);
            byte[] BytesDeTexto = descifrar.doFinal(valoresdecript);
            DesencriptadoFinal = new String(BytesDeTexto, "UTF-8");
 
        } catch (Exception ex) {
              System.err.println(ex.getMessage());
        }
        return DesencriptadoFinal;
    }
   
 }

           
    