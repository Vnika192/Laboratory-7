import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

val ctx: ApplicationContext =
    AnnotationConfigApplicationContext(ToDoConfig::class.java)

var toDo: ToDo = ctx.getBean(ToDo::class.java)

fun main() {
    toDo.add(ToDoItem("Помыть посуду", Status.ACTIVE))
    toDo.add(ToDoItem("Убраться", Status.ACTIVE))
    toDo.add(ToDoItem("Погулять с собакой", Status.DONE))
    toDo.add(ToDoItem("Отдохнуть", Status.ACTIVE))

    toDo.print(toDo.listToDo())

    toDo.deleteDone()

    toDo.print(toDo.listToDo())
    ToDoMenu()
}

fun ToDoMenu() {
    while (true){
        println("Добавить \nУдалить \nНайти \nВывести \nВыйти")
        when(readLine()!!.toString()){
            "Добавить" -> {
                println("Введите описание")
                toDo.add(ToDoItem(readLine()!!.toString(), Status.ACTIVE))
            }
            "Удалить" -> {
                println("Введите описание")
                toDo.delete(readLine()!!.toString())
            }
            "Найти" -> {
                println("Введите описание")
                println(toDo.find(readLine()!!.toString()).toString())
            }
            "Вывести" -> {
                toDo.print(toDo.listToDo())
            }
            "Выйти" -> {
                break
            }
            else -> {continue}

        }
    }
}