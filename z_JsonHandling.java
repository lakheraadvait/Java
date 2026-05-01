// z_JsonHandling.java
// Working with JSON in Java — manually (no libraries) and with Gson

/*
 * ─────────────────────────────────────────────
 *  WHAT IS JSON?
 * ─────────────────────────────────────────────
 *  JSON = JavaScript Object Notation
 *  It's just a text format for structured data. Every API uses it.
 *
 *  { "name": "Advait", "age": 18, "active": true }
 *   ↑ object    ↑ string    ↑ number   ↑ boolean
 *
 *  [ "km", "miles", "feet" ]   ← array
 *
 *  { "user": { "name": "Advait" }, "scores": [10, 20] }  ← nested
 *
 * ─────────────────────────────────────────────
 *  OPTION A: Build JSON manually (no library)
 *  Good for: simple responses, no dependencies
 * ─────────────────────────────────────────────
 */

public class z_JsonHandling {

    public static void main(String[] args) {

        // ── BUILDING JSON STRINGS MANUALLY ────────────────────────────────

        // Simple object
        String name  = "Advait";
        int    score = 42;
        String json1 = String.format("{ \"name\": \"%s\", \"score\": %d }", name, score);
        System.out.println(json1);
        // { "name": "Advait", "score": 42 }

        // Using StringBuilder for bigger objects
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("  \"from\": \"km\",\n");
        sb.append("  \"to\": \"miles\",\n");
        sb.append(String.format("  \"result\": %.5f\n", 3.10686));
        sb.append("}");
        System.out.println(sb);

        // Building a JSON array manually
        String[] units   = {"km", "miles", "feet", "meters"};
        StringBuilder arr = new StringBuilder("[");
        for (int i = 0; i < units.length; i++) {
            arr.append("\"").append(units[i]).append("\"");
            if (i < units.length - 1) arr.append(", ");
        }
        arr.append("]");
        System.out.println(arr);
        // ["km", "miles", "feet", "meters"]


        // ── PARSING JSON MANUALLY (simple cases) ──────────────────────────
        // Only practical for very flat, predictable JSON
        // For anything real, use a library (see below)

        String incoming = "{ \"value\": \"5\", \"from\": \"km\", \"to\": \"miles\" }";

        // Crude extraction — fine for learning, not production
        String value = extractValue(incoming, "value");
        String from  = extractValue(incoming, "from");
        System.out.println("value=" + value + " from=" + from);


        // ── OPTION B: Using Gson (Google's library) ────────────────────────
        // Add to your project: https://mvnrepository.com/artifact/com.google.code.gson/gson
        // In IntelliJ: File → Project Structure → Libraries → + → Maven → search gson

        /*
         *  import com.google.gson.Gson;
         *  import com.google.gson.JsonObject;
         *  import com.google.gson.JsonParser;
         *
         *  Gson gson = new Gson();
         *
         *  // Java object → JSON string
         *  ConversionResult result = new ConversionResult("km", "miles", 3.10686);
         *  String json = gson.toJson(result);
         *  // {"from":"km","to":"miles","result":3.10686}
         *
         *  // JSON string → Java object
         *  ConversionResult parsed = gson.fromJson(json, ConversionResult.class);
         *  System.out.println(parsed.result); // 3.10686
         *
         *  // JSON string → flexible JsonObject (when you don't have a class)
         *  JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
         *  String from = obj.get("from").getAsString();
         *  double res  = obj.get("result").getAsDouble();
         */

        System.out.println("\nFor the Unit Converter project, manual JSON is fine.");
        System.out.println("Use Gson when responses get more complex (Todo API, Blog API).");
    }


    // ── Crude manual JSON value extractor (learning purposes only) ─────────
    static String extractValue(String json, String key) {
        // Finds "key": "value" and returns value
        // Does NOT handle nested objects, arrays, or numbers properly
        String search = "\"" + key + "\": \"";
        int start = json.indexOf(search);
        if (start == -1) return null;
        start += search.length();
        int end = json.indexOf("\"", start);
        return json.substring(start, end);
    }
}

/*
 * ─────────────────────────────────────────────
 *  CHEAT SHEET
 * ─────────────────────────────────────────────
 *
 *  Manual JSON building:
 *    String.format("{ \"key\": \"%s\" }", value)   ← string values
 *    String.format("{ \"key\": %d }", value)        ← number values
 *    String.format("{ \"key\": %.2f }", value)      ← float, 2 decimal places
 *
 *  Escape rules inside JSON strings:
 *    \"  →  literal quote character
 *    \\  →  literal backslash
 *    \n  →  newline (avoid in JSON values)
 *
 *  With Gson (once you add the dependency):
 *    gson.toJson(object)              → object to JSON string
 *    gson.fromJson(string, Foo.class) → JSON string to object
 *    JsonParser.parseString(s)        → parse without a class
 *      .getAsJsonObject()
 *      .get("key").getAsString()
 *      .get("key").getAsDouble()
 *      .get("key").getAsInt()
 *
 *  Content-Type header for JSON responses:
 *    exchange.getResponseHeaders().set("Content-Type", "application/json");
 */
