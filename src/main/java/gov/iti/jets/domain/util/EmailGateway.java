package gov.iti.jets.domain.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.util.UUID;

public class EmailGateway {

    private static final String SITE_EMAIL = "chocotown.noreply@gmail.com";
    private static final String SITE_EMAIL_PASSWORD = "12345678A*";

    private static HtmlEmail createNewEmail() {
        var htmlEmail = new HtmlEmail();
        htmlEmail.setHostName( "smtp.gmail.com" );
        htmlEmail.setSmtpPort( 465 );
        htmlEmail.setAuthenticator( new DefaultAuthenticator( SITE_EMAIL,
                SITE_EMAIL_PASSWORD ) );
        htmlEmail.setSSLOnConnect( true );
        try {
            htmlEmail.setFrom( SITE_EMAIL );
        } catch ( EmailException e ) {
            e.printStackTrace();
        }
        return htmlEmail;
    }


    public static void sendUserRegistrationConfirmationEmail( String receiverMail, String confirmationId ) throws EmailException {
        new Thread( () -> {
            var htmlEmail = createNewEmail();
            htmlEmail.setSubject( "Confirm your ChocoTown account" );
            try {
                htmlEmail.addTo( receiverMail );
                htmlEmail.setHtmlMsg( createConfirmationEmailBody( receiverMail, confirmationId ) );
                htmlEmail.send();
            } catch ( EmailException e ) {
                e.printStackTrace();
                throw new RuntimeException( "User registration confirmation email failed to send!" );
            }
        } ).start();
    }

    public static void sendOrderConfirmationEmail( String receiverMail, String totalFormatted ) {
        new Thread( () -> {
            var htmlEmail = createNewEmail();
            htmlEmail.setSubject( "You order is on its way!" );
            try {
                htmlEmail.addTo( receiverMail );
                htmlEmail.setHtmlMsg( createOrderConfirmationEmailBody( totalFormatted ) );
                htmlEmail.send();
            } catch ( EmailException e ) {
                e.printStackTrace();
                throw new RuntimeException( "Order confirmation email failed to send!" );
            }
        } ).start();
    }

    public static void sendResetPasswordEmail( String receiverMail, String passwordResetId ) throws EmailException {
        new Thread( () -> {
            try {
                var htmlEmail = createNewEmail();
                htmlEmail.setSubject( "Password reset" );
                htmlEmail.addTo( receiverMail );
                htmlEmail.setHtmlMsg( createResetPasswordEmailBody( passwordResetId ) );
                htmlEmail.send();
            } catch ( EmailException e ) {
                e.printStackTrace();
                throw new RuntimeException( "Reset password email failed to send!" );
            }
        } ).start();
    }

    private static String createConfirmationEmailBody( String receiverEmail, String confirmationId ) {
        return "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                "<head>\n" +
                "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
                "  <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->\n" +
                "  <title></title>\n" +
                "  \n" +
                "    <style type=\"text/css\">\n" +
                "      @media only screen and (min-width: 670px) {\n" +
                "  .u-row {\n" +
                "    width: 650px !important;\n" +
                "  }\n" +
                "  .u-row .u-col {\n" +
                "    vertical-align: top;\n" +
                "  }\n" +
                "\n" +
                "  .u-row .u-col-100 {\n" +
                "    width: 650px !important;\n" +
                "  }\n" +
                "\n" +
                "}\n" +
                "\n" +
                "@media (max-width: 670px) {\n" +
                "  .u-row-container {\n" +
                "    max-width: 100% !important;\n" +
                "    padding-left: 0px !important;\n" +
                "    padding-right: 0px !important;\n" +
                "  }\n" +
                "  .u-row .u-col {\n" +
                "    min-width: 320px !important;\n" +
                "    max-width: 100% !important;\n" +
                "    display: block !important;\n" +
                "  }\n" +
                "  .u-row {\n" +
                "    width: calc(100% - 40px) !important;\n" +
                "  }\n" +
                "  .u-col {\n" +
                "    width: 100% !important;\n" +
                "  }\n" +
                "  .u-col > div {\n" +
                "    margin: 0 auto;\n" +
                "  }\n" +
                "}\n" +
                "body {\n" +
                "  margin: 0;\n" +
                "  padding: 0;\n" +
                "}\n" +
                "\n" +
                "table,\n" +
                "tr,\n" +
                "td {\n" +
                "  vertical-align: top;\n" +
                "  border-collapse: collapse;\n" +
                "}\n" +
                "\n" +
                "p {\n" +
                "  margin: 0;\n" +
                "}\n" +
                "\n" +
                ".ie-container table,\n" +
                ".mso-container table {\n" +
                "  table-layout: fixed;\n" +
                "}\n" +
                "\n" +
                "* {\n" +
                "  line-height: inherit;\n" +
                "}\n" +
                "\n" +
                "a[x-apple-data-detectors='true'] {\n" +
                "  color: inherit !important;\n" +
                "  text-decoration: none !important;\n" +
                "}\n" +
                "\n" +
                "table, td { color: #000000; } a { color: #0000ee; text-decoration: underline; } @media (max-width: 480px) { #u_content_image_6 .v-src-width { width: auto !important; } #u_content_image_6 .v-src-max-width { max-width: 30% !important; } }\n" +
                "    </style>\n" +
                "  \n" +
                "  \n" +
                "<link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><link href=\"https://fonts.googleapis.com/css?family=Raleway:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><!--<![endif]-->\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body class=\"clean-body u_body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #3b5f8a;color: #000000\">\n" +
                "  <table style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #3b5f8a;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "  <tbody>\n" +
                "  <tr style=\"vertical-align: top\">\n" +
                "    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                "    \n" +
                "\n" +
                "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 650px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "      \n" +
                "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 650px;display: table-cell;vertical-align: top;\">\n" +
                "  <div style=\"width: 100% !important;\">\n" +
                "  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                "  \n" +
                "<table id=\"u_content_image_6\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:20px 10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "  <tr>\n" +
                "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                "      \n" +
                "      <img align=\"center\" border=\"0\" src=\"https://i.imgur.com/BDfGvHZ.png\" alt=\"Logo\" title=\"Logo\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 22%;max-width: 138.6px;\" width=\"138.6\" class=\"v-src-width v-src-max-width\"/>\n" +
                "      \n" +
                "    </td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "  <tr>\n" +
                "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                "      \n" +
                "      <img align=\"center\" border=\"0\" src=\"https://i.imgur.com/G0K6YFs.png\" alt=\"border\" title=\"border\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 100%;max-width: 650px;\" width=\"650\" class=\"v-src-width v-src-max-width\"/>\n" +
                "      \n" +
                "    </td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "</div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 650px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #f1f3f5;\">\n" +
                "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 650px;display: table-cell;vertical-align: top;\">\n" +
                "  <div style=\"width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "  <div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "  \n" +
                "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "  <tr>\n" +
                "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                "      \n" +
                "      <img align=\"center\" border=\"0\" src=\"https://i.imgur.com/nItCNmR.png\" alt=\"Hero Image\" title=\"Hero Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 77%;max-width: 500.5px;\" width=\"500.5\" class=\"v-src-width v-src-max-width\"/>\n" +
                "      \n" +
                "    </td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "</div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 650px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #f1f3f5;\">\n" +
                "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "   \n" +
                "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 650px;display: table-cell;vertical-align: top;\">\n" +
                "  <div style=\"width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "  <div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "  \n" +
                "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:40px 10px 10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "  <h1 style=\"margin: 0px; color: #333333; line-height: 140%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: 'Open Sans',sans-serif; font-size: 30px;\">\n" +
                "    <strong>Please confirm your account</strong>\n" +
                "  </h1>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 50px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "  <div style=\"color: #5e5e5e; line-height: 170%; text-align: center; word-wrap: break-word;\">\n" +
                "    <p style=\"font-size: 14px; line-height: 170%;\"><span style=\"font-family: Raleway, sans-serif; font-size: 16px; line-height: 27.2px;\">Please confirm your account to start shopping! </span></p>\n" +
                "<p style=\"font-size: 14px; line-height: 170%;\"><span style=\"font-family: Raleway, sans-serif; font-size: 16px; line-height: 27.2px;\">" + receiverEmail + "</span></p>\n" +
                "  </div>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 30px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "  <h1 style=\"margin: 0px; color: #5f5f5f; line-height: 140%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: 'Open Sans',sans-serif; font-size: 25px;\">\n" +
                "    Copy the code below and paste it in the confirmation page to confirm your email, please!\n" +
                "  </h1>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 60px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "<div align=\"center\">\n" +
                "<p style=\"background-color: rgba(159, 159, 236, 0.693)\">\n" +
                "  " + confirmationId + "\n" +
                "\n" +
                "</p>\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "  </div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 650px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 650px;display: table-cell;vertical-align: top;\">\n" +
                "  <div style=\"width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                "  \n" +
                "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "  <tr>\n" +
                "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                "      \n" +
                "      <img align=\"center\" border=\"0\" src=\"https://i.imgur.com/ZwdDjDQ.png\" alt=\"border\" title=\"border\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 100%;max-width: 650px;\" width=\"650\" class=\"v-src-width v-src-max-width\"/>\n" +
                "      \n" +
                "    </td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                "  </div>\n" +
                "</div>\n" +
                "\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "\n" +
                "    </td>\n" +
                "  </tr>\n" +
                "  </tbody>\n" +
                "  </table>\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>\n";
    }

    private static String createOrderConfirmationEmailBody( String totalFormatted ) {
        return "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\"\n" +
                "        \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\"\n" +
                "      xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                "<head>\n" +
                "    <!--[if gte mso 9]>\n" +
                "    <xml>\n" +
                "        <o:OfficeDocumentSettings>\n" +
                "            <o:AllowPNG/>\n" +
                "            <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                "        </o:OfficeDocumentSettings>\n" +
                "    </xml>\n" +
                "    <![endif]-->\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <meta name=\"x-apple-disable-message-reformatting\">\n" +
                "    <!--[if !mso]><!-->\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->\n" +
                "    <title></title>\n" +
                "\n" +
                "    <style type=\"text/css\">\n" +
                "        @media only screen and (min-width: 620px) {\n" +
                "            .u-row {\n" +
                "                width: 600px !important;\n" +
                "            }\n" +
                "\n" +
                "            .u-row .u-col {\n" +
                "                vertical-align: top;\n" +
                "            }\n" +
                "\n" +
                "            .u-row .u-col-27 {\n" +
                "                width: 162px !important;\n" +
                "            }\n" +
                "\n" +
                "            .u-row .u-col-33p33 {\n" +
                "                width: 199.98px !important;\n" +
                "            }\n" +
                "\n" +
                "            .u-row .u-col-39p67 {\n" +
                "                width: 238.02px !important;\n" +
                "            }\n" +
                "\n" +
                "            .u-row .u-col-100 {\n" +
                "                width: 600px !important;\n" +
                "            }\n" +
                "\n" +
                "        }\n" +
                "\n" +
                "        @media (max-width: 620px) {\n" +
                "            .u-row-container {\n" +
                "                max-width: 100% !important;\n" +
                "                padding-left: 0px !important;\n" +
                "                padding-right: 0px !important;\n" +
                "            }\n" +
                "\n" +
                "            .u-row .u-col {\n" +
                "                min-width: 320px !important;\n" +
                "                max-width: 100% !important;\n" +
                "                display: block !important;\n" +
                "            }\n" +
                "\n" +
                "            .u-row {\n" +
                "                width: calc(100% - 40px) !important;\n" +
                "            }\n" +
                "\n" +
                "            .u-col {\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "\n" +
                "            .u-col > div {\n" +
                "                margin: 0 auto;\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        body {\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "\n" +
                "        table,\n" +
                "        tr,\n" +
                "        td {\n" +
                "            vertical-align: top;\n" +
                "            border-collapse: collapse;\n" +
                "        }\n" +
                "\n" +
                "        p {\n" +
                "            margin: 0;\n" +
                "        }\n" +
                "\n" +
                "        .ie-container table,\n" +
                "        .mso-container table {\n" +
                "            table-layout: fixed;\n" +
                "        }\n" +
                "\n" +
                "        * {\n" +
                "            line-height: inherit;\n" +
                "        }\n" +
                "\n" +
                "        a[x-apple-data-detectors='true'] {\n" +
                "            color: inherit !important;\n" +
                "            text-decoration: none !important;\n" +
                "        }\n" +
                "\n" +
                "        table, td {\n" +
                "            color: #000000;\n" +
                "        }\n" +
                "\n" +
                "        a {\n" +
                "            color: #0000ee;\n" +
                "            text-decoration: underline;\n" +
                "        }\n" +
                "\n" +
                "        @media (max-width: 480px) {\n" +
                "            #u_content_image_1 .v-src-width {\n" +
                "                width: auto !important;\n" +
                "            }\n" +
                "\n" +
                "            #u_content_image_1 .v-src-max-width {\n" +
                "                max-width: 55% !important;\n" +
                "            }\n" +
                "\n" +
                "            #u_content_heading_1 .v-font-size {\n" +
                "                font-size: 33px !important;\n" +
                "            }\n" +
                "\n" +
                "            #u_content_heading_7 .v-container-padding-padding {\n" +
                "                padding: 30px 10px 10px !important;\n" +
                "            }\n" +
                "\n" +
                "            #u_content_heading_9 .v-container-padding-padding {\n" +
                "                padding: 20px 10px 30px !important;\n" +
                "            }\n" +
                "\n" +
                "            #u_content_heading_2 .v-container-padding-padding {\n" +
                "                padding: 30px 10px 5px 20px !important;\n" +
                "            }\n" +
                "\n" +
                "            #u_content_button_1 .v-size-width {\n" +
                "                width: auto !important;\n" +
                "            }\n" +
                "\n" +
                "            #u_content_heading_21 .v-container-padding-padding {\n" +
                "                padding: 50px 10px 30px !important;\n" +
                "            }\n" +
                "        }\n" +
                "    </style>\n" +
                "\n" +
                "\n" +
                "    <!--[if !mso]><!-->\n" +
                "    <link href=\"https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap\" rel=\"stylesheet\"\n" +
                "          type=\"text/css\">\n" +
                "    <link href=\"https://fonts.googleapis.com/css?family=Rubik:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\">\n" +
                "    <!--<![endif]-->\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body class=\"clean-body u_body\"\n" +
                "      style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #ffffff;color: #000000\">\n" +
                "<!--[if IE]>\n" +
                "<div class=\"ie-container\"><![endif]-->\n" +
                "<!--[if mso]>\n" +
                "<div class=\"mso-container\"><![endif]-->\n" +
                "<table style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #ffffff;width:100%\"\n" +
                "       cellpadding=\"0\" cellspacing=\"0\">\n" +
                "    <tbody>\n" +
                "    <tr style=\"vertical-align: top\">\n" +
                "        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                "            <!--[if (mso)|(IE)]>\n" +
                "            <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "                <tr>\n" +
                "                    <td align=\"center\" style=\"background-color: #ffffff;\"><![endif]-->\n" +
                "\n" +
                "\n" +
                "            <div class=\"u-row-container\" style=\"padding: 0px;background-color: #26264f\">\n" +
                "                <div class=\"u-row\"\n" +
                "                     style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                "                    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "                        <!--[if (mso)|(IE)]>\n" +
                "                        <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "                            <tr>\n" +
                "                                <td style=\"padding: 0px;background-color: #26264f;\" align=\"center\">\n" +
                "                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\">\n" +
                "                                        <tr style=\"background-color: transparent;\"><![endif]-->\n" +
                "\n" +
                "                        <!--[if (mso)|(IE)]>\n" +
                "                        <td align=\"center\" width=\"600\"\n" +
                "                            style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"\n" +
                "                            valign=\"top\"><![endif]-->\n" +
                "                        <div class=\"u-col u-col-100\"\n" +
                "                             style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                "                            <div style=\"width: 100% !important;\">\n" +
                "                                <!--[if (!mso)&(!IE)]><!-->\n" +
                "                                <div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\">\n" +
                "                                    <!--<![endif]-->\n" +
                "\n" +
                "                                    <table id=\"u_content_image_1\" style=\"font-family:arial,helvetica,sans-serif;\"\n" +
                "                                           role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                                        <tbody>\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"v-container-padding-padding\"\n" +
                "                                                style=\"overflow-wrap:break-word;word-break:break-word;padding:50px 10px;font-family:arial,helvetica,sans-serif;\"\n" +
                "                                                align=\"left\">\n" +
                "\n" +
                "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td style=\"padding-right: 0px;padding-left: 0px;\"\n" +
                "                                                            align=\"center\">\n" +
                "                                                            <a href=\"https://unlayer.com\" target=\"_blank\">\n" +
                "                                                                <img align=\"center\" border=\"0\" src=\"https://i.imgur.com/AwxLUEA.png\"\n" +
                "                                                                     alt=\"Logo\" title=\"Logo\"\n" +
                "                                                                     style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 24%;max-width: 139.2px;\"\n" +
                "                                                                     width=\"139.2\" class=\"v-src-width v-src-max-width\"/>\n" +
                "                                                            </a>\n" +
                "                                                        </td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                        </tbody>\n" +
                "                                    </table>\n" +
                "\n" +
                "                                    <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "                        <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "\n" +
                "\n" +
                "            <div class=\"u-row-container\"\n" +
                "                 style=\"padding: 0px;background-image: url('https://i.imgur.com/kfq1XZp.jpg');background-repeat: no-repeat;background-position: center top;background-color: transparent\">\n" +
                "                <div class=\"u-row\"\n" +
                "                     style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
                "                    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "                        <!--[if (mso)|(IE)]>\n" +
                "                        <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "                            <tr>\n" +
                "                                <td style=\"padding: 0px;background-image: url('https://i.imgur.com/kfq1XZp.jpg');background-repeat: no-repeat;background-position: center top;background-color: transparent;\"\n" +
                "                                    align=\"center\">\n" +
                "                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\">\n" +
                "                                        <tr style=\"background-color: #ffffff;\"><![endif]-->\n" +
                "\n" +
                "                        <!--[if (mso)|(IE)]>\n" +
                "                        <td align=\"center\" width=\"600\"\n" +
                "                            style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"\n" +
                "                            valign=\"top\"><![endif]-->\n" +
                "                        <div class=\"u-col u-col-100\"\n" +
                "                             style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                "                            <div style=\"width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "                                <!--[if (!mso)&(!IE)]><!-->\n" +
                "                                <div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "                                    <!--<![endif]-->\n" +
                "\n" +
                "                                    <table id=\"u_content_heading_1\" style=\"font-family:arial,helvetica,sans-serif;\"\n" +
                "                                           role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                                        <tbody>\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"v-container-padding-padding\"\n" +
                "                                                style=\"overflow-wrap:break-word;word-break:break-word;padding:30px 10px 10px;font-family:arial,helvetica,sans-serif;\"\n" +
                "                                                align=\"left\">\n" +
                "\n" +
                "                                                <h1 class=\"v-font-size\"\n" +
                "                                                    style=\"margin: 0px; color: #3f4481; line-height: 140%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: 'Montserrat',sans-serif; font-size: 47px;\">\n" +
                "                                                    <strong>Order Confirmed!</strong>\n" +
                "                                                </h1>\n" +
                "\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                        </tbody>\n" +
                "                                    </table>\n" +
                "\n" +
                "                                    <table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\"\n" +
                "                                           cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                                        <tbody>\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"v-container-padding-padding\"\n" +
                "                                                style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\"\n" +
                "                                                align=\"left\">\n" +
                "\n" +
                "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td style=\"padding-right: 0px;padding-left: 0px;\"\n" +
                "                                                            align=\"center\">\n" +
                "\n" +
                "                                                            <img align=\"center\" border=\"0\" src=\"https://i.imgur.com/g8utu2o.jpg\"\n" +
                "                                                                 alt=\"Hero Image\" title=\"Hero Image\"\n" +
                "                                                                 style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 100%;max-width: 580px;\"\n" +
                "                                                                 width=\"580\" class=\"v-src-width v-src-max-width\"/>\n" +
                "\n" +
                "                                                        </td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                        </tbody>\n" +
                "                                    </table>\n" +
                "\n" +
                "                                    <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "                        <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "\n" +
                "\n" +
                "            <div class=\"u-row-container\"\n" +
                "                 style=\"padding: 0px;background-image: url('https://i.imgur.com/ddVch2G.jpg');background-repeat: no-repeat;background-position: center top;background-color: transparent\">\n" +
                "                <div class=\"u-row\"\n" +
                "                     style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
                "                    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "                        <!--[if (mso)|(IE)]>\n" +
                "                        <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "                            <tr>\n" +
                "                                <td style=\"padding: 0px;background-image: url('https://i.imgur.com/ddVch2G.jpg');background-repeat: no-repeat;background-position: center top;background-color: transparent;\"\n" +
                "                                    align=\"center\">\n" +
                "                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\">\n" +
                "                                        <tr style=\"background-color: #ffffff;\"><![endif]-->\n" +
                "\n" +
                "                        <!--[if (mso)|(IE)]>\n" +
                "                        <td align=\"center\" width=\"238\"\n" +
                "                            style=\"width: 238px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"\n" +
                "                            valign=\"top\"><![endif]-->\n" +
                "                        <div class=\"u-col u-col-39p67\"\n" +
                "                             style=\"max-width: 320px;min-width: 238px;display: table-cell;vertical-align: top;\">\n" +
                "                            <div style=\"width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "                                <!--[if (!mso)&(!IE)]><!-->\n" +
                "                                <div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "                                    <!--<![endif]-->\n" +
                "\n" +
                "                                    <table id=\"u_content_heading_7\" style=\"font-family:arial,helvetica,sans-serif;\"\n" +
                "                                           role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                                        <tbody>\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"v-container-padding-padding\"\n" +
                "                                                style=\"overflow-wrap:break-word;word-break:break-word;padding:20px 10px 10px;font-family:arial,helvetica,sans-serif;\"\n" +
                "                                                align=\"left\">\n" +
                "\n" +
                "                                                <h4 class=\"v-font-size\"\n" +
                "                                                    style=\"margin: 0px; color: #6a71a8; line-height: 140%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: 'Rubik',sans-serif; font-size: 20px;\">\n" +
                "                                                    <strong>TOTAL</strong>\n" +
                "                                                </h4>\n" +
                "\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                        </tbody>\n" +
                "                                    </table>\n" +
                "\n" +
                "                                    <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "                        <!--[if (mso)|(IE)]>\n" +
                "                        <td align=\"center\" width=\"162\"\n" +
                "                            style=\"width: 162px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"\n" +
                "                            valign=\"top\"><![endif]-->\n" +
                "                        <div class=\"u-col u-col-27\"\n" +
                "                             style=\"max-width: 320px;min-width: 162px;display: table-cell;vertical-align: top;\">\n" +
                "                            <div style=\"width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "                                <!--[if (!mso)&(!IE)]><!-->\n" +
                "                                <div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "                                    <!--<![endif]-->\n" +
                "\n" +
                "                                    <table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\"\n" +
                "                                           cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                                        <tbody>\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"v-container-padding-padding\"\n" +
                "                                                style=\"overflow-wrap:break-word;word-break:break-word;padding:20px 10px 10px;font-family:arial,helvetica,sans-serif;\"\n" +
                "                                                align=\"left\">\n" +
                "\n" +
                "                                                <h4 class=\"v-font-size\"\n" +
                "                                                    style=\"margin: 0px; color: #6a71a8; line-height: 140%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: 'Montserrat',sans-serif; font-size: 16px;\">\n" +
                "                                                    &nbsp;\n" +
                "                                                </h4>\n" +
                "\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                        </tbody>\n" +
                "                                    </table>\n" +
                "\n" +
                "                                    <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "                        <!--[if (mso)|(IE)]>\n" +
                "                        <td align=\"center\" width=\"200\"\n" +
                "                            style=\"width: 200px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"\n" +
                "                            valign=\"top\"><![endif]-->\n" +
                "                        <div class=\"u-col u-col-33p33\"\n" +
                "                             style=\"max-width: 320px;min-width: 200px;display: table-cell;vertical-align: top;\">\n" +
                "                            <div style=\"width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "                                <!--[if (!mso)&(!IE)]><!-->\n" +
                "                                <div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "                                    <!--<![endif]-->\n" +
                "\n" +
                "                                    <table id=\"u_content_heading_9\" style=\"font-family:arial,helvetica,sans-serif;\"\n" +
                "                                           role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                                        <tbody>\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"v-container-padding-padding\"\n" +
                "                                                style=\"overflow-wrap:break-word;word-break:break-word;padding:20px 10px 30px;font-family:arial,helvetica,sans-serif;\"\n" +
                "                                                align=\"left\">\n" +
                "\n" +
                "                                                <h4 class=\"v-font-size\"\n" +
                "                                                    style=\"margin: 0px; color: #6a71a8; line-height: 140%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: 'Rubik',sans-serif; font-size: 19px;\">\n" +
                "                                                    <strong>EGP " + totalFormatted + "</strong>\n" +
                "                                                </h4>\n" +
                "\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                        </tbody>\n" +
                "                                    </table>\n" +
                "\n" +
                "                                    <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "                        <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "\n" +
                "            <div class=\"u-row-container\" style=\"padding: 0px;background-color: #26264f\">\n" +
                "                <div class=\"u-row\"\n" +
                "                     style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                "                    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "                        <!--[if (mso)|(IE)]>\n" +
                "                        <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "                            <tr>\n" +
                "                                <td style=\"padding: 0px;background-color: #26264f;\" align=\"center\">\n" +
                "                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\">\n" +
                "                                        <tr style=\"background-color: transparent;\"><![endif]-->\n" +
                "\n" +
                "                        <!--[if (mso)|(IE)]>\n" +
                "                        <td align=\"center\" width=\"600\"\n" +
                "                            style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"\n" +
                "                            valign=\"top\"><![endif]-->\n" +
                "                        <div class=\"u-col u-col-100\"\n" +
                "                             style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                "                            <div style=\"width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "                                <!--[if (!mso)&(!IE)]><!-->\n" +
                "                                <div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "                                    <!--<![endif]-->\n" +
                "\n" +
                "                                    <table id=\"u_content_heading_21\" style=\"font-family:arial,helvetica,sans-serif;\"\n" +
                "                                           role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                                        <tbody>\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"v-container-padding-padding\"\n" +
                "                                                style=\"overflow-wrap:break-word;word-break:break-word;padding:50px 10px 20px;font-family:arial,helvetica,sans-serif;\"\n" +
                "                                                align=\"left\">\n" +
                "\n" +
                "                                                <h1 class=\"v-font-size\"\n" +
                "                                                    style=\"margin: 0px; color: #ffffff; line-height: 140%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: 'Montserrat',sans-serif; font-size: 31px;\">\n" +
                "                                                    ChocoTown\n" +
                "                                                </h1>\n" +
                "\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                        </tbody>\n" +
                "                                    </table>\n" +
                "\n" +
                "                                    <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "                        <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "\n" +
                "\n" +
                "            <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "                <div class=\"u-row\"\n" +
                "                     style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                "                    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "                        <!--[if (mso)|(IE)]>\n" +
                "                        <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "                            <tr>\n" +
                "                                <td style=\"padding: 0px;background-color: transparent;\" align=\"center\">\n" +
                "                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\">\n" +
                "                                        <tr style=\"background-color: transparent;\"><![endif]-->\n" +
                "\n" +
                "                        <!--[if (mso)|(IE)]>\n" +
                "                        <td align=\"center\" width=\"600\"\n" +
                "                            style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"\n" +
                "                            valign=\"top\"><![endif]-->\n" +
                "                        <div class=\"u-col u-col-100\"\n" +
                "                             style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                "                            <div style=\"width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "                                <!--[if (!mso)&(!IE)]><!-->\n" +
                "                                <div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "                                    <!--<![endif]-->\n" +
                "\n" +
                "                                    <table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\"\n" +
                "                                           cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                                        <tbody>\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"v-container-padding-padding\"\n" +
                "                                                style=\"overflow-wrap:break-word;word-break:break-word;padding:20px 10px;font-family:arial,helvetica,sans-serif;\"\n" +
                "                                                align=\"left\">\n" +
                "\n" +
                "                                                <div style=\"color: #95a5a6; line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
                "                                                    <p style=\"font-size: 14px; line-height: 140%;\"><span\n" +
                "                                                            style=\"font-family: Rubik, sans-serif; font-size: 14px; line-height: 19.6px;\">&copy; 2022 ITI JETS. All Rights Reserved.</span>\n" +
                "                                                    </p>\n" +
                "                                                </div>\n" +
                "\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                        </tbody>\n" +
                "                                    </table>\n" +
                "\n" +
                "                                    <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "                        <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "\n" +
                "\n" +
                "            <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "<!--[if mso]></div><![endif]-->\n" +
                "<!--[if IE]></div><![endif]-->\n" +
                "</body>\n" +
                "\n" +
                "</html>\n";
    }

    private static String createResetPasswordEmailBody( String passwordResetId ) {
        return "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                "<head>\n" +
                "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
                "  <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->\n" +
                "  <title></title>\n" +
                "  \n" +
                "    <style type=\"text/css\">\n" +
                "      @media only screen and (min-width: 670px) {\n" +
                "  .u-row {\n" +
                "    width: 650px !important;\n" +
                "  }\n" +
                "  .u-row .u-col {\n" +
                "    vertical-align: top;\n" +
                "  }\n" +
                "\n" +
                "  .u-row .u-col-100 {\n" +
                "    width: 650px !important;\n" +
                "  }\n" +
                "\n" +
                "}\n" +
                "\n" +
                "@media (max-width: 670px) {\n" +
                "  .u-row-container {\n" +
                "    max-width: 100% !important;\n" +
                "    padding-left: 0px !important;\n" +
                "    padding-right: 0px !important;\n" +
                "  }\n" +
                "  .u-row .u-col {\n" +
                "    min-width: 320px !important;\n" +
                "    max-width: 100% !important;\n" +
                "    display: block !important;\n" +
                "  }\n" +
                "  .u-row {\n" +
                "    width: calc(100% - 40px) !important;\n" +
                "  }\n" +
                "  .u-col {\n" +
                "    width: 100% !important;\n" +
                "  }\n" +
                "  .u-col > div {\n" +
                "    margin: 0 auto;\n" +
                "  }\n" +
                "}\n" +
                "body {\n" +
                "  margin: 0;\n" +
                "  padding: 0;\n" +
                "}\n" +
                "\n" +
                "table,\n" +
                "tr,\n" +
                "td {\n" +
                "  vertical-align: top;\n" +
                "  border-collapse: collapse;\n" +
                "}\n" +
                "\n" +
                "p {\n" +
                "  margin: 0;\n" +
                "}\n" +
                "\n" +
                ".ie-container table,\n" +
                ".mso-container table {\n" +
                "  table-layout: fixed;\n" +
                "}\n" +
                "\n" +
                "* {\n" +
                "  line-height: inherit;\n" +
                "}\n" +
                "\n" +
                "a[x-apple-data-detectors='true'] {\n" +
                "  color: inherit !important;\n" +
                "  text-decoration: none !important;\n" +
                "}\n" +
                "\n" +
                "table, td { color: #000000; } a { color: #0000ee; text-decoration: underline; } @media (max-width: 480px) { #u_content_image_6 .v-src-width { width: auto !important; } #u_content_image_6 .v-src-max-width { max-width: 30% !important; } }\n" +
                "    </style>\n" +
                "  \n" +
                "  \n" +
                "<link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><link href=\"https://fonts.googleapis.com/css?family=Raleway:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><!--<![endif]-->\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body class=\"clean-body u_body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #3b5f8a;color: #000000\">\n" +
                "  <table style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #3b5f8a;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "  <tbody>\n" +
                "  <tr style=\"vertical-align: top\">\n" +
                "    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                "    \n" +
                "\n" +
                "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 650px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "      \n" +
                "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 650px;display: table-cell;vertical-align: top;\">\n" +
                "  <div style=\"width: 100% !important;\">\n" +
                "  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                "  \n" +
                "<table id=\"u_content_image_6\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:20px 10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "  <tr>\n" +
                "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                "      \n" +
                "      <img align=\"center\" border=\"0\" src=\"https://i.imgur.com/BDfGvHZ.png\" alt=\"Logo\" title=\"Logo\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 22%;max-width: 138.6px;\" width=\"138.6\" class=\"v-src-width v-src-max-width\"/>\n" +
                "      \n" +
                "    </td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "  <tr>\n" +
                "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                "      \n" +
                "      <img align=\"center\" border=\"0\" src=\"https://i.imgur.com/G0K6YFs.png\" alt=\"border\" title=\"border\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 100%;max-width: 650px;\" width=\"650\" class=\"v-src-width v-src-max-width\"/>\n" +
                "      \n" +
                "    </td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "</div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 650px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #f1f3f5;\">\n" +
                "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 650px;display: table-cell;vertical-align: top;\">\n" +
                "  <div style=\"width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "  <div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "  \n" +
                "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "  <tr>\n" +
                "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                "      \n" +
                "      <img align=\"center\" border=\"0\" src=\"https://i.imgur.com/nItCNmR.png\" alt=\"Hero Image\" title=\"Hero Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 77%;max-width: 500.5px;\" width=\"500.5\" class=\"v-src-width v-src-max-width\"/>\n" +
                "      \n" +
                "    </td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "</div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 650px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #f1f3f5;\">\n" +
                "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "   \n" +
                "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 650px;display: table-cell;vertical-align: top;\">\n" +
                "  <div style=\"width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "  <div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "  \n" +
                "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:40px 10px 10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "  <h1 style=\"margin: 0px; color: #333333; line-height: 140%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: 'Open Sans',sans-serif; font-size: 30px;\">\n" +
                "    <strong>Password reset</strong>\n" +
                "  </h1>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 50px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 30px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "  <h1 style=\"margin: 0px; color: #5f5f5f; line-height: 140%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: 'Open Sans',sans-serif; font-size: 25px;\">\n" +
                "    Copy the code below and paste it in the password reset page to reset your password, please!\n" +
                "  </h1>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 60px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "<div align=\"center\">\n" +
                "<p style=\"background-color: rgba(159, 159, 236, 0.693)\">\n" +
                "  " + passwordResetId + "\n" +
                "\n" +
                "</p>\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "  </div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 650px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 650px;display: table-cell;vertical-align: top;\">\n" +
                "  <div style=\"width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                "  \n" +
                "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "  <tr>\n" +
                "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                "      \n" +
                "      <img align=\"center\" border=\"0\" src=\"https://i.imgur.com/ZwdDjDQ.png\" alt=\"border\" title=\"border\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 100%;max-width: 650px;\" width=\"650\" class=\"v-src-width v-src-max-width\"/>\n" +
                "      \n" +
                "    </td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                "  </div>\n" +
                "</div>\n" +
                "\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "\n" +
                "    </td>\n" +
                "  </tr>\n" +
                "  </tbody>\n" +
                "  </table>\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>\n";
    }

}
