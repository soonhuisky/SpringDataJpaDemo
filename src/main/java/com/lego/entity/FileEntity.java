package com.lego.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: 1481700
 * Date: 14-8-12
 * Time: 上午10:23
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "file_entity")
public class FileEntity extends BaseEntity {

    private String uploadValue;
    private String uploadName;
    private ReportEntity reportEntity;
    //uploadType为1是upload file,2 file on server,3 file in  database,4 for variable
    //uploadType为11是LEGO Server,12是other server
    private int uploadType;
    private int fileStatus;

    @ManyToOne
    @JoinColumn(nullable = false)
    public ReportEntity getReportEntity() {
        return reportEntity;
    }

    public void setReportEntity(ReportEntity reportEntity) {
        this.reportEntity = reportEntity;
    }

    public int getUploadType() {
        return uploadType;
    }

    public void setUploadType(int uploadType) {
        this.uploadType = uploadType;
    }

    public String getUploadValue() {
        return uploadValue;
    }

    public void setUploadValue(String uploadValue) {
        this.uploadValue = uploadValue;
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
