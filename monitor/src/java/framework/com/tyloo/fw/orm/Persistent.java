package com.tyloo.fw.orm;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public abstract class Persistent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3608772614662176734L;
	private Integer isDeleted = 0;
	private Date timeModified;

	private Date timeCreate;

	private Integer lastUpdatedDate;

	private Integer createdDate;

	public Integer getCreatedDate() {
		return createdDate;
	}
	
	public Integer getIsDeleted() {
		return isDeleted;
	}


	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}


	public void setCreatedDate(Integer createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Integer lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Date getTimeCreate() {
		return timeCreate;
	}

	public void setTimeCreate(Date timeCreate) {
		this.timeCreate = timeCreate;
	}

	public Date getTimeModified() {
		return timeModified;
	}

	public void setTimeModified(Date timeModified) {
		this.timeModified = timeModified;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE).toString();
	}
}
