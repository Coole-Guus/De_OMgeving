package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import models.Experiment;


public class HttpClientBuilder {

    private GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();
    private boolean logintoken;

    public void httpGet(String tabel, String... attributen) {
        try {

            Client client = Client.create();
            String totalVars = "";

            for(String attribuut : attributen) {

                totalVars = totalVars + "/" + attribuut;
            }
            System.out.println("http://localhost:8080/" + tabel + totalVars);
            WebResource webResource = client.resource("http://localhost:8080/" + tabel + totalVars);
            System.out.println("halllo");
            getReturn (webResource, tabel);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public Object httpGet(Class resultClass, String tabel, String... attributen) {
        try {
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

            Gson gson = new Gson();
            Object outputObject = gson.fromJson(output, resultClass);

            return outputObject;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void httpPostAdd(Object object, String tabel, String... attributen) {
        try {
            Client client = Client.create();

            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
            String json = gson.toJson (object);
            String totalVars = "";

            for (String attribuut: attributen)
                totalVars = totalVars + "/" + attribuut;
            WebResource webResource = client.resource("http://localhost:8080/" + tabel + totalVars);
            ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);
        } catch (Exception e) {

            e.printStackTrace();

        }
    }



//    public void httpPost() {
//        try {
//
//            Client client = Client.create();
//
//            Gson gson = new Gson();
//            String json = gson.toJson (object);
//
//            WebResource webResource = client.resource("http://localhost:8080/experiment/create");
//            webResource.accept("application/json").post(ClientResponse.class, json);
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//
//        }
//    }

    private void getReturn(WebResource webResource, String tabel) {
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "  + response.getStatus());
        }

        String output = response.getEntity(String.class);

        if(tabel.equals ("accounts")) {
            logintoken = Boolean.valueOf (output);
        }

        Gson gson = new Gson();

//        Experiment experiment = gson.fromJson(output, Experiment.class);

    }

    public boolean getIsValidLogin() { return logintoken; }

}
