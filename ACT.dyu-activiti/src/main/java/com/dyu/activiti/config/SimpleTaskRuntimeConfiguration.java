package com.dyu.activiti.config;

import org.activiti.api.task.runtime.events.TaskAssignedEvent;
import org.activiti.api.task.runtime.events.TaskCompletedEvent;
import org.activiti.api.task.runtime.events.listener.TaskRuntimeEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dyu
 * @date 2019/06/06
 */
@Configuration
public class SimpleTaskRuntimeConfiguration {

    @Autowired
    private PasswordEncoder passwordEncoder;


    private Logger logger = LoggerFactory.getLogger(SimpleTaskRuntimeConfiguration.class);

    //@Bean
    //public UserDetailsService userDetailsService(){
    //    InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
    //
    //    String[][] usersGroupAndRoles = {
    //            {"salaboy", "password", "ROLE_ACTIVITI_USER", "GROUP_activitiTeam"},
    //            {"ryandawonuk", "password", "ROLE_ACTIVITI_USER", "GROUP_activitiTeam"},
    //            {"erdemedeiros", "password", "ROLE_ACTIVITI_USER", "GROUP_activitiTeam"},
    //            {"other", "password", "ROLE_ACTIVITI_USER", "GROUP_otherTeam"},
    //            {"admin", "password", "ROLE_ACTIVITI_ADMIN"}
    //    };
    //
    //    for (String[] user : usersGroupAndRoles) {
    //        List<String> authoritiesStrings = Arrays.asList(Arrays.copyOfRange(user, 2, user.length));
    //        logger.info("> Registering new user: " + user[0] + " with the following Authorities[" + authoritiesStrings + "]");
    //        inMemoryUserDetailsManager.createUser(new User(user[0], passwordEncoder.encode(user[1]),
    //                authoritiesStrings.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())));
    //    }
    //    return inMemoryUserDetailsManager;
    //}

    @Bean
    public TaskRuntimeEventListener<TaskAssignedEvent> taskAssignedListener() {
        return taskAssigned -> logger.info(">>> Task Assigned: '" +
                taskAssigned.getEntity().getName() +
                "' We can send a notification to the owner: " + taskAssigned.getEntity().getAssignee());
    }

    @Bean
    public TaskRuntimeEventListener<TaskCompletedEvent> taskCompletedListener() {
        return taskCompleted -> logger.info(">>> Task Completed: '" +
                taskCompleted.getEntity().getName() +
                " ' We can send a notification to the owner: " + taskCompleted.getEntity().getOwner());
    }

}
