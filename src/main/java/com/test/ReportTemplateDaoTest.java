package com.test;

import com.lego.entity.ReportTemplateFilesEntity;
import com.lego.entity.UserEntity;
import com.lego.service.ReportTemplateService;
import com.lego.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 1481702
 * Date: 3/3/17
 * Time: 10:16 AM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-context.xml")
public class ReportTemplateDaoTest {
    @Autowired
    private ReportTemplateService reportTemplateService;
    @Autowired
    private UserService userService;

    public List<UserEntity> createUserList(String... userIDList){
        List<UserEntity> userEntityList = new ArrayList<>();
        for(String id : userIDList){
            UserEntity userEntity = userService.getUserByUserID(id);
            userEntityList.add(userEntity);
        }
        return userEntityList;
    }

    @Test
    public void testInsert() throws Exception {
        //在insert记录的时候，在一对多的情况下，我们在影射关系的时候，通常是由多方去维护这个关系
        //也就是说，在一的一方，虽然ｃｌａｓｓ里有多方的ｌｉｓｔ记录，但是在数据库里不会有字段去对应
        //所以在insert的时候，一的一方可以直接插入，不会考虑多方的维护，因为已经把维护的责任交由多方处理了
        //举例来说，还是学校和学生，如果新开一个学校，不需要去指定学校里有那些学生
        //但是对于学生上学来说（insert一条学生记录），必须得指定了学校是哪个，才能去上学
        //所以在insert多方的时候，一定要先set好一方的实体。

        String longName = "巴拉巴拉";
        String shortName = "T12";
        String userID = "1481702";
        int status = 0;
        String groupName = "FMO";
        List<UserEntity> approverList = createUserList("1481702", "1481700");
        List<UserEntity> makerList = createUserList("1481694");
        List<UserEntity> checkerList = createUserList("1481694", "1491111");
        reportTemplateService.createReportTemplate(shortName,longName
        ,status,userID,groupName,approverList,makerList,checkerList);
    }

    @Test
    public void testGetTemplateFileList(){
        int reportTemplateID = 1;
        List<ReportTemplateFilesEntity> reportTemplateFilesEntities =
                reportTemplateService.getTemplateFileList(reportTemplateID);
        System.out.println(reportTemplateFilesEntities.size());
    }

    @Test
    public void testDelete() throws Exception {
        //如果设置了CascadeType.ALL，那么当删除了Group时，template里的对应group的记录也会被级联删除
        //注意级联删除主要指的是一对多关系中的一方被删除时，多方的表现。
        //直接删除多方，和级联没有什么关系。一的一方不会有任何影响
        //很好理解，一个学校有众多学生，如果学校没了，被删除了，那这帮学生如果，肯定是需要商量的（即级联策略）
        //但是如果一个学生退学，或者有新转来的学生，对学校没有任何大的影响，所以学校不会产生什么变化。
//        int deleteId = 7;
//        reportTemplateDao.delete(deleteId);

        //这里的删除会级联三个list: templateApproverList, MakerList, CheckerList
    }


}
