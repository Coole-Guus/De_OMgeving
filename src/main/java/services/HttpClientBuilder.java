package services;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class HttpClientBuilder {

    public void httpGet(String tabel, String var1, String var2, String var3) {
        try {

            Client client = Client.create();

            WebResource webResource = client.resource("http://localhost:8080/" + tabel + "/" + var1 + "/" + var2 + "/" + var3);

            getReturn (webResource);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public void httpGet(String tabel, String var1, String var2) {
        try {

            Client client = Client.create();

            WebResource webResource = client.resource("http://localhost:8080/" + tabel + "/" + var1 + "/" + var2);

            getReturn (webResource);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public void httpGet(String tabel, String var1) {
        try {

            Client client = Client.create();

            WebResource webResource = client.resource("http://localhost:8080/" + tabel + "/" + var1);

            getReturn (webResource);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public void httpGet(String tabel) {
        try {

            Client client = Client.create();

            WebResource webResource = client.resource("http://localhost:8080/" + tabel);

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

        System.out.println("Output from Server .... \n");
        System.out.println(output);
    }
}
