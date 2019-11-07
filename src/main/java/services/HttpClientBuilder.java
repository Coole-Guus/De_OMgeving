package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import models.Account;
import models.Experiment;

import java.lang.reflect.Array;
import java.util.Arrays;


public class HttpClientBuilder {

    private GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();
    private boolean logintoken;
    private String currentRol;
    private Account[] accounts;

    public void httpGet(String tabel, String... attributen) {
        try {

            Client client = Client.create();
            String totalVars = "";

            for(String attribuut : attributen) {

                totalVars = totalVars + "/" + attribuut;
            }
            System.out.println("http://localhost:8080/" + tabel + totalVars);
            WebResource webResource = client.resource("http://localhost:8080/" + tabel + totalVars);
            getReturn (webResource, tabel, totalVars, attributen);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public Object httpGet(Class resultClass, String tabel, String... attributen) {
        Client client = Client.create();
        String totalVars = "";

        for(String attribuut : attributen) {

            totalVars = totalVars + "/" + attribuut;
        }

        WebResource webResource = client.resource("http://localhost:8080/" + tabel + totalVars);
        System.out.println("URL: " + "http://localhost:8080/" + tabel + totalVars);
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "  + response.getStatus());
        }

        String output = response.getEntity(String.class);
        System.out.println(output);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        Object outputObject = gson.fromJson(output, resultClass);

        return outputObject;

    }

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

            System.out.println("POST TO " + "http://localhost:8080/" + tabel + totalVars);
            System.out.println(json);
            WebResource webResource = client.resource("http://localhost:8080/" + tabel + totalVars);
            String response = webResource.type("application/json").post(String.class, json);

            return response;
            //"http://localhost:8080/experimenten/create")

           } catch (Exception e) {

            e.printStackTrace();

        }

        return null;
    }

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
            this.accounts = gson.fromJson(output, Account[].class);
        }
        else if(tabel.contains ("accounts") && attributen[0] != null) {
            currentRol = output;
        }

//        Experiment experiment = gson.fromJson(output, Experiment.class);

    }

    public boolean getIsValidLogin() { return logintoken; }

    public String getRol() { return currentRol; }

    public Account[] getAccounts() { return accounts; }


}
