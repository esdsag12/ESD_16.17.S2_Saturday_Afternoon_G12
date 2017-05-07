package com.app.esd.esd.Modals.ServicesModals;

import android.os.AsyncTask;
import android.widget.Toast;

import com.app.esd.esd.Const.AppConst;
import com.app.esd.esd.Interface.OxfordPronuncationListener;
import com.app.esd.esd.Modals.ApiModals.OxfordObject;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by ciqaz on 5/7/17.
 */

public class OxfordPronunciationService extends AsyncTask<String, Integer, String> {
    OxfordPronuncationListener oxfordPronuncationListener;
    public OxfordPronunciationService(OxfordPronuncationListener oxfordPronuncationListener){
        this.oxfordPronuncationListener=oxfordPronuncationListener;
    }
    private String dictionaryEntries(String word) {
        final String language = "en";
        final String word_id = word.toLowerCase(); //word id is case sensitive and lowercase is required
        return "https://od-api.oxforddictionaries.com:443/api/v1/entries/" + language + "/" + word_id;
    }
    @Override
    protected String doInBackground(String... params) {

        //TODO: replace with your own app id and app key

        try {
            URL url = new URL(dictionaryEntries(params[0]));
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("app_id", AppConst.APP_ID);
            urlConnection.setRequestProperty("app_key", AppConst.API_KEY);

            // read the output from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

            return stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Gson gson = new Gson();
        OxfordObject oxfordObject = gson.fromJson(result, OxfordObject.class);
        oxfordPronuncationListener.onOxfordPronuncationListenerSuccess(oxfordObject);
    }
}
