package com.dyu.group;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author dyu 2019/11/19 19:18
 */
public class GroupMaxValueCompute {


    private void convert() {

        new ArrayList<>();

        GroupDTO group1 = new GroupDTO(1L, "apple", new Date());
        GroupDTO group2 = new GroupDTO(1L, "banana", new Date());
        GroupDTO group3 = new GroupDTO(2L, "watermelon", new Date());
        GroupDTO group4 = new GroupDTO(3L, "orange", new Date());
        GroupDTO group5 = new GroupDTO(3L, "ha-mi-melon", null);
        GroupDTO group6 = new GroupDTO(4L, "grape", new Date());
        GroupDTO group7 = new GroupDTO(5L, "potato", null);
        List<GroupDTO> gs = Arrays.asList(group1, group2, group3, group4, group5, group6, group7);

        //gs.stream().collect(Collectors.groupingBy(GroupDTO::getId), Collectors.collectingAndThen(Collectors.toCollection() -> new TreeSet<>()));


    }


    public static class GroupDTO {

        private Long id;
        private String name;
        private Date date;

        public GroupDTO() {

        }

        public GroupDTO(Long id, String name, Date date) {
            this.id = id;
            this.name = name;
            this.date = date;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }


}
