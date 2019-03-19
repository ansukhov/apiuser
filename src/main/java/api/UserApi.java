package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.User;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

public class UserApi {

    private final String baseUrl = "https://randomuser.me/api/";

    public User getUser() {
        Response response = RestAssured.given()
                .baseUri(baseUrl)
                .get();
        User user = response.as(User.class);
        return user;
    }

    public User getUsers(int count) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            URIBuilder builder = new URIBuilder(baseUrl);
            builder.setParameter("results", String.valueOf(count));
            HttpGet request = new HttpGet(builder.build());
            HttpResponse response = client.execute(request);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response.getEntity().getContent(), User.class);
        } catch (Exception e) {
            throw new RuntimeException("Can't get list of users. Error: " + e.getMessage());
        }
    }
}
