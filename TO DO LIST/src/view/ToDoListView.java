package view;

import service.ToDoListService;
import util.InputUtil;

public class ToDoListView {

    private ToDoListService toDoListService;

    public ToDoListView(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    public  void showTodoList(){
        while (true) {

            toDoListService.showToDoList();

            System.out.println("MENU");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = InputUtil.input("Pilih");
            if (input.equals("1")) {
                addToDoList();
            } else if (input.equals("2")) {
                removeToDoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public void addToDoList(){
        System.out.println("Menambahkan Todo List");
        var todo = InputUtil.input("Todo (x Jika Batal");

        if(todo.equals("x")) {
        } else {
            toDoListService.addToDoList(todo);
        }
    }

    public void removeToDoList(){
        System.out.println("MENGHAPUS TODO LIST");
        var number = InputUtil.input("Nomor yang dihapus (x Jika Batal");
        if(number.equals("x")) {
            // batal
        } else {
            toDoListService.removeToDoList(Integer.valueOf(number));
        }
    }
}
