package fr.moufid.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.moufid.todolist.model.Tasks;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Integer>{
    
}
