package mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify; // Import for verify

public class BusinessLogicTest {

    @Test
    void testRetrieveTodosRelatedToJava() {
        // Exercise 1: Mocking and Stubbing

        // 1. Mock the dependency (DataService)
        DataService dataServiceMock = mock(DataService.class);

        // 2. Stub the method: Define behavior for retrieveTodos()
        List<String> todos = Arrays.asList("Learn Java", "Spring Framework", "Write unit tests in Java", "Go shopping");
        when(dataServiceMock.retrieveTodos("Dhanush")).thenReturn(todos);

        // 3. Create the System Under Test (BusinessLogic) with the mocked dependency
        BusinessLogic businessLogic = new BusinessLogic(dataServiceMock);

        // 4. Act: Call the method to be tested
        List<String> javaTodos = businessLogic.retrieveTodosRelatedToJava("Dhanush");

        // 5. Assert: Verify the result
        assertEquals(2, javaTodos.size(), "Should return 2 Java-related todos");
        assertEquals("Learn Java", javaTodos.get(0));
        assertEquals("Write unit tests in Java", javaTodos.get(1));
    }

    @Test
    void testDeleteTodosNotRelatedToJava() {
        // Exercise 2: Verifying Interactions

        // 1. Mock the dependency (DataService)
        DataService dataServiceMock = mock(DataService.class);

        // 2. Stub the method: Define behavior for retrieveTodos()
        List<String> todos = Arrays.asList("Learn Java", "Spring Framework", "Write unit tests in Java", "Go shopping");
        when(dataServiceMock.retrieveTodos("Dhanush")).thenReturn(todos);

        // 3. Create the System Under Test (BusinessLogic) with the mocked dependency
        BusinessLogic businessLogic = new BusinessLogic(dataServiceMock);

        // 4. Act: Call the method that interacts with the mock
        businessLogic.deleteTodosNotRelatedToJava("Dhanush");

        // 5. Verify: Check if deleteTodo was called for non-Java todos
        verify(dataServiceMock).deleteTodo("Dhanush", "Spring Framework");
        verify(dataServiceMock).deleteTodo("Dhanush", "Go shopping");
        
        // Verify that deleteTodo was called exactly two times for any String arguments
        verify(dataServiceMock, Mockito.times(2)).deleteTodo(Mockito.anyString(), Mockito.anyString());
        
        // Verify that deleteTodo was NOT called for Java-related todos
        verify(dataServiceMock, Mockito.never()).deleteTodo("Dhanush", "Learn Java");
        verify(dataServiceMock, Mockito.never()).deleteTodo("Dhanush", "Write unit tests in Java");
    }
}
