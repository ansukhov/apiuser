import api.UserApi;
import model.User;
import org.junit.jupiter.api.Test;

public class GetUsers {

    @Test
    public void testApi() {
        UserApi userApi = new UserApi();
        User person = userApi.getUser();
        System.out.println(person.getResults().get(0));

        System.out.println("Several users:");

        User users = userApi.getUsers(5);
        users.getResults().forEach(user -> System.out.println(user));
    }
}
