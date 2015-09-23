package br.com.cast.turmaformacao.taskmanager.model.http;


import android.util.Log;

import br.com.cast.turmaformacao.taskmanager.model.entidade.Address;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * Created by Administrador on 23/09/2015.
 */
public final  class CepServices {

    private static final String URL = "http://correiosapi.com/cep/";

    private CepServices() {
        super();
    }

    public Address getAddresByCep(String zipCode){
        Address adress = null;
        try {
            /*configura a requisicao*/
            URL url = new URL(URL + zipCode);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            /*exec requisicao*/
            int responseCode = conn.getResponseCode();
            Log.i("getAddressByCep", "Codigo de retorno da requisicao de cep" + responseCode);
            if(responseCode == HttpURLConnection.HTTP_OK){
                /*Trabalha com envio e recebimento de arquivo, ou seja, manipulacao de arquivo*/
                InputStream inputStream = conn.getInputStream();
                /*Converter o inputStream para Json*/
            }

        } catch (Exception e) {
            /*msg do logcat*/
            Log.e(CepServices.class.getName(), e.getMessage());
        }
        return adress;
    }

}
