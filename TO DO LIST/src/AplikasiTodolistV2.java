import repository.ToDoListRepository;
import repository.ToDoListRepositoryImpl;
import service.ToDoListService;
import service.ToDoListServiceImpl;
import view.ToDoListView;

public class AplikasiTodolistV2 {
    public static void main(String[] args) {
        ToDoListRepository toDoListRepository = new ToDoListRepositoryImpl();
        ToDoListService toDoListService = new ToDoListServiceImpl(toDoListRepository);
        ToDoListView toDoListView = new ToDoListView(toDoListService);

        toDoListView.showTodoList();

    }
}
