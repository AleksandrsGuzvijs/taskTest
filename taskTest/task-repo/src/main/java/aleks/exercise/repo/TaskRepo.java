package aleks.exercise.repo;

import aleks.exercise.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepo extends JpaRepository<Task,Long> {
    void deleteTaskById(Long id);

    Optional<Task> findTaskById(Long id);
}
