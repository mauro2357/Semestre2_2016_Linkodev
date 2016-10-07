/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASESAUXILIARES;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author felipe
 */
public class EnvioMail {

    public EnvioMail() {
    }
    
    public boolean enviarMail(String correoDestinatario,String codigo){
        try {
            String host = "smtp.gmail.com";
            String correoOrigen = "linkodevs@gmail.com";
            Properties propiedades = System.getProperties();
            propiedades.put("mail.smtp.starttls.enable", "true");
            propiedades.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            propiedades.put("mail.smtp.host", host);
            propiedades.put("mail.smtp.user", correoOrigen);
            propiedades.put("mail.smtp.password", "linkodevs123");
            propiedades.put("mail.smtp.port", 587);
            propiedades.put("mail.smtp.auth", "true");
            
            Session sesion = Session.getDefaultInstance(propiedades,null);
            MimeMessage  mensaje = new MimeMessage(sesion);
            mensaje.setFrom(new InternetAddress(correoOrigen));
            mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(correoDestinatario));
            mensaje.setSubject("Código para reestablecer tu contrasena");
            mensaje.setText("Recientemente se ha enviado una solicitud de reestablecimiento de contrasena en IOInmuebles a este correo, aquí esta tu codigo para realizarla.\n"
                    + codigo+"\n"
                    + "Si no has hecho tu esta petición puedes omitir este correo. \n"
                    + "Gracias \n"
                    + "El equipo de Linkcodev");
            
            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(host,correoOrigen,"linkodevs123");
            transporte.sendMessage(mensaje, mensaje.getAllRecipients());
            transporte.close();
            
        } catch (MessagingException ex) {
            Logger.getLogger(EnvioMail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}


