package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class jsonReader {
    public static String[] getUserCredentials(String userType) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/test/resources/testdata/credentials.json");
            JsonNode root = mapper.readTree(file);
            JsonNode node = root.get(userType);
            String username = node.get("username").asText();
            String password = node.get("password").asText();
            return new String[]{username, password};
        } catch (IOException e) {
            throw new RuntimeException("JSON read error: " + e.getMessage());
        }
    }
}
