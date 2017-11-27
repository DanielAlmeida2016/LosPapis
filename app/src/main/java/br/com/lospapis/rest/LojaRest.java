package br.com.lospapis.rest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.TimeUnit;

import br.com.lospapis.model.Loja;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Daniel Almeida on 12/11/2017.
 */

public class LojaRest {

    public Loja get(String urlBase) throws Exception {

        Loja loja;
        String rs;

        String url = urlBase + "json/jogadores-disponiveis";
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10000, TimeUnit.MILLISECONDS).readTimeout(5000,
                TimeUnit.MILLISECONDS).writeTimeout(5000, TimeUnit.MILLISECONDS).build();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        if (client.connectTimeoutMillis() <= 10000 && client.readTimeoutMillis() <= 5000) {
            rs = new String(response.body().bytes(), "ISO-8859-1");
        } else {
            rs = null;
        }

        Gson gson = new Gson();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(rs);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Type listType = new TypeToken<List<Loja>>(){}.getType();
        loja = gson.fromJson(jsonArray.toString(), listType);

        return loja;
    }
}
