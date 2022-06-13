package Laba7

import ToDo
import ToDoConfig
import ToDoItem
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    val ctx: ApplicationContext =
        AnnotationConfigApplicationContext(ToDoConfig::class.java)

    var toDo: ToDo = ctx.getBean(ToDo::class.java)


    @RequestMapping("/print", method = [RequestMethod.GET])
    fun printToDo(): String{
        return toDo.print(toDo.listToDo())
    }

    @RequestMapping("/add {name}", method = [RequestMethod.POST])
    fun new(@PathVariable("name") name: String):String?{
        toDo.add(ToDoItem(name, Status.ACTIVE))
        return printToDo()
    }

    @RequestMapping("/del {name}", method = [RequestMethod.DELETE])
    fun del(@PathVariable("name") name: String): String?{
        toDo.delete(name)
        return printToDo()
    }

}