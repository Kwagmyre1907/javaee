package rayno.javaee.rest;

import rayno.javaee.entity.ToDo;
import rayno.javaee.entity.ToDoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ToDoRest {

    @Inject
    ToDoService toDoService;

    @Path("create")
    @POST
    public Response createToDo(ToDo todo) {
        toDoService.createToDo(todo);
        return Response.ok(todo).build();
    }

    @Path("update")
    @PUT
    public Response updateToDo(ToDo todo) {
        toDoService.updateTodo(todo);
        return Response.ok(todo).build();
    }

    @Path("{id}")
    @GET
    public ToDo getToDo(@PathParam("id") Long id) {
        return toDoService.findToDoById(id);
    }

    @Path("list")
    @GET
    public List<ToDo> getAllToDo() {
        return toDoService.getToDos();
    }

    @Path("done/{id}")
    @POST
    public Response markAsDone(@PathParam("id") Long id) {
        ToDo todo = toDoService.findToDoById(id);
        todo.setCompleted(true);
        toDoService.updateTodo(todo);
        return Response.ok(todo).build();
    }

}
