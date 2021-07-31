package aleks.exercise.model;

import javax.persistence.*;

@Embeddable
public class TaskGroup {

    private String groupName;

    private String type;

    protected TaskGroup() {}

    public TaskGroup(String groupName, String type) {
        this.groupName = groupName;
        this.type = type;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String name) {
        this.groupName = groupName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
