package com.qilinxx.innovatevolume.domain.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "article")
public class Article {
    @Id
    private String id;

    @Column(name = "cate_no")
    private String cateNo;

    @Column(name = "cate_id")
    private String cateId;

    @Column(name = "title")
    private String title;

    @Column(name = "summary")
    private String summary;

    @Column(name = "img_if")
    private String imgIf;

    @Column(name = "top_if")
    private String topIf;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "checked")
    private String checked;

    @Column(name = "org_no")
    private String orgNo;

    @Column(name = "poster")
    private String poster;

    @Column(name = "sys_no")
    private String sysNo;

    @Column(name = "read_count")
    private Integer readCount;

    @Column(name = "page_url")
    private String pageUrl;

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

    @Column(name = "content")
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCateNo() {
        return cateNo;
    }

    public void setCateNo(String cateNo) {
        this.cateNo = cateNo == null ? null : cateNo.trim();
    }

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId == null ? null : cateId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getImgIf() {
        return imgIf;
    }

    public void setImgIf(String imgIf) {
        this.imgIf = imgIf == null ? null : imgIf.trim();
    }

    public String getTopIf() {
        return topIf;
    }

    public void setTopIf(String topIf) {
        this.topIf = topIf == null ? null : topIf.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked == null ? null : checked.trim();
    }

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo == null ? null : orgNo.trim();
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster == null ? null : poster.trim();
    }

    public String getSysNo() {
        return sysNo;
    }

    public void setSysNo(String sysNo) {
        this.sysNo = sysNo == null ? null : sysNo.trim();
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl == null ? null : pageUrl.trim();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", cateNo='" + cateNo + '\'' +
                ", cateId='" + cateId + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", imgIf='" + imgIf + '\'' +
                ", topIf='" + topIf + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", checked='" + checked + '\'' +
                ", orgNo='" + orgNo + '\'' +
                ", poster='" + poster + '\'' +
                ", sysNo='" + sysNo + '\'' +
                ", readCount=" + readCount +
                ", pageUrl='" + pageUrl + '\'' +
                ", isUse='" + isUse + '\'' +
                ", creater='" + creater + '\'' +
                ", createTime=" + createTime +
                ", updater='" + updater + '\'' +
                ", updateTime=" + updateTime +
                ", remark='" + remark + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}