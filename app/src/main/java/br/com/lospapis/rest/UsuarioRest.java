package br.com.lospapis.rest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.TimeUnit;

import br.com.lospapis.model.Loja;
import br.com.lospapis.model.Usuario;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Daniel Almeida on 12/11/2017.
 */

public class UsuarioRest {

    public Usuario get(String urlBase, String usuarioS, String senha) throws Exception {

        Usuario usuario;

        String rs;

        String url = urlBase + "login/{" + usuarioS + "}/{" + senha + "}";
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
        Type listType = new TypeToken<List<Usuario>>() {
        }.getType();
        usuario = gson.fromJson(jsonArray.toString(), listType);

        return usuario;
    }
}
