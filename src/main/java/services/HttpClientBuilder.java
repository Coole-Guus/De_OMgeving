package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import models.Account;

public class HttpClientBuilder {

    private GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();
    private boolean logintoken;
    private String currentRol;
    private Account[] accounts;

    /**
     * @author Guus Kleinlein
     * generates Http get request.
     * @param tabel
     * @param attributen
     */
    public void httpGet(String tabel, String... attributen) {
        try {

            Client client = Client.create();
            String totalVars = "";

            for(String attribuut : attributen) {

                totalVars = totalVars + "/" + attribuut;
            }
            WebResource webResource = client.resource("http://localhost:8080/" + tabel + totalVars);
            getReturn (webResource, tabel, totalVars, attributen);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    /**
     * @author Stefan Damen, Guus Kleinlein
     * Generates the http get with a body containing json of an object.
     * @param resultClass
     * @param tabel
     * @param attributen
     * @return
     */
    public Object httpGet(Class resultClass, String tabel, String... attributen) {
        Client client = Client.create();
        String totalVars = "";

        for(String attribuut : attributen) {

            totalVars = totalVars + "/" + attribuut;
        }

        WebResource webResource = client.resource("http://localhost:8080/" + tabel + totalVars);
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "  + response.getStatus());
        }

        String output = response.getEntity(String.class);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        Object outputObject = gson.fromJson(output, resultClass);

        return outputObject;

    }

    /**
     * @author Stefan Damen, Guus Kleinlein
     * Generates http post request with an object body.
     * @param object
     * @param tabel
     * @param attributen
     * @return
     */
    public String httpPostAdd(Object object, String tabel, String... attributen) {
        try {
            Client client = Client.create();

            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
            String json = gson.toJson (object);

            String totalVars = "";

            for(String attribuut : attributen) {

                totalVars = totalVars + "/" + attribuut;
            }

            WebResource webResource = client.resource("http://localhost:8080/" + tabel + totalVars);
            try {
                String response = webResource.type("application/json").post(String.class, json);
                return response;

            } catch(Exception e) {
                System.out.println(e.getMessage());
            }


        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;
    }

    /**
     * @author Guus Kleinlein
     * Catches the return of the http and decodes it into somethin useable.
     * @param webResource
     * @param tabel
     * @param totalVars
     * @param attributen
     */
    private void getReturn(WebResource webResource, String tabel, String totalVars, String... attributen) {
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "  + response.getStatus());
        }

        String output = response.getEntity(String.class);

        if(output.contains ("false") || output.contains ("true")) {
            logintoken = Boolean.valueOf (output);
        }

        else if(totalVars.contains ("users/accountId/accountRol")) {
            accounts = null;
            this.accounts = gson.fromJson(output, Account[].class);
        }
        else if(tabel.contains ("accounts") && attributen[0] != null) {
            currentRol = output;
        }

    }

    public boolean getIsValidLogin() { return logintoken; }

    public String getRol() { return currentRol; }

    public Account[] getAccounts() { return accounts; }


}
