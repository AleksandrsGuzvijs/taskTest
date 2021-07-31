package aleks.exercise.web;

import aleks.exercise.model.Task;
import aleks.exercise.service.TaskService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

        @Autowired
        private TaskService taskService;

        @GetMapping("/all")
        @ApiOperation(value = "Returns all existing tasks.")
        public ResponseEntity<List<Task>> getAllTasks(){
            List<Task> tasks = taskService.getAllTasks();
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        }

        @GetMapping("/find/{id}")
        @ApiOperation(value = "Finds task by id", notes = "Provide id to find specific task in the system", response = Task.class)
        public ResponseEntity<Task> getTaskById(@ApiParam(value = "id value of that task that you want to find.", required = true) @PathVariable("id") Long id){
            Task task = taskService.findTaskById(id);
            return new ResponseEntity<>(task, HttpStatus.OK);
        }

        @PostMapping("/add")
        @ApiOperation(value = "Add new task.")
        public ResponseEntity<Task> addTask(@Valid @RequestBody Task task) {
            Task newTask = taskService.addTask(task);
            return new ResponseEntity<>(newTask, HttpStatus.CREATED);
        }

        @PutMapping("/update")
        @ApiOperation(value = "Update existing task", notes = "Currently done by providing id inside of json request with the rest of the task class, also able to add new tasks through this operation")
        public ResponseEntity<Task> updateTask(@RequestBody Task task) {
            Task updateTask = taskService.updateTask(task);
            return new ResponseEntity<>(updateTask, HttpStatus.OK);
        }

        @DeleteMapping("/delete/{id}")
        @ApiOperation(value = "Deletes task specified by id")
        public ResponseEntity<?> deleteTask(@PathVariable("id") Long id) {
            taskService.deleteTask(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
}
