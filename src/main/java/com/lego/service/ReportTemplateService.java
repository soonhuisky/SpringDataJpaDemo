package com.lego.service;

import com.lego.entity.ReportTemplateEntity;
import com.lego.entity.ReportTemplateFilesEntity;
import com.lego.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 1481702
 * Date: 3/7/17
 * Time: 10:11 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ReportTemplateService extends MainService{

    @Autowired
    UserService userService;
    @Autowired
    GroupService groupService;

    public void createReportTemplate(
            String templateShortName,String templateFullName,
            int templateStatus,String userID,
            String groupName,List<UserEntity> approverList,
            List<UserEntity> makerList,List<UserEntity> checkerList
    ){
        ReportTemplateEntity reportTemplateEntity = new ReportTemplateEntity();
        reportTemplateEntity.setTemplateFullName(templateFullName);
        reportTemplateEntity.setTemplateShortName(templateShortName);
        reportTemplateEntity.setTemplateStatus(templateStatus);
        reportTemplateEntity.setTemplateBuilderUser(userService.getUserByUserID(userID));
        reportTemplateEntity.setGroupEntity(groupService.getGroupByName(groupName));
        reportTemplateEntity.setTemplateApproverList(approverList);
        reportTemplateEntity.setMakerList(makerList);
        reportTemplateEntity.setCheckerList(checkerList);
        reportTemplateDao.save(reportTemplateEntity);
    }

    public void createReportTemplateFile(int templateID) {
        ReportTemplateFilesEntity reportTemplateFilesEntity = new ReportTemplateFilesEntity();
        reportTemplateFilesEntity.setFileDescription("new file");
        reportTemplateFilesEntity.setTemplateUploadName("Name");
        reportTemplateFilesEntity.setTemplateUploadType(1);
        reportTemplateFilesEntity.setTemplateUploadValue("Gary");
        reportTemplateFilesEntity.setReportTemplateEntity(getReportTemplate(templateID));
        reportTemplateFilesDao.save(reportTemplateFilesEntity);
    }

    public ReportTemplateEntity getReportTemplate(int id){
        return reportTemplateDao.getOne(id);
    }

//    public List<ReportTemplateEntity> getAllReportTemplateFromUserID(String userID){
//        List<ReportTemplateEntity> reportTemplateEntities = new ArrayList<>();
//        UserEntity userEntity = userService.getUserByUserID(userID);
//        return reportTemplateDao.findByTemplateBuilderUser(userEntity);
//    }

    public List<ReportTemplateEntity> getTemplateReportFromShortNameAndUserId(String shortName, String userId){
//      nil
        return null;
    }

    public ReportTemplateEntity getAvailableTemplateReport(){
        return null;
    }

    public List<ReportTemplateEntity>  getInUseTemplateReportList(int templateStatus){
        return null;
    }

    public boolean isAvailableTemplateReportLogicalName(String logicalName, long templateID) {
        return true;
    }

    public void addToUserList(List<String> userIdsList, List<UserEntity> userList) {

    }

    public List<ReportTemplateEntity> getAllTemplate(){
        return reportTemplateDao.findAll();
    }

    public void updateReport(ReportTemplateEntity reportTemplateEntity) {
        reportTemplateDao.save(reportTemplateEntity);
    }

    public List<ReportTemplateFilesEntity> getTemplateFileList(int templateReportId) {
        return reportTemplateDao.findOne(templateReportId).getTemplateFilesList();
    }

    public void deleteReport(ReportTemplateEntity reportTemplateEntity) {
        //nil
    }

    public void deleteReportTemplateById(long id) {
        //nil
    }

    private UserEntity getUserFromList(String id, List<UserEntity> list) {
        return null;
    }
    
    public ReportTemplateFilesEntity getReportTemplateFilesEntityById(long ReportTemplateFilesEntityId ){
        return null;
    }
    
    public void deleteReportTemplateFilesEntityById(long ReportTemplateFilesEntityId ){
     
    }

    public boolean deleteReportTemplateFilesEntityByObject(ReportTemplateFilesEntity entity ){
     return true;
    }

    public ReportTemplateFilesEntity updateReportTemplateFilesEntity(ReportTemplateFilesEntity entity){
        return null;
    }

    public List<ReportTemplateFilesEntity> getInputVariableListForSun(long templateReportId) {
        return null;
    }

    public List<ReportTemplateFilesEntity> getOutputTemplateFileList(long templateReportId) {
        return null;
    }

    public List<ReportTemplateFilesEntity> getOutputTemplateFileListForSun(long templateReportId) {
        return null;
    }

    public List<ReportTemplateFilesEntity> getOutputTemplateLoopOriginalFileList(long templateReportId) {
        return null;
    }

    public List<ReportTemplateFilesEntity> getOutputTemplateLoopOriginalFileListForSun(long templateReportId) {
        return null;
    }

    public List<ReportTemplateFilesEntity> getOutputTemplateVariableList(long templateReportId) {
        return null;
    }

}
