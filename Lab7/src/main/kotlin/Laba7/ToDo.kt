class ToDo(private var toDoList: MutableList<ToDoItem> = mutableListOf()){

    fun add(item: ToDoItem) = toDoList.add(item)

    fun delete(description: String): Boolean = toDoList.removeIf{it.description.equals(description)}

    fun deleteActive():Boolean = toDoList.removeIf{it.status.equals(Status.ACTIVE)}

    fun deleteDone(): Boolean = toDoList.removeIf{it.status.equals(Status.DONE)}

    fun deleteAll() = toDoList.clear()

    fun changeDescription(descriptionOld: String, descriptionNew: String, statusNew: Status): Boolean{
        var item = find(descriptionOld)

        if (item != null && descriptionNew != null){
            toDoList.set(toDoList.indexOf(item), item.apply { this.description = descriptionNew })
            return true
        }
        return false
    }

    fun chaneStatus(description: String, status: Status): Boolean{
        var item = find(description)

        if (item != null){
            toDoList.set(toDoList.indexOf(item), item.apply { this.status = status })
            return true
        }
        return false
    }

    fun listToDo(status: Status? = null): List<ToDoItem> = when(status){
        Status.ACTIVE -> toDoList.filter { it.status.equals(Status.ACTIVE) }
        Status.DONE -> toDoList.filter { it.status.equals(Status.DONE) }
        null -> toDoList
    }

    fun find(description: String): ToDoItem? = toDoList.find{it.description.equals(description)}

    fun print(toDoForPrint: List<ToDoItem>): String{
        var result = ""
        for (item in toDoForPrint){
            result += "Описание: ${item.description}, Статус: ${item.status}, Комментарий: ${item.comment}\n"
        }
        return result
    }
}