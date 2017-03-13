package com.lego.dao;

import com.lego.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: 1481702
 * Date: 2/28/17
 * Time: 11:05 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao extends JpaRepository<UserEntity, Integer> {
    UserEntity findByRole(String role);
    UserEntity findByUserID(String userID);
}
