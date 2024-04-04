import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.Test;
import static org.junit.Assert.*;

public class CheckJSONTest {
    @Test
    public void testValidJson() {
        String validJson = "{ \"PolicyName\": \"testPolicy\", \"PolicyDocument\": {} }";
        assertTrue(new CheckJSON().jsonValidation(validJson));
    }

    @Test
    public void testIsContainsAsterisk_withAsterisk() {
        Gson gson = new Gson();
        String jsonWithAsterisk = "{ \"PolicyDocument\": { \"Statement\": [{\"Resource\": \"*\"}]}}";
        JsonObject obj = gson.fromJson(jsonWithAsterisk, JsonObject.class);
        assertTrue(new CheckJSON().isContainsSingleAsterisk(obj));
    }

    @Test
    public void testIsContainsAsterisk_withoutAsterisk() {
        Gson gson = new Gson();
        String jsonWithoutAsterisk = "{ \"PolicyDocument\": { \"Statement\": [{\"Resource\": \"example\"}]}}";
        JsonObject obj = gson.fromJson(jsonWithoutAsterisk, JsonObject.class);
        assertFalse(new CheckJSON().isContainsSingleAsterisk(obj));
    }

    @Test
    public void testIsContainsAsterisk_missingResource() {
        Gson gson = new Gson();
        String jsonMissingResource = "{ \"PolicyDocument\": { \"Statement\": [{}]}}";
        JsonObject obj = gson.fromJson(jsonMissingResource, JsonObject.class);

        boolean result = new CheckJSON().isContainsSingleAsterisk(obj);
        assertFalse(result);
    }

    @Test
    public void testMissingPolicyDocument() {
        CheckJSON checkJSON = new CheckJSON();
        String invalidJson = "{ \"PolicyName\": \"test-policy\" }";  // Brak PolicyDocument
        assertFalse(checkJSON.jsonValidation(invalidJson));
    }

    @Test
    public void testJsonValidation_ValidJson() {
        String validJson = "{ \"PolicyName\": \"testPolicy\", \"PolicyDocument\": {} }";
        assertTrue(new CheckJSON().jsonValidation(validJson));
    }

    @Test
    public void testJsonValidation_InvalidJson() {
        String invalidJson = "{ key: \"value\" }";
        assertFalse(new CheckJSON().jsonValidation(invalidJson));
    }

    @Test
    public void testJsonValidation_MissingPolicyDocument() {
        String json = "{ \"PolicyName\": \"testPolicy\" }";
        assertFalse(new CheckJSON().jsonValidation(json));
    }

    @Test
    public void testJsonValidation_MissingPolicyName() {
        String json = "{ \"PolicyDocument\": {} }";
        assertFalse(new CheckJSON().jsonValidation(json));
    }

    @Test
    public void testJsonValidation_InvalidPolicyName() {
        String json = "{ \"PolicyName\": \"\", \"PolicyDocument\": {} }";
        assertFalse(new CheckJSON().jsonValidation(json));
    }

    @Test
    public void testJsonValidation_PolicyNameLengthExceedsMaximum() {
        String policyName = "a".repeat(129); // String with length 129
        String json = String.format("{ \"PolicyName\": \"%s\", \"PolicyDocument\": {} }", policyName);
        assertFalse(new CheckJSON().jsonValidation(json));
    }
}