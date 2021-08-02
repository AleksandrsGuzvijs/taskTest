package aleks.exercise.service.Impl;

import aleks.exercise.model.Task;
import aleks.exercise.repo.TaskRepo;
import aleks.exercise.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

        protected TaskRepo taskRepo;

        @Autowired
        public TaskServiceImpl(TaskRepo taskRepo) {
            this.taskRepo = taskRepo;
        }

        @Override
        public Task addTask(Task task) {
            return taskRepo.save(task);
        }

        @Override
        public List<Task> getAllTasks() {
            return taskRepo.findAll();
        }

        @Override
        public Task updateTask(Task task) {
            return taskRepo.save(task);
        }

        @Override
        public Task findTaskById(Long id) {
            return taskRepo.findTaskById(id).orElseThrow(() -> new ItemNotFoundException("Task by id:" + id + ", does not exist"));
        }

        @Override
        public void deleteTask(Long id){
            taskRepo.deleteTaskById(id);
        }
}
