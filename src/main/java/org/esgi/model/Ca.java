package org.esgi.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by maxime on 3/13/14.
 */
public class Ca
{
    private String derFile =  "/opt/pki/certificats/ca.der";
    private String crtFiles =  "/opt/pki/certificats/";
    private String configs = "/opt/pki/config/ca.config";

    public void setDerFile(String derFile) {
        this.derFile = derFile;
    }

    public Certificat generateCert(Certificat certificat)
    {


        String command4 = "openssl req -batch -nodes -newkey rsa:2048 -keyout "
                + this.crtFiles + certificat.getCertName()  + ".key -out "
                + this.crtFiles + certificat.getCertName() + ".csr -subj \"/C="
                + certificat.getCountryName()
                + "/ST=" + certificat.getState()
                + "/L=" + certificat.getState()
                + "/O=" + certificat.getCompagny()
                + "/OU=" + certificat.getSection()
                + "/CN=" + certificat.getCommonName() + "\""
        ;

        String command5 = "openssl ca -batch -config " + this.configs
                + " -out " + certificat.getCertName() + ".crt -infiles "
                + this.crtFiles + certificat.getCertName() + ".csr"
        ;

        Runtime runtime = Runtime.getRuntime();

        try {
            runtime.exec(command4);
            //runtime.exec(command5);
            System.out.println(command4);
            System.out.println(command5);


            certificat.setContent(this.readFile(this.crtFiles + certificat.getCertName() + ".crt" ));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return certificat;
    }

    private String readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }
}
