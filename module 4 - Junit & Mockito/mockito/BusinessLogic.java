package mockito;

import java.util.ArrayList;
import java.util.List;

public class BusinessLogic {
    private DataService dataService;

    public BusinessLogic(DataService dataService) {
        this.dataService = dataService;
    }

    public List<String> retrieveTodosRelatedToJava(String user) {
        List<String> filteredTodos = new ArrayList<>();
        List<String> allTodos = dataService.retrieveTodos(user);

        for (String todo : allTodos) {
            if (todo.contains("Java")) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void deleteTodosNotRelatedToJava(String user) {
        List<String> allTodos = dataService.retrieveTodos(user);
        for (String todo : allTodos) {
            if (!todo.contains("Java")) {
                dataService.deleteTodo(user, todo);
            }
        }
    }
}
