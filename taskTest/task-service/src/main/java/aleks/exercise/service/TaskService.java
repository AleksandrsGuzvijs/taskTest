package aleks.exercise.service;

import aleks.exercise.model.Task;

import java.util.List;

public interface TaskService {

    public Task addTask(Task task);

    public List<Task> getAllTasks();

    public Task updateTask(Task task);

    public Task findTaskById(Long id);

    public void deleteTask(Long id);
}
