package com.lego.dao;

import com.lego.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: 1481702
 * Date: 2/28/17
 * Time: 11:06 AM
 * To change this template use File | Settings | File Templates.
 */
public interface GroupDao extends JpaRepository<GroupEntity, Integer> {
    GroupEntity findByGroupName(String groupName);
}