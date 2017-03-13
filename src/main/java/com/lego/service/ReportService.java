package com.lego.service;

import com.lego.entity.FileEntity;
import com.lego.entity.ReportEntity;
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
public class ReportService extends MainService{

    public List<ReportEntity> getAllReport(){
        return reportDao.findAll();
    }

    public ReportEntity createReport() {
        return null;
    }

    public ReportEntity getReport(long id) {
        return null;
    }

    public ReportEntity updateReport(ReportEntity entity) {
        return reportDao.save(entity);
    }

    public List<FileEntity> getInputFileList(long reportId) {
        return null;
    }

    public List<FileEntity> getOutputFileList(long reportId) {
        return null;
    }

    public List<FileEntity> getOutputTemplateFileList(long reportId) {
        return null;
    }

    public List<FileEntity> getInstanceVariableList(long reportId) {
        return null;
    }

    public FileEntity updateFileEntity(FileEntity fileEntity){
        return null;
    }

    public FileEntity getFileEntity(long fileEntityID){
        return null;
    }

    public boolean deleteReportInstanceById(long reportInstanceId ){
        return true;
    }
}
