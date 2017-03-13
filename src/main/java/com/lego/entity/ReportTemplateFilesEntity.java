package com.lego.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: 1481702
 * Date: 3/2/17
 * Time: 10:27 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "report_template_files_entity")
public class ReportTemplateFilesEntity extends BaseEntity {
    private String templateUploadValue;
    private String templateUploadName;
    private int templateUploadType;
    private String fileDescription;

    private ReportTemplateEntity reportTemplateEntity;

    @ManyToOne
    @JoinColumn(nullable = false)
    public ReportTemplateEntity getReportTemplateEntity() {
        return reportTemplateEntity;
    }

    public void setReportTemplateEntity(ReportTemplateEntity reportTemplateEntity) {
        this.reportTemplateEntity = reportTemplateEntity;
    }

    public String getTemplateUploadValue() {
        return templateUploadValue;
    }

    public void setTemplateUploadValue(String templateUploadValue) {
        this.templateUploadValue = templateUploadValue;
    }

    public String getTemplateUploadName() {
        return templateUploadName;
    }

    public void setTemplateUploadName(String templateUploadName) {
        this.templateUploadName = templateUploadName;
    }

    public int getTemplateUploadType() {
        return templateUploadType;
    }

    public void setTemplateUploadType(int templateUploadType) {
        this.templateUploadType = templateUploadType;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

}
