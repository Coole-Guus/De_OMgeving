package services;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class HttpClientBuilder {

    public void httpGet(String tabel, String... attributen) {
        try {

            Client client = Client.create();
            String totalVars = "";
            for(String attribuut : attributen) {
                totalVars = totalVars + "/" + attribuut;
            }

            WebResource webResource = client.resource("http://localhost:8080/" + tabel + totalVars);

            getReturn (webResource);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    private void getReturn(WebResource webResource) {
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "  + response.getStatus());
        }

        String output = response.getEntity(String.class);

//        System.out.println("Output from Server .... \n");
//        System.out.println(output);
    }
}
