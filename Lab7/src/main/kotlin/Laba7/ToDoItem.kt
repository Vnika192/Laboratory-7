import jdk.jfr.Description

data class ToDoItem(var description: String, var status: Status, var comment: String = "Отсутствует"){
    var items: List<ToDoItem> = listOf()

    fun printToDo(){
        println("Описание: $description  Статус: $status  Комментарий: $comment")
    }
}

enum class Status{
    DONE,ACTIVE
}
