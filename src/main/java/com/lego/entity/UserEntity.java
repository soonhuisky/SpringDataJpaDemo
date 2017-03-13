package com.lego.entity;

/**
 * Created with IntelliJ IDEA.
 * User: 1481702
 * Date: 2/28/17
 * Time: 10:11 AM
 * To change this template use File | Settings | File Templates.
 */

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_entity")
public class UserEntity extends BaseEntity {

    private String userID;
    private String userName;
    private String mail;
    private String role;
    private List<ReportTemplateEntity> reportTemplateEntityList;
    private List<ReportTemplateEntity> reportTemplateApproverList;
    private List<ReportTemplateEntity> reportMakerList;
    private List<ReportTemplateEntity> reportCheckerList;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY,
            mappedBy = "templateBuilderUser")
    public List<ReportTemplateEntity> getReportTemplateEntityList() {
        return reportTemplateEntityList;
    }

    public void setReportTemplateEntityList(List<ReportTemplateEntity> reportTemplateEntityList) {
        this.reportTemplateEntityList = reportTemplateEntityList;
    }

    @ManyToMany(
            targetEntity = ReportTemplateEntity.class,
            mappedBy = "templateApproverList",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    public List<ReportTemplateEntity> getReportTemplateApproverList() {
        return reportTemplateApproverList;
    }

    public void setReportTemplateApproverList(List<ReportTemplateEntity> reportTemplateApproverList) {
        this.reportTemplateApproverList = reportTemplateApproverList;
    }

    @ManyToMany(
            targetEntity = ReportTemplateEntity.class,
            mappedBy = "makerList",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    public List<ReportTemplateEntity> getReportMakerList() {
        return reportMakerList;
    }

    public void setReportMakerList(List<ReportTemplateEntity> reportMakerList) {
        this.reportMakerList = reportMakerList;
    }

    @ManyToMany(
            targetEntity = ReportTemplateEntity.class,
            mappedBy = "checkerList",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    public List<ReportTemplateEntity> getReportCheckerList() {
        return reportCheckerList;
    }

    public void setReportCheckerList(List<ReportTemplateEntity> reportCheckerList) {
        this.reportCheckerList = reportCheckerList;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}