package com.qilinxx.innovatevolume.domain.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "provider")
public class Provider {
    @Id
    private String  id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "type")
    private String type;

    @Column(name = "establish_date")
    private Long establishDate;

    @Column(name = "staff_count")
    private Integer staffCount;

    @Column(name = "research_count")
    private Integer researchCount;

    @Column(name = "addr")
    private String addr;

    @Column(name = "bank")
    private String bank;

    @Column(name = "card_no")
    private String cardNo;

    @Column(name = "card_owner")
    private String cardOwner;

    @Column(name = "admin")
    private String admin;

    @Column(name = "admin_title")
    private String adminTitle;

    @Column(name = "admin_email")
    private String adminEmail;

    @Column(name = "admin_phone")
    private String adminPhone;

    @Column(name = "contacter")
    private String contacter;

    @Column(name = "contact_title")
    private String contactTitle;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "detail")
    private String detail;

    @Column(name = "research_content")
    private String researchContent;

    @Column(name = "result")
    private String result;

    @Column(name = "main_service")
    private String mainService;

    @Column(name = "support_unit")
    private String supportUnit;

    @Column(name = "support_admin")
    private String supportAdmin;

    @Column(name = "state")
    private String state;

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

    @Column(name = "remark")
    private String remark;

    public String  getId() {
        return id;
    }

    public void setId(String  id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(Long establishDate) {
        this.establishDate = establishDate;
    }

    public Integer getStaffCount() {
        return staffCount;
    }

    public void setStaffCount(Integer staffCount) {
        this.staffCount = staffCount;
    }

    public Integer getResearchCount() {
        return researchCount;
    }

    public void setResearchCount(Integer researchCount) {
        this.researchCount = researchCount;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getCardOwner() {
        return cardOwner;
    }

    public void setCardOwner(String cardOwner) {
        this.cardOwner = cardOwner == null ? null : cardOwner.trim();
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin == null ? null : admin.trim();
    }

    public String getAdminTitle() {
        return adminTitle;
    }

    public void setAdminTitle(String adminTitle) {
        this.adminTitle = adminTitle == null ? null : adminTitle.trim();
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail == null ? null : adminEmail.trim();
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone == null ? null : adminPhone.trim();
    }

    public String getContacter() {
        return contacter;
    }

    public void setContacter(String contacter) {
        this.contacter = contacter == null ? null : contacter.trim();
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle == null ? null : contactTitle.trim();
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail == null ? null : contactEmail.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getResearchContent() {
        return researchContent;
    }

    public void setResearchContent(String researchContent) {
        this.researchContent = researchContent == null ? null : researchContent.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getMainService() {
        return mainService;
    }

    public void setMainService(String mainService) {
        this.mainService = mainService == null ? null : mainService.trim();
    }

    public String getSupportUnit() {
        return supportUnit;
    }

    public void setSupportUnit(String supportUnit) {
        this.supportUnit = supportUnit == null ? null : supportUnit.trim();
    }

    public String getSupportAdmin() {
        return supportAdmin;
    }

    public void setSupportAdmin(String supportAdmin) {
        this.supportAdmin = supportAdmin == null ? null : supportAdmin.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        return "Provider{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", type='" + type + '\'' +
                ", establishDate=" + establishDate +
                ", staffCount=" + staffCount +
                ", researchCount=" + researchCount +
                ", addr='" + addr + '\'' +
                ", bank='" + bank + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", cardOwner='" + cardOwner + '\'' +
                ", admin='" + admin + '\'' +
                ", adminTitle='" + adminTitle + '\'' +
                ", adminEmail='" + adminEmail + '\'' +
                ", adminPhone='" + adminPhone + '\'' +
                ", contacter='" + contacter + '\'' +
                ", contactTitle='" + contactTitle + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", detail='" + detail + '\'' +
                ", researchContent='" + researchContent + '\'' +
                ", result='" + result + '\'' +
                ", mainService='" + mainService + '\'' +
                ", supportUnit='" + supportUnit + '\'' +
                ", supportAdmin='" + supportAdmin + '\'' +
                ", state='" + state + '\'' +
                ", isUse='" + isUse + '\'' +
                ", creater='" + creater + '\'' +
                ", createTime=" + createTime +
                ", updater='" + updater + '\'' +
                ", updateTime=" + updateTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}