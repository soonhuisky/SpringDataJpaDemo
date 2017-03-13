package com.lego.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 1481702
 * Date: 3/2/17
 * Time: 10:31 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "report_simulation_entity")
public class ReportSimulationEntity extends BaseEntity{

    //Status为10是To Make,20是Released
    private int status = -1;
    private ReportTemplateEntity reportTemplateEntity;

    private String inputFileDir;
    private String outputFileDir;
    private String expectedFileDir;
    //private String runLogPath;
    private List<FileSimulationEntity> filesList = new ArrayList<FileSimulationEntity>();
    private String executionTime;
    private Long doiVersion;

    @ManyToOne
    @JoinColumn(nullable = false)
    public ReportTemplateEntity getReportTemplateEntity() {
        return reportTemplateEntity;
    }

    public void setReportTemplateEntity(ReportTemplateEntity reportTemplateEntity) {
        this.reportTemplateEntity = reportTemplateEntity;
    }

    public String getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }

    @OneToMany(
                cascade = CascadeType.ALL,
                fetch = FetchType.LAZY,
                mappedBy = "reportSimulationEntity"
    )
    public List<FileSimulationEntity> getFilesList() {
        return filesList;
    }

    public void setFilesList(List<FileSimulationEntity> filesList) {
        this.filesList = filesList;
    }

    public String getExpectedFileDir() {
        return expectedFileDir;
    }

    public void setExpectedFileDir(String expectedFileDir) {
        this.expectedFileDir = expectedFileDir;
    }

    public String getOutputFileDir() {
        return outputFileDir;
    }

    public void setOutputFileDir(String outputFileDir) {
        this.outputFileDir = outputFileDir;
    }

    public int getStatus() {
        return status;
    }

    public String getInputFileDir() {
        return inputFileDir;
    }

    public void setInputFileDir(String inputFileDir) {
        this.inputFileDir = inputFileDir;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public Long getDoiVersion() {
        return doiVersion;
    }

    public void setDoiVersion(Long doiVersion) {
        this.doiVersion = doiVersion;
    }
}