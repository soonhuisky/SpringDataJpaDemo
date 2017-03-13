package com.test;

import com.lego.service.GroupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * User: 1481702
 * Date: 2/24/17
 * Time: 10:19 AM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-context.xml")
public class GroupDaoTest {
    @Autowired
    private GroupService groupService;

    @Test
    public void testInsert() throws Exception {
        String groupName = "FMO";
        groupService.createGroup(groupName);
    }

    @Test
    public void testDelete() throws Exception {
        //如果设置了CascadeType.ALL，那么当删除了Group时，template里的对应group的记录也会被级联删除
        //注意级联删除主要指的是一对多关系中的一方被删除时，多方的表现。
        //直接删除多方，和级联没有什么关系。一的一方不会有任何影响
        //很好理解，一个学校有众多学生，如果学校没了，被删除了，那这帮学生如果，肯定是需要商量的（即级联策略）
        //但是如果一个学生退学，或者有新转来的学生，对学校没有任何大的影响，所以学校不会产生什么变化。

    }

    @Test
    public void testUpdate() throws Exception{

    }
}
