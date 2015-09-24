package br.com.cast.turmaformacao.taskmanager.model.http;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import br.com.cast.turmaformacao.taskmanager.model.entidade.Address;
import br.com.cast.turmaformacao.taskmanager.model.entidade.Task;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrador on 24/09/2015.
 */
public final class TaskServices {

    private static final String URL = "http://10.11.21.193:3000/api/v1/";

    public TaskServices() {
        super();
    }

    public static List<Task> getTaskById(String id){
        List<Task> task = new ArrayList<>();
        try {
            URL url = new URL(URL + id);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            /*exec requisicao*/
            int responseCode = conn.getResponseCode();
            Log.i("getTaskById", "Codigo de retorno da requisicao da task: " + responseCode);
            if(responseCode == HttpURLConnection.HTTP_OK){
                /*Trabalha com envio e recebimento de arquivo, ou seja, manipulacao de arquivo*/
                InputStream inputStream = conn.getInputStream();
                /*Converter o inputStream para Json*/
                /*biblioteca raiz, que pegara o Json*/
                ObjectMapper objectMapper = new ObjectMapper();
                CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, Task.class);
                task = objectMapper.readValue(inputStream, collectionType);

            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return task;
    }
}
