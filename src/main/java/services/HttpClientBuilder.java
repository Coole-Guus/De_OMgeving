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

            WebResource webResource = client.resource("http://localhost:8080/" + tabel + totalVars);

            getReturn (webResource, tabel, attributen, totalVars);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
//TODO fix
    public void httpPost(Object object) {
        try {

            Client client = Client.create();

            Gson gson = new Gson();
            String json = gson.toJson (object);

            WebResource webResource = client.resource("http://localhost:8080/experiment/create");
            webResource.accept("application/json").post(ClientResponse.class, json);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    private void getReturn(WebResource webResource, String tabel, String[] attributen, String totalVars) {
        Gson gson = new Gson();

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
