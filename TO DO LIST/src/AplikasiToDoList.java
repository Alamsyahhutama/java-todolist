public class AplikasiToDoList {
    public static String[] model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {

    viewShowTodoList();

    }

    /**
     * Menampilkan todo list
     */

    public static void showTodoList() {
        System.out.println("TODO LIST");
    for (var i = 0; i < model.length; i++) {
        var todo = model [i];
        var no = i+1;

        if (todo != null) {
            System.out.println(no + ". " + todo );
        }
      }
    }

    public static void testshowTodoList(){
        model[0] = "Belajar Java Dasar";
        model[1] = "Belajar Java Intermediate";
        model[2] = "Belajar Java Experts";
        showTodoList();
    }

    /**
     * Menambah todo ke list
     */
    public static void addTodoList(String todo) {
        // cek apakah model penuh
        var ifFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                // model masih ada yang kosong
                ifFull = false;
                break;
            }
        }

        // jika penuh kita resize ukuran array 2x lipat
        if (ifFull) {
            var temporary  = model;
            model = new String[model.length * 2];
            for (int i = 0; i < temporary.length;i++) {
                model [i] = temporary[i];
            }
        }


        // tambahkan ke posiis yang data arraynya NULL
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] =  todo;
                break;
            }
        }
    }

    public static void testAddToDoList() {
        for (int i = 0; i<25; i++) {
            addTodoList("Contoh todo ke. " + i);
        }
        showTodoList();
    }

    /**
     * Menghapus todo list
     */

    public static boolean removeTodoList (Integer number) {
        if((number - 1) >= model.length) {
            return false;
        } else if (model[number-1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
            if(i == (model.length -1)) {
                model[i] = null;
            } else {
                model[i] = model [i+1];
            }
            }
            return true;
        }
    }

    public static void testRemoveToDoList () {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        removeTodoList(20);
        var result =removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(7);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi " + name);
        var channel = input("Channel");
        System.out.println(channel);
    }

    /**
     * Menampilkan view todo list
     */

    public static  void viewShowTodoList() {
    while (true) {
        showTodoList();

        System.out.println("MENU");
        System.out.println("1. Tambah");
        System.out.println("2. Hapus");
        System.out.println("x. Keluar");

        var input = input("Pilih");
        if (input.equals("1")) {
            viewAddTodoList();
        } else if (input.equals("2")) {
            viewRemoveToDoList();
        } else if (input.equals("x")) {
            break;
        } else {
            System.out.println("Pilihan tidak dimengerti");
        }
    }

    }

    public static void testViewShowToDoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");
        viewShowTodoList();
    }

    /**
     * Menampilkan view menambahkan todo list
     */

    public static void viewAddTodoList() {
        System.out.println("Menambahkan Todo List");
        var todo = input("Todo (x Jika Batal");

        if(todo.equals("x")) {
        } else {
            addTodoList(todo);
        }
    }

    public static void testViewAddtoDoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        viewAddTodoList();
        showTodoList();
    }
    /**
     * Menampilkan view menghapus todo list
     */

    public static void viewRemoveToDoList(){
        System.out.println("MENGHAPUS TODO LIST");
        var number = input("Nomor yang dihapus (x Jika Batal");
        if(number.equals("x")) {
            // batal
        } else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if(!success){
                System.out.println("Gagal menghapus todolist : " + number);
            }
        }
    }
    public static void testViewRemoveToDoList () {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        showTodoList();
        viewRemoveToDoList();
        showTodoList();
    }
}
