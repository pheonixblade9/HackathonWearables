package iot.slalom.com.hackathon;

import android.os.AsyncTask;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


/**
 * Created by fernandog on 3/6/2015.
 */
public class FeedTask extends AsyncTask<String, Void, String> {

    FoodPOJO foodList = null;

    @Override
    protected String doInBackground(String... params) {

        // params comes from the execute() call: params[0] is the url.
        try {
           foodList = GetFoodList();

            OrderPOJO order = new OrderPOJO();
            order.setItem("Hot dog");
            order.setQuantity("1");
            order.setSeatid("03193");
            order.setType("Food");
            CreateOrder(order);
            return null;
        } catch (Exception e) {
            return "Unable to retrieve web page. URL may be invalid.";
        }
    }

    public FoodPOJO GetFoodList() throws IOException, JSONException {
        InputStream is = null;
        JSONObject jsonObject = null;
        try {
            URL url = new URL("https://soundersexperience-developer-edition.na16.force.com/experience/services/apexrest/ordermeta");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //conn.setReadTimeout(30000 /* milliseconds */);
            //conn.setConnectTimeout(45000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            int response = conn.getResponseCode();
            is = conn.getInputStream();
            //String result = readIt(is, 10000);

            BufferedReader streamReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();

            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);

            Gson gson = new Gson();
            FoodPOJO food = gson.fromJson(responseStrBuilder.toString(), FoodPOJO.class);
            return food;
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    public void CreateOrder(OrderPOJO order) throws IOException {
        //OutputStreamWriter printout = null;
        DataOutputStream wr = null;
        StringBuilder responseStrBuilder = null;
      //  String s = null;
        int responseCode = 0;
        try {
            Gson gson = new Gson();
            String json = gson.toJson(order);
            URL url = new URL("https://soundersexperience-developer-edition.na16.force.com/experience/services/apexrest/orders");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
         //   conn.setChunkedStreamingMode(0);
          //  conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
           // conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
           // conn.setRequestProperty("Content-Length", "" + json.length());

            // Starts the query
            conn.connect();

            //printout = new OutputStreamWriter (conn.getOutputStream ());
             wr = new DataOutputStream(conn.getOutputStream ());

            wr.writeBytes(json);

            responseCode = conn.getResponseCode();

            InputStream error = conn.getErrorStream();
          //  BufferedReader streamReader = new BufferedReader(new InputStreamReader(error, "UTF-8"));
           // responseStrBuilder = new StringBuilder();

           // String inputStr;
           // while ((inputStr = streamReader.readLine()) != null)
           //     responseStrBuilder.append(inputStr);

          // s = responseStrBuilder.toString();


        } finally {
            wr.flush ();
            wr.close ();
        }
    }

}
