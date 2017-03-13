package com.lego.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 1481702
 * Date: 2/28/17
 * Time: 10:51 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "report_template_entity")
public class ReportTemplateEntity extends BaseEntity {

    private String templateShortName;
    private String templateFullName;
    //templateStatus为０是刚刚创建,为1是Draft,2是in use,3是Retired
    private int templateStatus;
    private GroupEntity groupEntity;
    private UserEntity templateBuilderUser;
    private List<UserEntity> templateApproverList;
    private List<UserEntity> makerList;
    private List<UserEntity> checkerList;
    private List<ReportTemplateFilesEntity> templateFilesList;
    private List<ReportSimulationEntity> reportSimulationList;
    private List<ReportEntity> reportsList;

    @OneToMany(
            cascade = {CascadeType.PERSIST,CascadeType.MERGE},
            mappedBy = "reportTemplateEntity",
            fetch = FetchType.LAZY
    )
    public List<ReportEntity> getReportsList() {
        return reportsList;
    }

    public void setReportsList(List<ReportEntity> reportsList) {
        this.reportsList = reportsList;
    }

    @OneToMany(
            cascade = {CascadeType.PERSIST,CascadeType.MERGE},
            mappedBy = "reportTemplateEntity",
            fetch = FetchType.LAZY
    )
    public List<ReportSimulationEntity> getReportSimulationList() {
        return reportSimulationList;
    }

    public void setReportSimulationList(List<ReportSimulationEntity> reportSimulationList) {
        this.reportSimulationList = reportSimulationList;
    }

    @ManyToOne
    @JoinColumn(nullable = false)
    public UserEntity getTemplateBuilderUser() {
        return templateBuilderUser;
    }

    public void setTemplateBuilderUser(UserEntity templateBuilderUser) {
        this.templateBuilderUser = templateBuilderUser;
    }

    @ManyToOne
    @JoinColumn(nullable = false)
    public GroupEntity getGroupEntity() {
        return groupEntity;
    }

    @OneToMany(
            cascade = {CascadeType.PERSIST,CascadeType.MERGE},
            mappedBy = "reportTemplateEntity"
//            fetch = FetchType.LAZY
    )
    public List<ReportTemplateFilesEntity> getTemplateFilesList() {
        return templateFilesList;
    }

    public void setTemplateFilesList(List<ReportTemplateFilesEntity> templateFilesList) {
        this.templateFilesList = templateFilesList;
    }

    @ManyToMany(
//            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            targetEntity = UserEntity.class
    )
    @JoinTable(
            name = "template_approver_list",
            joinColumns = @JoinColumn(name = "report_template_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    public List<UserEntity> getTemplateApproverList() {
        return templateApproverList;
    }

    public void setTemplateApproverList(List<UserEntity> templateApproverList) {
        this.templateApproverList = templateApproverList;
    }

    @ManyToMany(
//            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            targetEntity = UserEntity.class
    )
    @JoinTable(
            name = "report_maker_list",
            joinColumns = @JoinColumn(name = "report_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    public List<UserEntity> getMakerList() {
        return makerList;
    }

    public void setMakerList(List<UserEntity> makerList) {
        this.makerList = makerList;
    }

    @ManyToMany(
//            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            targetEntity = UserEntity.class
    )
    @JoinTable(
            name = "report_checker_list",
            joinColumns = @JoinColumn(name = "report_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    public List<UserEntity> getCheckerList() {
        return checkerList;
    }

    public void setCheckerList(List<UserEntity> checkerList) {
        this.checkerList = checkerList;
    }

    public void setGroupEntity(GroupEntity groupEntity) {
        this.groupEntity = groupEntity;
    }

    public int getTemplateStatus() {
        return templateStatus;
    }

    public void setTemplateStatus(int templateStatus) {
        this.templateStatus = templateStatus;
    }

    public String getTemplateFullName() {
        return templateFullName;
    }

    public void setTemplateFullName(String templateFullName) {
        this.templateFullName = templateFullName;
    }

    public String getTemplateShortName() {
        return templateShortName;
    }

    public void setTemplateShortName(String templateShortName) {
        this.templateShortName = templateShortName;
    }

}