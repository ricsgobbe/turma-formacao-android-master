package br.com.cast.turmaformacao.taskmanager.model.servicos;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.turmaformacao.taskmanager.controlers.adapters.TaskListAdapter;
import br.com.cast.turmaformacao.taskmanager.model.entidade.Task;
import br.com.cast.turmaformacao.taskmanager.model.persistencia.LabelRepository;
import br.com.cast.turmaformacao.taskmanager.model.persistencia.TaskRepository;

/**
 * Created by Administrador on 15/09/2015.
 */
public final class TaskBusinessServices {

    private TaskBusinessServices(){
        super();
    }

    public static List<Task> findAll(){

        List<Task> tasks = TaskRepository.getAll();
        for(Task task : tasks){
            task.setLabel(LabelRepository.getById(task.getLabel().getId()));
        }
        return tasks;
    }

    public static void save(Task task){
        TaskRepository.save(task);
    }

    public static void delete(Task selectedTask) {
        TaskRepository.delete(selectedTask.getId());
    }
}
