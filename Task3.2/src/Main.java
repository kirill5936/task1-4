import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {
        JSONObject tests = new JSONObject(new String(Files.readAllBytes(Paths.get("tests.json"))));
        JSONArray values = new JSONObject(new String(Files.readAllBytes(Paths.get("values.json")))).getJSONArray("values");
        updateTestValues(tests.getJSONArray("tests"), values);
        Files.write(Paths.get("report.json"), tests.toString(4).getBytes());
    }

    private static void updateTestValues(JSONArray tests, JSONArray values) {
        for (int i = 0; i < tests.length(); i++) {
            JSONObject test = tests.getJSONObject(i);
            test.put("value", findValueById(values, test.getInt("id")));
            if (test.has("values")) updateTestValues(test.getJSONArray("values"), values);
        }
    }

    private static String findValueById(JSONArray values, int id) {
        for (int i = 0; i < values.length(); i++) {
            if (values.getJSONObject(i).getInt("id") == id) return values.getJSONObject(i).getString("value");
        }
        return "";
    }
}
