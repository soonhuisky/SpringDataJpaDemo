package com.lego.dao;

import com.lego.entity.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: 1481702
 * Date: 3/2/17
 * Time: 3:07 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ReportDao extends JpaRepository<ReportEntity,Integer> {
}
