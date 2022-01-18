package rayno.javaee.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;
import java.util.List;

@Transactional
public class ToDoService {

    @PersistenceContext
    EntityManager entityManager;

    public ToDo createToDo(ToDo todo){
        entityManager.persist(todo);
        return todo;
    }

    public ToDo updateTodo(ToDo todo){
        entityManager.merge(todo);
        return todo;
    }

    public ToDo findToDoById(Long id){
        return entityManager.find(ToDo.class, id);
    }

    public List<ToDo> getToDos(){
        return entityManager.createQuery("select t from ToDo t", ToDo.class).getResultList();
    }
}
