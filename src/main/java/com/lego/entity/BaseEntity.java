package com.lego.entity;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: 1481702
 * Date: 2/27/17
 * Time: 10:49 AM
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
// 基本代码复用和模型分离的思想，使用@MappedSuperclass注解，将不同Entity中相同的属性提取成一个基类
// 比如数据库表中都需要id来表示编号，id是这些映射实体类的通用的属性，交给jpa统一生成主键id编号，
// 那么使用一个父类来封装这些通用属性，并用@MappedSuperclas标识
// 注意：
// 1.标注为@MappedSuperclass的类将不是一个完整的实体类，他将不会映射到数据库表，但是他的属性都将映射到其子类的数据库字段中
// 2.标注为@MappedSuperclass的类不能再标注@Entity或@Table注解，也无需实现序列化接口
public class BaseEntity {

    private int id;
    private Long version;
    private Date dateCreated;
    private Date lastModified;
    private boolean disabled = false;
    private boolean deleted = false;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eid",nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Version
    @Column(name="entityVersion")
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Temporal(TemporalType.TIMESTAMP)
    //For details, refer to TemporalType enum class.
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @PreUpdate
    @PrePersist
    // JPA CallBack function
    // @PrePersist 在执行给定实体的相应 EntityManager 持久操作之前，调用该实体的 @PrePersist 回调方法
    // 在针对给定实体执行相应的 EntityManager 删除操作之前，调用该给定实体的 @PreRemove 回调方法。
    // 对该操作层叠到的所有实体调用该方法。
    public void updateTimeStamps() {
        lastModified = new Date();
        if (dateCreated == null) {
            dateCreated = new Date();
        }
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id)
                .append("version", version).append("dateCreated", dateCreated)
                .append("lastModified", lastModified)
                .append("disabled", disabled).append("deleted", deleted)
                .toString();
    }

//    public void copyFrom(Object o) {
//        Class<?> clazz1 = getClass();
//        Class<?> clazz2 = o.getClass();
//        for (Method setter1 : clazz1.getMethods()) {
//            if (setter1.getName().startsWith("set")) {
//                String propName = setter1.getName().substring(3);
//                try {
//                    // Method getter1 = clazz1.getMethod("get" + propName);
//                    // Method setter2 = clazz2.getMethod("set" + propName);
//                    Method getter2 = clazz2.getMethod("get" + propName);
//                    if (getter2 != null)
//                        setter1.invoke(this, getter2.invoke(o));
//                } catch (NoSuchMethodException e) {
//                } catch (SecurityException e) {
//                } catch (IllegalAccessException e) {
//                } catch (IllegalArgumentException e) {
//                } catch (InvocationTargetException e) {
//                }
//            }
//        }
//    }

}
