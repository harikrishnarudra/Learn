package Interviews.delphix;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * https://api-v3.mbta.com/docs/swagger/index.html#/Prediction/ApiWeb_PredictionController_index
 * https://api-v3.mbta.com/predictions/?filter[stop]=place-pktrm&sort=departure_time&include=route&page[offset]=0&page[limit]=10
 *
 *
 * https://app.coderpad.io/NQGRT9AA
 *
 * Your previous Plain Text content is preserved below:
 *
 * ===== Preface =====
 *
 * This question is very difficult in C and C++, where there is
 * insufficient library support to answer it in an hour. If you
 * prefer to program in one of those languages, please ask us to
 * provide you with a question designed for those languages instead!
 *
 * ===== Intro =====
 *
 * The Delphix Boston office is located in Boston’s financial district.
 * MBTA (Massachusetts Bay Transportation Authority) is a public
 * transportation system serving the Massachusetts Bay area.  Many
 * engineers in the Boston office use the Park Street Station to get to/from
 * the office.
 *
 * As engineers in the office will tell you, the MBTA system is
 * infamously off schedule. Luckily, the MBTA public API
 * (https://www.mbta.com/developers/v3-api) has a real-time information
 * feed containing information about real-time estimated departures for
 * specific stations. Your goal is to write a small program that utilizes
 * the MBTA API that will quickly tell :
 * - The current time
 * - The next 10 trains leaving Park Street Station
 * - Where they are going (destination town/city)
 * - Minutes until scheduled departure
 *
 *
 * Rules/constraints:
 *
 * - Print the trains grouped by which line they are using, and in the
 *   order that they are leaving the station
 * - Limit the number of trains printed to the 10 trains next leaving
 *   the station. Do not print trains that have already left the station (negative departure time).
 * - Print the number of minutes until the scheduled departure time.
 * - Print the destination town/city of each train
 * - You can use any standard or third party libraries available in coderpad.
 *
 * Example output:
 *
 * ```
 * <Current Time>
 * ----Red Line----
 * Ashmont/Braintree: Departing in 3 minutes
 * Alewife: Departing in 5 minutes
 * Ashmont/Braintree: Departing in 9 minutes
 *
 * ----Green Line C----
 * North Station: Departing in 4 minutes
 * Cleveland Circle: Departing in 6 minutes
 *
 * ----Green Line E----
 * North Station: Departing in 4 minutes
 * Heath Street: Departing in 5 minutes
 *
 * ----Green Line D----
 * Riverside: Departing in 5 minutes
 * Government Center: Departing in 7 minutes
 *
 * ----Green Line B----
 * Park Street: Departing in 6 minutes
 *
 * ```
 *
 * Your output does not need to match this, this is just an example.
 * If you have better ideas of how to display the data, please do!
 * Just include the required information.
 *
 * You should implement this in whatever language you're most
 * comfortable with. Consider this to be production level code and
 * should include, but not limited to, exception handling, error
 * checking, and diagnostic/logging information. You should consider
 * execution performance, memory consumption, and general efficiency
 * in your design.
 *
 * Finally, please help us by keeping this question and your
 * answer secret so that every candidate has a fair chance in
 * future Delphix interviews.
 *
 *
 * ===== Steps =====
 *
 * 1.  Choose the language you want to code in from the menu
 *     labeled "Plain Text" in the top right corner of the
 *     screen. You will see a "Run" button appear on the top
 *     left -- clicking this will send your code to a Linux
 *     server and compile / run it. Output will appear on the
 *     right side of the screen.
 *
 *     For information about what libraries are available for
 *     your chosen language, see:
 *
 *       https://coderpad.io/languages
 *
 * 2.  Pull up the documentation for the API you'll be using:
 *
 *       https://api-v3.mbta.com/docs/swagger/index.html#/Prediction/ApiWeb_PredictionController_index
 *
 *       https://www.mbta.com/developers/v3-api
 *
 * 3.  Since the above API doesn’t have the name of the routes,
 *     or the destination name we are interested in, you’ll want
 *     to include Route Relationships in the query. To help you save
 *     time figuring out the stop to filter over, use "place-pktrm".
 *     This is the MBTA's id for the Park Street Station.
 *
 *     Suggested parameters for the API call:
 *
 *     include=route -- Used to get additional route information
 *
 *     filter[stop]=place-pktrm -- Used to filter the data to Park
 *       Street Station
 *
 *     sort=departure_time -- Used to sort by 'departure_time' instead
 *       of the default 'arrival_time'
 *
 *     Tip: You can refer following endpoint for getting required data (feel free to modify it as per your need and optimization):
 *     https://api-v3.mbta.com/predictions/?filter[stop]=place-pktrm&sort=departure_time&include=route
 *
 * 4.  Implement the functionality described above, using data
 *     fetched dynamically from the MBTA API endpoint here:
 *
 *       https://api-v3.mbta.com/predictions
 *
 * 5.  Writing tests for your code is optional. If you do write tests for your code,
 *     add them to the main() method of your program so that we can easily run them.
 *
 *
 * ====== FAQs =====
 *
 * Q:  What if the API doesn't return any trains? How do I test my code?
 * A:  You can use the attached file with a sample response. You'll need
 *     to use a timestamp of 2021_05_11 17:15:00 UTC-4 as the current time
 *     in order to get 'realistic' arrival times. It's path is:
 *     /home/coderpad/data/VaaP_MBTA_Departures_2021_05_11T5_15_00.txt
 *
 * Q:  How do I turn in my solution?
 * A:  Anything you've typed into this document will be saved.
 *     If you were given a Takehome question, there should be a Submit
 *     Button in the bottom right of the coderpad page. If you do not
 *     see such a button, feel free to email us when you are done with
 *     your solution. We will respond confirming we've received the
 *     solution within 24 hours.
 *
 * Q:  What timezone does the MBTA API use?
 * A:  They use UTC-4. For your solution, it would make the most sense
 *     to compare arrival times in the same time zone.
 *
 * Q:  What does a direction_id of 0 or 1 mean?
 * A:  This is used as a key to identify which direction (0 or 1) the
 *     train is headed in. You can use this key with the
 *     direction_destinations in the included route data to find the
 *     destination of the train.
 *
 * Q:  How do I know if my solution is correct?
 * A:  Make sure you've read the assignment carefully and you're
 *     convinced your program does what you think it should
 *     in the common case. If your program does what the assignment
 *     dictates, you will get full credit. We do not use an
 *     auto-grader, so we do not have any values for you to
 *     check correctness against.
 *
 * Q:  What is Delphix looking for in a solution?
 * A:  After submitting your code, we'll have a pair of engineers
 *     evaluate it and determine next steps in the interview process.
 *     We are looking for correct, easy-to-read, robust code.
 *     Specifically, ensure your code is idiomatic and laid out
 *     logically. Ensure it is correct. Ensure it handles all edge
 *     cases and error cases elegantly.
 *
 * Q:  If I need a clarification, who should I ask?
 * A:  Send all questions to the email address that sent you
 *     this document, and an engineer at Delphix will get
 *     back to you ASAP (we're pretty quick during normal
 *     business hours).
 *
 * Q:  How long should this question take me?
 * A:  Approximately 1 hour, but it could take more or less
 *     depending on your experience with web APIs and the
 *     language you choose.
 *
 * Q:  When is this due?
 * A:  We will begin grading your answer 24 hours after it is
 *     sent to you, so that is the deadline.
 *
 * Q:  Can I use any external resources to help me?
 * A:  Absolutely! Feel free to use any online resources you
 *     like, but please don't collaborate with anyone else.
 *
 * Q:  Can I use my favorite library in my program?
 * A:  Unfortunately, there is no way to load external
 *     libraries into CoderPad, so you must stick to what
 *     they provide out of the box for your language (although
 *     they do support for many popular general-use libraries):
 *
 *       https://coderpad.io/languages
 *
 *     If you really want to use something that's not
 *     available, email the person who sent you this link
 *     and we will work with you to find a solution.
 *
 * Q: Can I code this up in a different IDE?
 * A: Of course! However, we do not have your environment
 *    to run your code in. We ask that you submit your final
 *    code via CoderPad (and make sure it can run). This gives
 *    our graders the ability to run your code rather than guessing.
 *
 * Q:  Why does my program terminate unexpectedly in
 *     CoderPad, and why can't I read from stdin or pass
 *     arguments on the command line?
 * A:  CoderPad places a limit on the runtime and amount of
 *     output your code can use, but you should be able to
 *     make your code fit within those limits. You can hard
 *     code any arguments or inputs to the program in your
 *     main() method or in your tests.
 *
 * Q:  I'm a Vim/Emacs fan -- is there any way to use those
 *     keybindings? What about changing the tab width? Font
 *     size?
 * A:  Yes! Hit the button at the bottom of the screen that
 *     looks like a keyboard.
 *
 *
 *
 */
public class Departures {

    public String prepareRequest(final String url, final String stop, final String sort, final String include,
                               final String pageOffset, final String pageLimit){
        StringBuilder stringBuilder = new StringBuilder(url);
        stringBuilder.append("?");
        stringBuilder.append("filter[stop]="+stop);
        stringBuilder.append("&");
        stringBuilder.append("sort=" + sort);
        stringBuilder.append("&");
        stringBuilder.append("include=" + include);
        stringBuilder.append("&");
        stringBuilder.append("page[offset]=" + pageOffset);
        stringBuilder.append("&");
        stringBuilder.append("page[limit]=" + pageLimit);
        return stringBuilder.toString();
//        "https://api-v3.mbta.com/predictions/?filter[stop]=place-pktrm&sort=departure_time&include=route&page[offset]=0&page[limit]=10"
    }

    public static void main(String[] args) throws IOException {
        Departures d = new Departures();
        String urlPrepared = d.prepareRequest("https://api-v3.mbta.com/predictions/","place-pktrm","departure_time","route", "0", "10");
        ClientRequest c = new ClientRequest();
        String s = c.makeRequest(urlPrepared);
        Processor p = new Processor();
        p.processText(s);
    }

}
class ClientRequest{
    public String makeRequest(String requestUrl) throws IOException {
        System.out.println(requestUrl);
        URL url = new URL(requestUrl);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        httpsURLConnection.setRequestProperty("accept","application/json");
        InputStream response = httpsURLConnection.getInputStream();
        String text = new String(response.readAllBytes(), StandardCharsets.UTF_8);
        System.out.println(text);
        return text;
    }
}

class Processor{
    public void processText(final String data){
        JsonParser parser = new JsonParser();
        Object jsonObj = parser.parse(data);

        JsonObject jsonObject = (JsonObject) jsonObj;

        JsonArray departures = (JsonArray) jsonObject.get("data");
        @SuppressWarnings("unchecked")
        Iterator<JsonElement> it = departures.iterator();
        while (it.hasNext()) {
            JsonElement datum = it.next();
            JsonObject jsonObject1 = datum.getAsJsonObject();
            JsonElement attributes = jsonObject1.get("attributes");
            System.out.println(String.format("attributes = %s", attributes));
        }

        /*String firstName = (String) nameObj.get("first_name");
        String lastName = (String) nameObj.get("last_name");
        System.out.println(String.format("Name = %s %s", firstName, lastName));

        long age = (Long) jsonObject.get("age");
        System.out.println(String.format("Age = %d", age));

        JSONArray cities = (JSONArray) jsonObject.get("cities");*/

    }
}
