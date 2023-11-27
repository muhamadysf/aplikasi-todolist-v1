import java.util.Scanner;

public class AplikasiTodolistV1 {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodolist();
    }

//  menampilkan isiTodolist
    public static void showTodolist(){
        for (int i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodoList(){
        model[0] = "Belajar Java";
        model[1] = "Belajar Web";
        model[2] = "Belajar React";
        showTodolist();
    }

//  menambah todolist
    public static void addTodolist(String todo){
//      cek apakah data/model penuh?
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null){
                isFull = false;
                break;
            }
        }

//      jika data/model penuh maka resize ukuran array modelnya!
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

//      tambahkan ke posisi yang datanya null!
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodolist(){
        for (int i = 0; i < 25; i++) {
            addTodolist("Todolist ke. " + i);
        }

        showTodolist();
    }

//  menghapus todolist
    public static boolean removeTodolist(Integer number){
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList(){
        for (int i = 0; i < 5; i++) {
            addTodolist("Todo ke-" + (i + 1));
        }

        var result = removeTodolist(2);
        System.out.println(result);

        showTodolist();
    }

    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Silahkan Ketik");
        System.out.println(name);
    }

//  tampilan menuisitodolist
    public static void viewShowTodolist(){
        while (true) {
            System.out.println("_____[ Todo List ]_____");
            showTodolist();
            System.out.println(" ");
            System.out.println("=====[Menu]=====");
            System.out.println("1. Tambah TodoList");
            System.out.println("2. Hapus TodoList");
            System.out.println("X. Keluar");
            System.out.println(" ");
            var input = input("Pilih");

            if (input.equals("1")) {
                viewAddTodolist();
            } else if (input.equals("2")) {
                viewRemoveTodolist();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak ada");
            }
        }
    }

    public static void testViewShowTodolist(){
        for (int i = 0; i < 5; i++) {
            addTodolist("Todo ke-" + (i + 1));
        }
        viewShowTodolist();
    }

//  tampilan tambah todolist
    public static void viewAddTodolist(){
        System.out.println("=======[ +MENAMBAHKAN TODOLIST+ ]=======");

        var todo = input("Todo (x Jika Batal)");

        if (todo.equals("x")) {
            //batal
        } else {
            addTodolist(todo);
        }
    }

    public static void testViewAddTodolist(){
        for (int i = 0; i < 3; i++) {
            addTodolist("Todo ke-" + (i + 1));
        }

        viewAddTodolist();

        showTodolist();
    }

//  tampilan hapus todolist
    public static void viewRemoveTodolist(){
        System.out.println("===== [ -MENGHAPUS TODOLIST- ] =====");

        var number = input("Input Nomor Yang Mau Dihapus (x untuk batal)");

        if (number.equals("x")) {
            //batal
        } else {
            boolean success = removeTodolist(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus todolist ke- : " + number);
            }
        }
    }

    public static void testViewRemoveTodolist(){
        for(int i = 0; i < 3; i++){
            addTodolist("Todo ke-" + (i + 1));
        }

        showTodolist();

        viewRemoveTodolist();

        showTodolist();
    }
}
