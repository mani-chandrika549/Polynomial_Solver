import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.math.BigInteger;

public class PolynomialSolver {

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                System.out.println("Please provide JSON input file as argument.");
                return;
            }

            // Read JSON file
            String jsonContent = new String(Files.readAllBytes(Paths.get(args[0])));
            JSONObject input = new JSONObject(jsonContent);

            // Check if "testcases" array exists
            if (input.has("testcases")) {
                JSONArray testcases = input.getJSONArray("testcases");

                for (int t = 0; t < testcases.length(); t++) {
                    JSONObject test = testcases.getJSONObject(t);
                    evaluatePolynomial(test, t + 1);
                }

            } else {
                // Single test case scenario
                evaluatePolynomial(input, 1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void evaluatePolynomial(JSONObject test, int caseNumber) {
        try {
            // Read x_value (default 2 if missing)
            BigInteger x = test.has("x_value")
                    ? new BigInteger(test.getString("x_value"))
                    : BigInteger.valueOf(2);

            JSONObject keys = test.getJSONObject("keys");
            int n = keys.getInt("n"); // number of roots

            BigInteger polyValue = BigInteger.ONE;

            // Multiply (x - root) for every root present
            for (int i = 1; i <= n; i++) {
                String key = String.valueOf(i);
                if (!test.has(key)) continue; // skip missing roots

                JSONObject rootObj = test.getJSONObject(key);
                int base = Integer.parseInt(rootObj.getString("base"));
                String value = rootObj.getString("value");

                // Convert value to decimal BigInteger
                BigInteger root = new BigInteger(value, base);

                // Multiply (x - root)
                polyValue = polyValue.multiply(x.subtract(root));
            }

            // Print only the evaluated constant (absolute value)
            System.out.println("Test Case " + caseNumber + ": " + polyValue.abs());

        } catch (Exception e) {
            System.out.println("Error in test case " + caseNumber);
            e.printStackTrace();
        }
    }
}
