import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class CheckJSON {
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

        // JSON validation
        try {
            Gson gson = new Gson();
            gson.fromJson(json, Object.class);
            System.out.print(gson.fromJson(json, Object.class) + "\n");
            System.out.println("JSON jest poprawny!");
        } catch (JsonSyntaxException e) {
            System.err.println("JSON jest niepoprawny: " + e.getMessage());
            return;
        }
    }
}
