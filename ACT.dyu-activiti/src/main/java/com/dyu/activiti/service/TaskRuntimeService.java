package com.dyu.activiti.service;

import com.dyu.activiti.DyuActivitiApplication;
import com.dyu.activiti.util.SecurityUtil;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskRuntime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author dyu
 * @date 2019/06/06
 */
@Service
public class TaskRuntimeService {

    private Logger logger = LoggerFactory.getLogger(TaskRuntimeService.class);


    @Autowired
    private TaskRuntime taskRuntime;
    @Resource
    private SecurityUtil securityUtil;

    public void run() {
        // Using Security Util to simulate a logged in user
        securityUtil.logInAs("salaboy");

        logger.info("> Creating a Group Task for 'activitiTeam'");
        taskRuntime.create(TaskPayloadBuilder.create()
                .withName("First Team Task")
                .withDescription("This is something really important")
                .withCandidateGroup("activitiTeam")
                .withPriority(10)
                .build());

        securityUtil.logInAs("other");

        logger.info("> Getting all the tasks");
        Page<Task> tasks = taskRuntime.tasks(Pageable.of(0, 10));

        logger.info("> Other cannot see the task: " + tasks.getTotalItems());

        securityUtil.logInAs("erdemedeiros");

        logger.info("> Getting all the tasks");
        tasks = taskRuntime.tasks(Pageable.of(0, 10));

        logger.info("> erdemedeiros can see the task" + tasks.getTotalItems());


        String availableTaskId = tasks.getContent().get(0).getId();

        logger.info("> Claiming the task");
        taskRuntime.claim(TaskPayloadBuilder.claim().withTaskId(availableTaskId).build());

        logger.info("> Completing the task");
        taskRuntime.complete(TaskPayloadBuilder.complete().withTaskId(availableTaskId).build());
    }

}
