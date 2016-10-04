package connection;

import helper.FunCrate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Random;

/**
 * Created by sander on 28-9-16.
 */
public class ConnectionCreation {
    private HashSet<String> links;
    private int urlLength;

    public ConnectionCreation(){
        this.links = new HashSet<String>();
        this.urlLength = -1;
    }

    /**
     * Retrieves the url length from the config file. Returns 4 if none is configured.
     *
     * @return the preconfigured url length
     * @throws IOException
     */
    private int getUrlLength() throws IOException {
        if(this.urlLength == -1){
            try{
                this.urlLength = Integer.parseInt(FunCrate.getConfigValue("urlLength"));
            } catch (NumberFormatException ex) {
                this.urlLength = 4;
            }
        } else {
            if(this.links.size() > Math.pow(26, this.urlLength) / 2){
                this.urlLength++;
            }
        }
        return this.urlLength;
    }

    /**
     * Generates a Connection URL and returns it.
     *
     * TODO: Goes in an infinite loop when there are 456976 (26^4) connections. Also gets really heavy when more than half of the 456976 urls are in use.
     * SOLUTION: Add one character when half of the possibilities are taken.
     *
     * @return
     * @throws IOException
     */
    private String generateConnectionURL(){
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder url = new StringBuilder();
        Random random = new Random();

        try{
            this.urlLength = getUrlLength();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            this.urlLength = 4;
        }


        for (int i = 0; i < this.urlLength; i++){
            url.append(chars.charAt(random.nextInt(chars.length())));
        }

        if(this.links.contains(url.toString())){
            return generateConnectionURL();
        } else {
            return url.toString();
        }
    }

    /**
     * Generates the connection URL and saves it.
     *
     * @return
     */
    public String addConnectionURL() {
        String url = generateConnectionURL();

        links.add(url);

        return url;
    }

    /**
     * Removes the stored connection URL given as parameter.
     *
     * @param url
     * @return
     */
    public void removeConnectionURL(String url) {
        links.remove(url);
    }

    /**
     * TEST METHOD: Checks if the URL is in use
     *
     * @param url
     * @return
     */
    public Boolean checkURLInUse (String url) {
        return this.links.contains(url);
    }

    public int getSize() {
        return this.links.size();
    }
}
