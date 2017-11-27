package br.com.lospapis.util;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by arqdsis on 27/11/2017.
 */

public class TesteConectividade {

    public static boolean isConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null &&
                connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
