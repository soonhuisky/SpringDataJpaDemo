package com.lego.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 1481702
 * Date: 2/28/17
 * Time: 10:52 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "group_entity")
public class GroupEntity extends BaseEntity {
    private List<ReportTemplateEntity> reportTemplateEntityList;
    private String groupName;

    @OneToMany( cascade = {CascadeType.PERSIST,CascadeType.MERGE},
                fetch = FetchType.LAZY,
                mappedBy = "groupEntity")
    public List<ReportTemplateEntity> getReportTemplateEntityList() {
        return reportTemplateEntityList;
    }

    public void setReportTemplateEntityList(List<ReportTemplateEntity> reportTemplateEntityList) {
        this.reportTemplateEntityList = reportTemplateEntityList;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
