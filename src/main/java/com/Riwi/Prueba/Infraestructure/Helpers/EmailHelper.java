package com.Riwi.Prueba.Infraestructure.Helpers;
import lombok.AllArgsConstructor;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;



@Component
@AllArgsConstructor
public class EmailHelper {
    //Iyectar el servicio de email la libreria
    private final JavaMailSender mailSender;

/*
    public void sendMail(String email){
        MimeMessage message = mailSender.createMimeMessage();


        try {
            message.setFrom(new InternetAddress("Alejandromarulanda702@gmail.com"));
            message.setSubject("confirma envio");

            message.setRecipients(MimeMessage.RecipientType.TO);
            message.setContent(htmlContent, MediaType.TEXT_HTML_VALUE);

            mailSender.send(message);
            System.out.println("Email enviado");

        } catch (Exception e) {
            System.out.println("ERROR no se pudo enviar el email " + e.getMessage());

        }
    }


    private String readHTMLTemplate(String nameClient, String nameEmployee, String date){
        //Indicar en donde se encuentra el template
        final Path path = Paths.get("src/main/resources/emails/email_template.html");

        try (var lines = Files.lines(path)){
            var html = lines.collect(Collectors.joining());

            return html.replace("{name}", nameClient).replace("{employee}", nameEmployee).replace("{date}", date);
        } catch (IOException e) {
            System.out.println("No se pudo leer el html");
            throw new RuntimeException();
        }
    }
    */

}
