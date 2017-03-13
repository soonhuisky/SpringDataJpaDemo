package com.lego.service;

import com.lego.entity.ReportEntity;
import com.lego.entity.ReportSimulationEntity;
import com.lego.entity.ReportTemplateEntity;
import com.lego.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 1481702
 * Date: 3/7/17
 * Time: 10:08 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserService extends MainService{

    /**
     * Create a new User
     * @param userID
     * @param userName
     * @param email
     * @param role
     */
    public void createUser(String userID,String userName,String email,String role) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userName);
        userEntity.setUserID(userID);
        userEntity.setRole(role);
        userEntity.setMail(email);
        userDao.save(userEntity);
    }

    /**
     * Get User by role
     * @param role
     * @return
     */
    public UserEntity getUserByRole(String role){
        return userDao.findByRole(role);
    }

    /**
     * Get User by userID
     * @param userID
     * @return
     */
    public UserEntity getUserByUserID(String userID){
        return userDao.findByUserID(userID);
    }


    public List<UserEntity> getAllUsers(){
        return userDao.findAll();
    }

    public void updateUser(UserEntity userEntity) {
        userDao.save(userEntity);
    }

    public List<ReportTemplateEntity> getReportTemplateList(String userID){
        List<ReportTemplateEntity> reportTemplateEntities = new ArrayList<>();
        UserEntity userEntity = getUserByUserID(userID);
        return reportTemplateDao.findByTemplateBuilderUser(userEntity);
    }

    public List<ReportTemplateEntity> getReportTemplateList(String userID,int status){
        List<ReportTemplateEntity> reportTemplateEntities = new ArrayList<>();
        UserEntity userEntity = getUserByUserID(userID);
        return reportTemplateDao.findByTemplateBuilderUserAndTemplateStatus(userEntity,status);
    }

    public List<ReportTemplateEntity> getReportTemplateListByMaker(String userId,int templateStatus){
        return null;
    }

    public List<ReportEntity> getReportInstanceList(String userId){
        return null;
    }

    public List<ReportSimulationEntity> getReportSimulationInstanceList(String userId){
        return null;
    }

    public void deleteUser( UserEntity user){
//        nil
    }
}
