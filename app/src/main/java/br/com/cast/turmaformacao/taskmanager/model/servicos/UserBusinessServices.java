package br.com.cast.turmaformacao.taskmanager.model.servicos;

import java.util.List;

import br.com.cast.turmaformacao.taskmanager.model.entidade.User;
import br.com.cast.turmaformacao.taskmanager.model.persistencia.TaskRepository;
import br.com.cast.turmaformacao.taskmanager.model.persistencia.UserRepository;

/**
 * Created by Administrador on 22/09/2015.
 */
public class UserBusinessServices{
    private UserBusinessServices() {
        super();
    }

    public static List<User> findAll(){
        return UserRepository.getAll();
    }

    public static void save(User user){
        UserRepository.save(user);
    }

    public static void delete(User user){
        UserRepository.delete(user.getId());
    }
}
