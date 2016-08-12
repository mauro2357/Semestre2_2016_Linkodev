/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author MARCS
 */
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

class Encriptacion {

    private SecretKey Clave;
    private Cipher cifrar;
    private String Patroncifrado = "AES";
    private int tamañoclave = 16;

    public String encriptar(String encriptable) {
        String encriptado = "";
        String nuevaclave = "lmihnacle#$%/°óú";
        byte[] valorbytes = nuevaclave.getBytes();
        Clave = new SecretKeySpec(Arrays.copyOf(valorbytes, tamañoclave), Patroncifrado);
        try {
            cifrar = Cipher.getInstance(Patroncifrado);
            cifrar.init(Cipher.ENCRYPT_MODE, Clave);
            byte[] encriptablebytes = encriptable.getBytes();
            byte[] cifradobytes = cifrar.doFinal(encriptablebytes);
            encriptado = new BASE64Encoder().encode(cifradobytes);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException |
                InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            System.err.println(ex.getMessage());
        }
        return encriptado;
    }

    public String desencriptar(String desencriptable) {
        String desencriptado = new String();
        try {
            byte[] valoresdecript = new BASE64Decoder().decodeBuffer(desencriptable);
            cifrar = Cipher.getInstance(Patroncifrado);
            cifrar.init(Cipher.DECRYPT_MODE, Clave);
            byte[] cipherbytes = cifrar.doFinal(valoresdecript);
            desencriptado = new String(cipherbytes);
        } catch (InvalidKeyException | IllegalBlockSizeException |
                BadPaddingException | IOException | NoSuchAlgorithmException | NoSuchPaddingException ex) {
            System.err.println(ex.getMessage());
        }
        return desencriptado;
    }
}
