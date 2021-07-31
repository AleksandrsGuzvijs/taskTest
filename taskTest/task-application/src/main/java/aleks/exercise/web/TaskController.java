package aleks.exercise.web;

import aleks.exercise.model.Task;
import aleks.exercise.service.TaskService;
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
        public ResponseEntity<List<Task>> getAllTasks(){
            List<Task> tasks = taskService.getAllTasks();
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        }

        @GetMapping("/find/{id}")
        public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id){
            Task task = taskService.findTaskById(id);
            return new ResponseEntity<>(task, HttpStatus.OK);
        }

        @PostMapping("/add")
        public ResponseEntity<Task> addTask(@Valid @RequestBody Task task) {
            Task newTask = taskService.addTask(task);
            return new ResponseEntity<>(newTask, HttpStatus.CREATED);
        }

        @PutMapping("/update")
        public ResponseEntity<Task> updateTask(@RequestBody Task task) {
            Task updateTask = taskService.updateTask(task);
            return new ResponseEntity<>(updateTask, HttpStatus.OK);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteTask(@PathVariable("id") Long id) {
            taskService.deleteTask(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
}
