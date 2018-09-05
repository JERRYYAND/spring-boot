package com.didispace.entity;

import java.io.Serializable;
import java.util.Date;

public class MemberCard implements Serializable{
    /**
	 * @author  xyl
	 */
	private static final long serialVersionUID = -9123922907462295976L;

	private String id;

    private String name;

    private String sex;

    private String nation;

    private Date birthday;

    private String cardno;

    private String cardPhoto;

    private String address;

    private String issuedBy;

    private String validDate;

    private String cardFont;

    private String cardBack;

    private String cardFontSrc;

    private String cardBackSrc;

    private Integer isReview;

    private String resultMsg;

    private Date createTime;

    private Date updateTime;

    private Integer source;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public String getCardPhoto() {
        return cardPhoto;
    }

    public void setCardPhoto(String cardPhoto) {
        this.cardPhoto = cardPhoto == null ? null : cardPhoto.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy == null ? null : issuedBy.trim();
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate == null ? null : validDate.trim();
    }

    public String getCardFont() {
        return cardFont;
    }

    public void setCardFont(String cardFont) {
        this.cardFont = cardFont == null ? null : cardFont.trim();
    }

    public String getCardBack() {
        return cardBack;
    }

    public void setCardBack(String cardBack) {
        this.cardBack = cardBack == null ? null : cardBack.trim();
    }

    public String getCardFontSrc() {
        return cardFontSrc;
    }

    public void setCardFontSrc(String cardFontSrc) {
        this.cardFontSrc = cardFontSrc == null ? null : cardFontSrc.trim();
    }

    public String getCardBackSrc() {
        return cardBackSrc;
    }

    public void setCardBackSrc(String cardBackSrc) {
        this.cardBackSrc = cardBackSrc == null ? null : cardBackSrc.trim();
    }

    public Integer getIsReview() {
        return isReview;
    }

    public void setIsReview(Integer isReview) {
        this.isReview = isReview;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg == null ? null : resultMsg.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

	@Override
	public String toString() {
		return "MemberCard [id=" + id + ", name=" + name + ", sex=" + sex + ", nation=" + nation + ", birthday="
				+ birthday + ", cardno=" + cardno + ", cardPhoto=" + cardPhoto + ", address=" + address + ", issuedBy="
				+ issuedBy + ", validDate=" + validDate + ", cardFont=" + cardFont + ", cardBack=" + cardBack
				+ ", cardFontSrc=" + cardFontSrc + ", cardBackSrc=" + cardBackSrc + ", isReview=" + isReview
				+ ", resultMsg=" + resultMsg + ", createTime=" + createTime + ", updateTime=" + updateTime + ", source="
				+ source + "]";
	}
    
}