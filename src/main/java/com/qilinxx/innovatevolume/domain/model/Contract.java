package com.qilinxx.innovatevolume.domain.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "contract")
public class Contract {
    @Id
    private String id;

    @Column(name = "enterprise_id")
    private String enterpriseId;

    @Column(name = "provider_id")
    private String providerId;

    @Column(name = "apply_id")
    private String applyId;

    @Column(name = "money")
    private BigDecimal money;

    @Column(name = "name")
    private String name;

    @Column(name = "path")
    private String path;

    @Column(name = "voumoney")
    private BigDecimal voumoney;

    @Column(name = "type")
    private String type;

    @Column(name = "start_date")
    private Long startDate;

    @Column(name = "sign_date")
    private Long signDate;

    @Column(name = "remark")
    private String remark;

    @Column(name = "is_use")
    private String isUse;

    @Column(name = "creater")
    private String creater;

    @Column(name = "create_time")
    private Long createTime;

    @Column(name = "updater")
    private String updater;

    @Column(name = "update_time")
    private Long updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId == null ? null : enterpriseId.trim();
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId == null ? null : providerId.trim();
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public BigDecimal getVoumoney() {
        return voumoney;
    }

    public void setVoumoney(BigDecimal voumoney) {
        this.voumoney = voumoney;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getSignDate() {
        return signDate;
    }

    public void setSignDate(Long signDate) {
        this.signDate = signDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getIsUse() {
        return isUse;
    }

    public void setIsUse(String isUse) {
        this.isUse = isUse == null ? null : isUse.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id='" + id + '\'' +
                ", enterpriseId='" + enterpriseId + '\'' +
                ", providerId='" + providerId + '\'' +
                ", applyId='" + applyId + '\'' +
                ", money=" + money +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", voumoney=" + voumoney +
                ", type='" + type + '\'' +
                ", startDate=" + startDate +
                ", signDate=" + signDate +
                ", remark='" + remark + '\'' +
                ", isUse='" + isUse + '\'' +
                ", creater='" + creater + '\'' +
                ", createTime=" + createTime +
                ", updater='" + updater + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}