package Utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class JsonDataReader {

    private static JsonNode root;

    static {

        try {

            InputStream input =
                    JsonDataReader.class
                            .getClassLoader()
                            .getResourceAsStream("testData.json");

            if (input == null) {
                throw new RuntimeException(
                        "testData.json not found"
                );
            }

            ObjectMapper mapper = new ObjectMapper();

            root = mapper.readTree(input);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Failed to read testData.json",
                    e
            );
        }
    }

    public static String get(
            String object,
            String field) {

        return root
                .get(object)
                .get(field)
                .asText();
    }

    public static JsonNode getRoot() {
        return root;
    }
}