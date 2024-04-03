import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

public class CheckJSON {
    public boolean jsonValidation(String json) {
        try {
            Gson gson = new Gson();
            gson.fromJson(json, Object.class);
//            System.out.print(gson.fromJson(json, Object.class) + "\n");
            System.out.println("JSON jest poprawny!");
            return true;
        } catch (JsonSyntaxException e) {
            System.err.println("JSON jest niepoprawny: " + e.getMessage());
            return false;
        }
    }
    public boolean isContainsSingleAsterisk(JsonObject convertedObject) {
        try {
            String resource = convertedObject.get("PolicyDocument")
                    .getAsJsonObject()
                    .get("Statement")
                    .getAsJsonArray()
                    .get(0)
                    .getAsJsonObject()
                    .get("Resource")
                    .getAsString();

//            System.out.println(resource); // Oczekiwane: "*"
            return resource.equals("*");

        } catch (Exception e) {
            System.err.println("\nNie odnaleziono Resource w JSON lub wykryto niepoprawną strukturę danych: " + e.getMessage());
            return false;
        }
    }
    public static void main(String[] args) {
        String json = """
                {
                    "PolicyName": "root",
                    "PolicyDocument": {
                        "Version": "2012-10-17",
                        "Statement": [
                            {
                                "Sid": "IamListAccess",
                                "Effect": "Allow",
                                "Action": [
                                    "iam:ListRoles",
                                    "iam:ListUsers"
                                ],
                                "Resource": "*"
                            }
                        ]
                    }
                }
                """;

        CheckJSON check = new CheckJSON();
        boolean isJasonValid = check.jsonValidation(json);
        if(isJasonValid) {
            Gson gson = new Gson();
            JsonObject convertedObject = gson.fromJson(json, JsonObject.class);
            boolean result = check.isContainsSingleAsterisk(convertedObject);
            if(result) System.out.print("true");
            else System.out.print("false");
        } else {
            System.out.print("false");
        }
    }
}
