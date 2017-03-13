package com.lego.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 1481700
 * Date: 14-8-7
 * Time: 下午2:35
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "report_entity")
public class ReportEntity extends BaseEntity {

    private String reportShortName;
    private ReportTemplateEntity reportTemplateEntity;
    private String inputFileDir;
    private String outputFileDir;
    private String startTime;
    private List<FileEntity> filesList = new ArrayList<FileEntity>();

//    private List<LogEntity> logEntityList = new ArrayList<LogEntity>();
    private Long doiVersion;
    private String runTime;
    private String realMaker;
    private String realChecker;

    @ManyToOne
    @JoinColumn(nullable = false)
    public ReportTemplateEntity getReportTemplateEntity() {
        return reportTemplateEntity;
    }

    public void setReportTemplateEntity(ReportTemplateEntity reportTemplateEntity) {
        this.reportTemplateEntity = reportTemplateEntity;
    }

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "reportEntity"
    )
    public List<FileEntity> getFilesList() {
        return filesList;
    }

    public void setFilesList(List<FileEntity> filesList) {
        this.filesList = filesList;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }


    public String getInputFileDir() {
        return inputFileDir;
    }

    public void setInputFileDir(String inputFileDir) {
        this.inputFileDir = inputFileDir;
    }

    public String getOutputFileDir() {
        return outputFileDir;
    }

    public void setOutputFileDir(String outputFileDir) {
        this.outputFileDir = outputFileDir;
    }

    public String getReportShortName() {
        return reportShortName;
    }

    public void setReportShortName(String reportShortName) {
        this.reportShortName = reportShortName;
    }

    public Long getDoiVersion() {
        return doiVersion;
    }

    public void setDoiVersion(Long doiVersion) {
        this.doiVersion = doiVersion;
    }

    public String getRealMaker() {
        return realMaker;
    }

    public void setRealMaker(String realMaker) {
        this.realMaker = realMaker;
    }

    public String getRealChecker() {
        return realChecker;
    }

    public void setRealChecker(String realChecker) {
        this.realChecker = realChecker;
    }
}
