package org.allTopics.Creational.Prototype.CodeExample2;

import java.util.HashMap;
import java.util.Map;

public class JiraTaskRegistry {
    Map<JiraTaskType, JiraTask> tasks;
    public JiraTaskRegistry() {
        tasks = new HashMap<>();
    }

    public void registerTask(JiraTaskType jiraTaskType, JiraTask jiraTask) {
        tasks.put(jiraTaskType, jiraTask);
    }

    public JiraTask getTask(JiraTaskType jiraTaskType) {
        return tasks.get(jiraTaskType);
    }

    public void unregisterTask(JiraTaskType jiraTaskType) {
        tasks.remove(jiraTaskType);
    }


}
