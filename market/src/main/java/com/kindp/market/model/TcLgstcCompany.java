package com.kindp.market.model;

import java.util.Date;

public class TcLgstcCompany {
    private Long lgstcCompId;

    private Long mchtId;

    private String mchtName;

    private Integer mchtType;

    private String lgstcCompCode;

    private String lgstcCompName;

    private String lgstcCompStname;

    private String lgstcCompDesc;

    private Integer lgstcCompState;

    private Integer dataState;

    private Long createOpid;

    private Date createTime;

    private Long modifyOpid;

    private Date modifyTime;

    public Long getLgstcCompId() {
        return lgstcCompId;
    }

    public void setLgstcCompId(Long lgstcCompId) {
        this.lgstcCompId = lgstcCompId;
    }

    public Long getMchtId() {
        return mchtId;
    }

    public void setMchtId(Long mchtId) {
        this.mchtId = mchtId;
    }

    public String getMchtName() {
        return mchtName;
    }

    public void setMchtName(String mchtName) {
        this.mchtName = mchtName == null ? null : mchtName.trim();
    }

    public Integer getMchtType() {
        return mchtType;
    }

    public void setMchtType(Integer mchtType) {
        this.mchtType = mchtType;
    }

    public String getLgstcCompCode() {
        return lgstcCompCode;
    }

    public void setLgstcCompCode(String lgstcCompCode) {
        this.lgstcCompCode = lgstcCompCode == null ? null : lgstcCompCode.trim();
    }

    public String getLgstcCompName() {
        return lgstcCompName;
    }

    public void setLgstcCompName(String lgstcCompName) {
        this.lgstcCompName = lgstcCompName == null ? null : lgstcCompName.trim();
    }

    public String getLgstcCompStname() {
        return lgstcCompStname;
    }

    public void setLgstcCompStname(String lgstcCompStname) {
        this.lgstcCompStname = lgstcCompStname == null ? null : lgstcCompStname.trim();
    }

    public String getLgstcCompDesc() {
        return lgstcCompDesc;
    }

    public void setLgstcCompDesc(String lgstcCompDesc) {
        this.lgstcCompDesc = lgstcCompDesc == null ? null : lgstcCompDesc.trim();
    }

    public Integer getLgstcCompState() {
        return lgstcCompState;
    }

    public void setLgstcCompState(Integer lgstcCompState) {
        this.lgstcCompState = lgstcCompState;
    }

    public Integer getDataState() {
        return dataState;
    }

    public void setDataState(Integer dataState) {
        this.dataState = dataState;
    }

    public Long getCreateOpid() {
        return createOpid;
    }

    public void setCreateOpid(Long createOpid) {
        this.createOpid = createOpid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getModifyOpid() {
        return modifyOpid;
    }

    public void setModifyOpid(Long modifyOpid) {
        this.modifyOpid = modifyOpid;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}