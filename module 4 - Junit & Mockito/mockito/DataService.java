package mockito;

import java.util.List;

public interface DataService {
    List<String> retrieveTodos(String user);
    void addTodo(String user, String todo);
    void deleteTodo(String user, String todo);
}
