package org.allTopics.Creational.Prototype.CodeExample2;

public class Client {
    public static void main(String[] args) {

        // creating registry to store JIRATask prototypes.
        JiraTaskRegistry jiraTaskRegistry = new JiraTaskRegistry();

        // registering EPIC Task as a prototype to the registry
        JiraTask epicTask= new JiraTask();
        epicTask.taskType = JiraTaskType.EPIC;
        jiraTaskRegistry.registerTask(JiraTaskType.EPIC, epicTask);

        // registering STORY Task as a prototype to the registry
        JiraTask storyTask= new JiraTask();
        storyTask.taskType = JiraTaskType.STORY;
        jiraTaskRegistry.registerTask(JiraTaskType.STORY, storyTask);

        // registering FEATURE Task as a prototype to the registry
        JiraTask featureTask= new JiraTask();
        featureTask.taskType = JiraTaskType.FEATURE;
        jiraTaskRegistry.registerTask(JiraTaskType.FEATURE, featureTask);

        // registering BUG Task as a prototype to the registry
        JiraTask bugTask= new JiraTask();
        bugTask.taskType = JiraTaskType.BUG;
        jiraTaskRegistry.registerTask(JiraTaskType.BUG, bugTask);
    }
}

// So registry is not copying object, it simply storing object. And returning it whenever asks.
// So if you see in the FlyWeight Design Pattern also we did the similar thing ryt. (just check code once).
// means we have stored the thing like Bullet & then retrieving them.
