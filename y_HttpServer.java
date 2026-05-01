// y_HttpServer.java
// Building a basic HTTP server with Java's built-in library (no frameworks)

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public class y_HttpServer {

    public static void main(String[] args) throws IOException {

        // ── 1. CREATE SERVER ON PORT 8080 ──────────────────────────────────
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        //                                                           ↑
        //                                    backlog = 0 means use default queue size

        // ── 2. REGISTER ROUTES (paths → handlers) ──────────────────────────
        server.createContext("/hello",   new HelloHandler());
        server.createContext("/convert", new ConvertHandler());
        // Any request to /hello runs HelloHandler
        // Any request to /convert runs ConvertHandler

        // ── 3. START ────────────────────────────────────────────────────────
        server.setExecutor(null); // null = use default single-threaded executor
        server.start();
        System.out.println("Server running at http://localhost:8080");
        System.out.println("Try: http://localhost:8080/hello");
        System.out.println("Try: http://localhost:8080/convert?from=km&to=miles&value=5");
    }


    // ── HANDLER 1: Simple response ─────────────────────────────────────────
    static class HelloHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            // Only allow GET requests
            if (!exchange.getRequestMethod().equals("GET")) {
                sendResponse(exchange, 405, "Method Not Allowed");
                return;
            }

            String response = "{ \"message\": \"Hello from Java!\" }";
            sendResponse(exchange, 200, response);
        }
    }


    // ── HANDLER 2: With query param parsing ───────────────────────────────
    static class ConvertHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            // Parse query params from the URL
            // URL looks like: /convert?from=km&to=miles&value=5
            String query = exchange.getRequestURI().getQuery();
            // query = "from=km&to=miles&value=5"

            if (query == null) {
                sendResponse(exchange, 400, "{ \"error\": \"Missing query params\" }");
                return;
            }

            Map<String, String> params = parseQuery(query);
            // params = { "from": "km", "to": "miles", "value": "5" }

            String from  = params.get("from");
            String to    = params.get("to");
            String value = params.get("value");

            if (from == null || to == null || value == null) {
                sendResponse(exchange, 400, "{ \"error\": \"Need from, to, and value\" }");
                return;
            }

            try {
                double input  = Double.parseDouble(value);
                double result = convert(from, to, input);
                String json   = String.format("{ \"result\": %.5f }", result);
                sendResponse(exchange, 200, json);
            } catch (NumberFormatException e) {
                sendResponse(exchange, 400, "{ \"error\": \"value must be a number\" }");
            } catch (IllegalArgumentException e) {
                sendResponse(exchange, 400, "{ \"error\": \"" + e.getMessage() + "\" }");
            }
        }

        private double convert(String from, String to, double value) {
            // Normalize everything to a base unit first, then convert out
            // Base units: meters (length), kg (weight), celsius (temp)
            double base = switch (from.toLowerCase()) {
                case "km"    -> value * 1000;
                case "miles" -> value * 1609.344;
                case "m"     -> value;
                case "kg"    -> value;
                case "lb"    -> value * 0.453592;
                case "c"     -> value;
                case "f"     -> (value - 32) * 5.0 / 9.0;
                default -> throw new IllegalArgumentException("Unknown unit: " + from);
            };

            return switch (to.toLowerCase()) {
                case "km"    -> base / 1000;
                case "miles" -> base / 1609.344;
                case "m"     -> base;
                case "kg"    -> base;
                case "lb"    -> base / 0.453592;
                case "c"     -> base;
                case "f"     -> base * 9.0 / 5.0 + 32;
                default -> throw new IllegalArgumentException("Unknown unit: " + to);
            };
        }
    }


    // ── UTILITY: Parse "key=value&key=value" into a Map ───────────────────
    static Map<String, String> parseQuery(String query) {
        Map<String, String> params = new HashMap<>();
        for (String pair : query.split("&")) {       // split by &
            String[] kv = pair.split("=", 2);  // split by = (max 2 parts)
            if (kv.length == 2) {
                params.put(kv[0], kv[1]);
            }
        }
        return params;
    }


    // ── UTILITY: Write HTTP response ───────────────────────────────────────
    static void sendResponse(HttpExchange exchange, int statusCode, String body) throws IOException {
        // Set Content-Type header BEFORE sending response code
        exchange.getResponseHeaders().set("Content-Type", "application/json");

        byte[] bytes = body.getBytes();

        // sendResponseHeaders(statusCode, contentLength)
        // contentLength = how many bytes in the body
        exchange.sendResponseHeaders(statusCode, bytes.length);

        // Write body to the output stream, then close
        OutputStream out = exchange.getResponseBody();
        out.write(bytes);
        out.close();
        // Closing out also closes the exchange
    }
}

/*
 * ─────────────────────────────────────────────
 *  HOW TO TEST (no code needed)
 * ─────────────────────────────────────────────
 *
 *  Option 1 — Browser:
 *    Just paste this in your browser address bar:
 *    http://localhost:8080/hello
 *    http://localhost:8080/convert?from=km&to=miles&value=10
 *
 *  Option 2 — curl (terminal):
 *    curl http://localhost:8080/hello
 *    curl "http://localhost:8080/convert?from=km&to=miles&value=10"
 *
 *  Option 3 — Postman / Insomnia (GUI tools, good for POST requests later)
 *
 * ─────────────────────────────────────────────
 *  KEY THINGS TO REMEMBER
 * ─────────────────────────────────────────────
 *
 *  exchange.getRequestURI().getQuery()  → gives you the ?key=value string
 *  exchange.getRequestMethod()          → "GET", "POST", etc.
 *  exchange.getRequestBody()            → InputStream for POST body
 *  exchange.getResponseHeaders()        → set headers before sendResponseHeaders()
 *  exchange.sendResponseHeaders(code, length) → must call BEFORE writing body
 *  exchange.getResponseBody()           → OutputStream to write your response
 *
 *  Always close the OutputStream when done — otherwise client hangs waiting.
 */
