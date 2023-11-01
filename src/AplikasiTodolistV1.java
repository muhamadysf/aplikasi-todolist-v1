public class AplikasiTodolistV1 {

    public static String[] model = new String[10];
    public static void main(String[] args) {
        testShowTodoList();
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

//  menghapus todolist
    public static void removeTodolist(){

    }

//  tampilan isitodolist
    public static void viewShowTodolist(){

    }

//  tampilan tambah todolist
    public static void viewAddTodolist(){

    }

//  tampilan hapus todolist
    public static void viewRemoveTodolist(){

    }
}
