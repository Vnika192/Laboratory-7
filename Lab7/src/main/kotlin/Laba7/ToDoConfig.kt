import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class ToDoConfig {
    @Bean
    open fun toDo(): ToDo = ToDo()

}