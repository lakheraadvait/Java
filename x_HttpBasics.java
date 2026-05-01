// x_HttpBasics.java
// How HTTP works - the mental model before writing any code

/*
 * ─────────────────────────────────────────────
 *  WHAT IS HTTP?
 * ─────────────────────────────────────────────
 *  HTTP = HyperText Transfer Protocol
 *  It's just a text-based conversation between a CLIENT and a SERVER.
 *
 *  CLIENT (browser / your code)  →  sends a REQUEST
 *  SERVER (your Java program)    →  sends back a RESPONSE
 *
 *  Every HTTP exchange has two parts:
 *    1. REQUEST  — "Hey server, give me /convert?from=km&to=miles&value=5"
 *    2. RESPONSE — "Sure, here's your JSON: { "result": 3.10686 }"
 *
 * ─────────────────────────────────────────────
 *  ANATOMY OF A REQUEST
 * ─────────────────────────────────────────────
 *
 *  GET /convert?from=km&to=miles&value=5 HTTP/1.1
 *  Host: localhost:8080
 *
 *  Breaking it down:
 *  ┌─────────┬──────────────────────────────────────────────────┐
 *  │ METHOD  │ GET = "just give me data, I'm not sending any"   │
 *  │         │ POST = "I'm sending data to you"                 │
 *  │         │ PUT = "update this"  DELETE = "remove this"      │
 *  ├─────────┼──────────────────────────────────────────────────┤
 *  │ PATH    │ /convert  ← the "endpoint" or "route"           │
 *  ├─────────┼──────────────────────────────────────────────────┤
 *  │ PARAMS  │ ?from=km&to=miles&value=5                        │
 *  │         │ everything after ? are "query parameters"        │
 *  │         │ key=value pairs separated by &                   │
 *  └─────────┴──────────────────────────────────────────────────┘
 *
 * ─────────────────────────────────────────────
 *  ANATOMY OF A RESPONSE
 * ─────────────────────────────────────────────
 *
 *  HTTP/1.1 200 OK                       ← status line
 *  Content-Type: application/json        ← headers
 *
 *  { "result": 3.10686 }                 ← body
 *
 *  Common status codes:
 *  200 = OK (success)
 *  400 = Bad Request (you sent something wrong)
 *  404 = Not Found (that path doesn't exist)
 *  500 = Internal Server Error (your server crashed)
 *
 * ─────────────────────────────────────────────
 *  HOW JAVA'S BUILT-IN HTTP SERVER WORKS
 * ─────────────────────────────────────────────
 *
 *  Java has com.sun.net.httpserver — no libraries needed.
 *
 *  You:
 *    1. Create a server on a port (8080 is convention for local dev)
 *    2. Register "handlers" — one per route/path
 *    3. Start the server → it listens forever
 *
 *  When a request comes in to that path, your handler runs.
 *  You read the request, write a response. Done.
 *
 *  PORT = a numbered "door" on your machine
 *  localhost:8080 = "this machine, door 8080"
 *  You can test it in your browser or with a tool like curl.
 */

public class x_HttpBasics {
    public static void main(String[] args) {
        // This file is theory only — see y_HttpServer.java for the actual code
        System.out.println("Read the comments above!");
    }
}
