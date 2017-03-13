package com.lego.service;

import com.lego.entity.GroupEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 1481702
 * Date: 3/7/17
 * Time: 10:11 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class GroupService extends MainService{

    public List<GroupEntity> getAllGroup() {
        return groupDao.findAll();
    }

    public void createGroup(String groupName) {
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setGroupName(groupName);
        groupDao.save(groupEntity);
    }

    /**
     * Get Group by groupName
     * @param groupName
     * @return
     */
    public GroupEntity getGroupByName(String groupName){
        return groupDao.findByGroupName(groupName);
    }


    public GroupEntity updateGroup(GroupEntity groupEntity) {
        return groupDao.save(groupEntity);
    }

    public void deleteGroup( GroupEntity groupEntity){
        groupDao.delete(groupEntity);
    }
}
