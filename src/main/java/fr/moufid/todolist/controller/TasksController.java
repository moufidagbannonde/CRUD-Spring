package fr.moufid.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import fr.moufid.todolist.model.Tasks;
import fr.moufid.todolist.repository.TasksRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController

public class TasksController {

    @Autowired
    public TasksRepository tasksRepository ;

    // méthode de création d'une tâche
    @PostMapping("/api/tasks")
      public Tasks createTasks(Tasks task){
        // sauvegarder la tâche ajoutée dans la BDD
        return tasksRepository.save(task);
    }

    // méthode de lecture de toutes les tâches
    @GetMapping("/api/tasks")
       public List<Tasks> readTasks(){
        // chercher toutes les tâches
        return tasksRepository.findAll();
    }

    // méthodes de mise à jour d'une tâche
    @PutMapping("/api/tasks/{id}")
    public Tasks updateTasks(int id, Tasks newTask){
        // récupérer la tâche à modifier grâce à son id
        Tasks upelement = tasksRepository.findById(id).orElseThrow();
        // remplacer son/ses information(s) par la/les nouvelle(s) information(s)
        upelement.setContent(newTask.getContent());
        // sauvegarder la/les nouvelle(s) modification(s)
        return tasksRepository.save(upelement);

    }

    @DeleteMapping("/api/tasks/{id}")
    public void deleteTasks(int id){
        // récupérer la tâche à supprimer au travers de son id
        Tasks supelement =tasksRepository.findById(id).orElseThrow();
        // suppression de l'élément de la BDD.
        tasksRepository.delete(supelement);
    }
}
