package com.test;

import com.lego.entity.ReportTemplateEntity;
import com.lego.entity.UserEntity;
import com.lego.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 1481702
 * Date: 2/24/17
 * Time: 10:19 AM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-context.xml")
public class UserDaoTest {
    @Autowired
    private UserService userService;

    @Test
    public void testInsert() throws Exception {
        //在insert记录的时候，在一对多的情况下，我们在影射关系的时候，通常是由多方去维护这个关系
        //也就是说，在一的一方，虽然ｃｌａｓｓ里有多方的ｌｉｓｔ记录，但是在数据库里不会有字段去对应
        //所以在insert的时候，一的一方可以直接插入，不会考虑多方的维护，因为已经把维护的责任交由多方处理了
        //举例来说，还是学校和学生，如果新开一个学校，不需要去指定学校里有那些学生
        //但是对于学生上学来说（insert一条学生记录），必须得指定了学校是哪个，才能去上学
        //所以在insert多方的时候，一定要先set好一方的实体。

        String userName = "dengyuan";
        String userId = "1491111";
        String role = "Checker";
        String mail = "dengyuan@123.com";
        userService.createUser(userId,userName,mail,role);
    }

    @Test
    public void testFindByID() throws Exception {
        String userID = "1481702";
        UserEntity userEntity = userService.getUserByUserID(userID);
        Assert.assertEquals(userEntity.getUserID(),"1481702");
    }

    @Test
    public void testGetReportTemplateFromUserID() throws Exception{
        String userID = "1481702";
        List<ReportTemplateEntity> reportTemplateEntities =
                userService.getReportTemplateList(userID);
        System.out.println(reportTemplateEntities.size());
        Assert.assertNotNull(reportTemplateEntities);
    }

    @Test
    public void testGetReportTemplateFromUserIDAndStatus() throws Exception{
        String userID = "1481702";
        int status = 0;
        List<ReportTemplateEntity> reportTemplateEntities =
                userService.getReportTemplateList(userID,status);
        System.out.println(reportTemplateEntities.size());
        Assert.assertNotNull(reportTemplateEntities);
    }

}
