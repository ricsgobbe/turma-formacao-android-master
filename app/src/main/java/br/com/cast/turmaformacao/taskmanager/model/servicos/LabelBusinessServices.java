package br.com.cast.turmaformacao.taskmanager.model.servicos;

import java.util.List;

import br.com.cast.turmaformacao.taskmanager.model.entidade.Label;
import br.com.cast.turmaformacao.taskmanager.model.persistencia.LabelRepository;


/**
 * Created by Administrador on 17/09/2015.
 */
public class LabelBusinessServices {
    private LabelBusinessServices(){
        super();
    }

    public static List<Label> findAll(){
        return LabelRepository.getAll();
    }

    public static void save(Label label){
        LabelRepository.save(label);
    }

    public static void delete(Label selectedLabel) {
        LabelRepository.delete(selectedLabel.getId());
    }
}
