package com.example.viwa;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class ReadJson{

    static ReadJson instance = new ReadJson();


    public static ReadJson getInstance() {
        return instance;
    }


    //Reads Json file and searches the right information from it to show at the info page
    public String read(String jsonText) throws JSONException {
        String json = jsonText;
        String finalText = "";
        String id = "";

        if (json != null) {
            try {
                JSONArray root = new JSONArray(json);

                for (int i=0; i<root.length(); i++){
                    JSONObject data = root.getJSONObject(i);
                    id = data.getString("id");

                    if (id.equals("2271")){
                        JSONObject dataentry2 = data.getJSONObject("description");
                        finalText = dataentry2.getString("fi");
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return finalText;
    }
}
