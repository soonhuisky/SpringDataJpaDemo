package com.lego.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: 1481702
 * Date: 14-9-16
 * Time: 上午11:32
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "file_simulation_entity")
public class FileSimulationEntity extends BaseEntity {

    private String uploadName;
    private ReportSimulationEntity reportSimulationEntity;
    //uploadType为1是upload file,2 file on server,3 file in  database,4 for variable
    //uploadType为11是LEGO Server,12是other server
    private int uploadType;
    private int fileStatus;

    @ManyToOne
    @JoinColumn(nullable = false)
    public ReportSimulationEntity getReportSimulationEntity() {
        return reportSimulationEntity;
    }

    public void setReportSimulationEntity(ReportSimulationEntity reportSimulationEntity) {
        this.reportSimulationEntity = reportSimulationEntity;
    }

    public int getUploadType() {
        return uploadType;
    }

    public void setUploadType(int uploadType) {
        this.uploadType = uploadType;
    }

    public String getUploadName() {
        return uploadName;
    }

    public void setUploadName(String uploadName) {
        this.uploadName = uploadName;
    }

    public int getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(int fileStatus) {
        this.fileStatus = fileStatus;
    }
}
