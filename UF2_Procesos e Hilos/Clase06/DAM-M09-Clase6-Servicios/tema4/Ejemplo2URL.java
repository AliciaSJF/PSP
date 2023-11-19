package tema4;

import java.net.*;
import java.io.*;

public class Ejemplo2URL {
     
      public static void main(String[] args) {
           
            URL url=null;
           
            try {
                  url = new URL("https://www.linkiafp.es");
            } catch (MalformedURLException e) {
                  e.printStackTrace();
            }
           
            BufferedReader in;
            try {
                  InputStream inputstream = url.openStream();
                  in = new BufferedReader(new InputStreamReader(inputstream));
                  String inputLine;
                  while ((inputLine = in.readLine()) != null)
                        System.out.println(inputLine);
                  in.close();
            } catch (IOException e) {
                  e.printStackTrace();
            }
           
      }// Fin de main

}//Fin de Ejemplo2URL
