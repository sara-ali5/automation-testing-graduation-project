package Utilities;

import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class TestDataProvider {

    @DataProvider(name = "invalidLogin")
    public static Object[][] invalidLogin() {

        JsonNode invalidLogins =
                JsonDataReader.getRoot()
                        .get("invalidLogin");

        List<Object[]> data = new ArrayList<>();

        for (JsonNode login : invalidLogins) {

            String username =
                    login.get("username").asText();

            String password =
                    login.get("password").asText();

            data.add(new Object[]{
                    username,
                    password
            });
        }

        return data.toArray(new Object[0][]);
    }
}