package aleks.exercise.model;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name="task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false, updatable = false)
    private Long id;

    @Column(name ="name", nullable = false)
    private String name;

    @Min(value = 0, message = "Time spent cannot be below 0.")
    private double timeSpent;

    private boolean taskDone;

    @Embedded
    private Assignee assignee;

    @Embedded
    private TaskGroup taskGroup;

    protected Task() {}

    public Task(String name, double timeSpent, boolean taskDone, Assignee assignee, TaskGroup taskGroup) {
        this.name = name;
        this.timeSpent = timeSpent;
        this.taskDone = taskDone;
        this.assignee = assignee;
        this.taskGroup = taskGroup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(double timeSpent){
        this.timeSpent = timeSpent;
    }

    public boolean getTaskDone() {
        return taskDone;
    }

    public void setTaskDone(boolean taskDone){
        this.taskDone = taskDone;
    }

    public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(Assignee assignee){
        this.assignee = assignee;
    }

    public TaskGroup getTaskGroup() {
        return taskGroup;
    }

    public void setTaskGroup(TaskGroup taskGroup){
        this.taskGroup = taskGroup;
    }

    @Override
    public String toString(){
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", timeSpent='" + timeSpent + '\'' +
                ", taskDone='" + taskDone + '\'' +
                ", assignee='" + assignee.getFirstName() + ' ' + assignee.getLastName() + '\'' +
                ", TaskGroup='" + taskGroup.getGroupName() + '\'' +
                '}';
    }
}