package com.lego.dao;

import com.lego.entity.ReportTemplateEntity;
import com.lego.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 1481702
 * Date: 3/2/17
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ReportTemplateDao extends JpaRepository<ReportTemplateEntity, Integer> {
    List<ReportTemplateEntity> findByTemplateBuilderUser(UserEntity userEntity);
    List<ReportTemplateEntity> findByTemplateBuilderUserAndTemplateStatus(UserEntity userEntity,int status);
}
