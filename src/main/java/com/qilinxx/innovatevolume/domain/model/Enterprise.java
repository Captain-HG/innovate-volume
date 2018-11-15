package com.qilinxx.innovatevolume.domain.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "enterprise")
public class Enterprise {
    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "admin")
    private String admin;

    @Column(name = "reg_date")
    private Long regDate;

    @Column(name = "found_date")
    private Long foundDate;

    @Column(name = "reg_money")
    private BigDecimal regMoney;

    @Column(name = "reg_addr")
    private String regAddr;

    @Column(name = "contact_addr")
    private String contactAddr;

    @Column(name = "sales")
    private BigDecimal sales;

    @Column(name = "taxs")
    private BigDecimal taxs;

    @Column(name = "net_assets")
    private BigDecimal netAssets;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "type")
    private String type;

    @Column(name = "domain")
    private String domain;

    @Column(name = "identify")
    private String identify;

    @Column(name = "identify_no")
    private String identifyNo;

    @Column(name = "detail")
    private String detail;

    @Column(name = "bank")
    private String bank;

    @Column(name = "card_no")
    private String cardNo;

    @Column(name = "card_owner")
    private String cardOwner;

    @Column(name = "contacter")
    private String contacter;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "contact_email")
    private String contactEmail;

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

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin == null ? null : admin.trim();
    }

    public Long getRegDate() {
        return regDate;
    }

    public void setRegDate(Long regDate) {
        this.regDate = regDate;
    }

    public Long getFoundDate() {
        return foundDate;
    }

    public void setFoundDate(Long foundDate) {
        this.foundDate = foundDate;
    }

    public BigDecimal getRegMoney() {
        return regMoney;
    }

    public void setRegMoney(BigDecimal regMoney) {
        this.regMoney = regMoney;
    }

    public String getRegAddr() {
        return regAddr;
    }

    public void setRegAddr(String regAddr) {
        this.regAddr = regAddr == null ? null : regAddr.trim();
    }

    public String getContactAddr() {
        return contactAddr;
    }

    public void setContactAddr(String contactAddr) {
        this.contactAddr = contactAddr == null ? null : contactAddr.trim();
    }

    public BigDecimal getSales() {
        return sales;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }

    public BigDecimal getTaxs() {
        return taxs;
    }

    public void setTaxs(BigDecimal taxs) {
        this.taxs = taxs;
    }

    public BigDecimal getNetAssets() {
        return netAssets;
    }

    public void setNetAssets(BigDecimal netAssets) {
        this.netAssets = netAssets;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify == null ? null : identify.trim();
    }

    public String getIdentifyNo() {
        return identifyNo;
    }

    public void setIdentifyNo(String identifyNo) {
        this.identifyNo = identifyNo == null ? null : identifyNo.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
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

    public String getContacter() {
        return contacter;
    }

    public void setContacter(String contacter) {
        this.contacter = contacter == null ? null : contacter.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail == null ? null : contactEmail.trim();
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
        return "Enterprise{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", admin='" + admin + '\'' +
                ", regDate=" + regDate +
                ", foundDate=" + foundDate +
                ", regMoney=" + regMoney +
                ", regAddr='" + regAddr + '\'' +
                ", contactAddr='" + contactAddr + '\'' +
                ", sales=" + sales +
                ", taxs=" + taxs +
                ", netAssets=" + netAssets +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", domain='" + domain + '\'' +
                ", identify='" + identify + '\'' +
                ", identifyNo='" + identifyNo + '\'' +
                ", detail='" + detail + '\'' +
                ", bank='" + bank + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", cardOwner='" + cardOwner + '\'' +
                ", contacter='" + contacter + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", remark='" + remark + '\'' +
                ", isUse='" + isUse + '\'' +
                ", creater='" + creater + '\'' +
                ", createTime=" + createTime +
                ", updater='" + updater + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}