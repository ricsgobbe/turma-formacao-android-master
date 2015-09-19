package br.com.cast.turmaformacao.taskmanager;

import android.app.Application;

import br.com.cast.turmaformacao.taskmanager.util.ApplicationUtil;

/**
 * Created by Administrador on 16/09/2015.
 */
public class TaskManagerApplication extends Application {
    /*Application usado para manipular todo o ciclo de vida do projeto*/

    public void onCreate(){
        super.onCreate();
        ApplicationUtil.setContext(getApplicationContext());
    }
}
