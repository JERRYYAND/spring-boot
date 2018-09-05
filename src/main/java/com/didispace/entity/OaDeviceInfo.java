package com.didispace.entity;

import java.io.Serializable;
import java.util.Date;

public class OaDeviceInfo implements Serializable{
    /**
	 * @author  xyl
	 */
	private static final long serialVersionUID = -916409363856796204L;

	private String id;

    private String deviceId;

    private String versionname;

    private Integer personnumber;

    private Integer attendancenumber;

    private String overplusstorager;

    private Date createTime;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getVersionname() {
        return versionname;
    }

    public void setVersionname(String versionname) {
        this.versionname = versionname == null ? null : versionname.trim();
    }

    public Integer getPersonnumber() {
        return personnumber;
    }

    public void setPersonnumber(Integer personnumber) {
        this.personnumber = personnumber;
    }

    public Integer getAttendancenumber() {
        return attendancenumber;
    }

    public void setAttendancenumber(Integer attendancenumber) {
        this.attendancenumber = attendancenumber;
    }

    public String getOverplusstorager() {
		return overplusstorager;
	}

	public void setOverplusstorager(String overplusstorager) {
		this.overplusstorager = overplusstorager;
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
}