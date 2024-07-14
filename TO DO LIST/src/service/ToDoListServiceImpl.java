package service;

import entity.ToDoList;
import repository.ToDoListRepository;

public class ToDoListServiceImpl implements ToDoListService {

    private ToDoListRepository toDoListRepository;

    public ToDoListServiceImpl(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }


    @Override
    public void showToDoList() {
            ToDoList[] model = toDoListRepository.getAll();

            System.out.println("TODO LIST");
            for (var i = 0; i < model.length; i++) {
                var toDoList = model [i];
                var no = i+1;

                if (toDoList != null) {
                    System.out.println(no + ". " + toDoList.getTodo());
                }
            }
        }

    @Override
    public void addToDoList(String todo) {

        ToDoList toDoList = new ToDoList(todo);
        toDoListRepository.add(toDoList);
        System.out.println("Sukses menambah todo " + todo);
    }

    @Override
    public void removeToDoList(Integer number) {

        boolean success = toDoListRepository.remove(number);
        if(success){
            System.out.println("Sukses menghapus TODO : " + number );
        } else {
            System.out.println("Gagal menghapus TODO " + number);
        }
    }
}
