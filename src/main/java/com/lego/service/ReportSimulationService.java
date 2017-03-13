package com.lego.service;

import com.lego.entity.FileSimulationEntity;
import com.lego.entity.ReportSimulationEntity;
import com.lego.entity.ReportTemplateFilesEntity;
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
public class ReportSimulationService extends MainService{

    public FileSimulationEntity addFileSimulationEntity(FileSimulationEntity fileSimulationEntity) {
        return null;
    }

    public ReportSimulationEntity createSimulationReport(long reportTemplateID) {
        return null;
    }

    public ReportSimulationEntity getSimulationReport(long id) {
        return null;
    }

    public ReportSimulationEntity updateSimulationReport(ReportSimulationEntity entity) {
        return null;
    }

    public List<FileSimulationEntity> getOriginalOutputSimulationFileList(long simulationEntityId) {
        return null;
    }

    public List<FileSimulationEntity> getInputFileList(long reportId) {
        return null;
    }

    public List<FileSimulationEntity> getOutputFileList(long reportId) {
        return null;
    }

    public FileSimulationEntity getCompareResultFile(long reportId) {
        return null;
    }

    public List<FileSimulationEntity> getOutputTemplateFileList(long reportId) {
        return null;
    }

    public List<FileSimulationEntity> getInstanceVariableList(long reportId) {
        return null;
    }

    public void deleteOutputFileList(long reportId) {

    }

    public boolean deleteReportInstanceById(long reportInstanceId ){
        return true;
    }

    public String deleteOneFileEntityById(long fileId){
        return null;
    }

    public FileSimulationEntity addOneFileEntityById(long templateFileID,long simulationID){
        return null;
    }

    public FileSimulationEntity updateFileEntity(FileSimulationEntity fileEntity){
        return null;
    }

    public FileSimulationEntity getFileEntity(long fileEntityID){
        return null;
    }

    public boolean deleteFileSimulationEntityByObject(FileSimulationEntity entity) {
        return true;
    }

    public void addSimulationFileEntity(ReportTemplateFilesEntity templateFileEntity, ReportSimulationEntity reportSimulationEntity, String filePath) {

    }

    public void addSimulationVariableInfo(ReportTemplateFilesEntity templateFileEntity, ReportSimulationEntity reportSimulationEntity) {

    }
}
