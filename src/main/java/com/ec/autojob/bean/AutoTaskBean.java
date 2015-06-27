package com.ec.autojob.bean;
/**
 * 
 * ClassName: AutoTaskBean <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2015年6月24日 下午6:54:34 <br/>
 *
 * @author xxg
 * @version 
 * @since JDK 1.7
 */
public class AutoTaskBean {
	
	private int id;
	private String taskcode;
	private String taskName;
	private String exectime;
	private String lastStartDate;
	private String lastEndDate;
	private String starting;
	private String taskPath;
	private int frequence;
	private String taskType;
	private String flag;
	private String createUser;
	private String createDate;
	private String updateUser;
	private String updateDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTaskcode() {
		return taskcode;
	}
	public void setTaskcode(String taskcode) {
		this.taskcode = taskcode;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getExectime() {
		return exectime;
	}
	public void setExectime(String exectime) {
		this.exectime = exectime;
	}
	public String getLastStartDate() {
		return lastStartDate;
	}
	public void setLastStartDate(String lastStartDate) {
		this.lastStartDate = lastStartDate;
	}
	public String getLastEndDate() {
		return lastEndDate;
	}
	public void setLastEndDate(String lastEndDate) {
		this.lastEndDate = lastEndDate;
	}
	public String getStarting() {
		return starting;
	}
	public void setStarting(String starting) {
		this.starting = starting;
	}
	public String getTaskPath() {
		return taskPath;
	}
	public void setTaskPath(String taskPath) {
		this.taskPath = taskPath;
	}
	public int getFrequence() {
		return frequence;
	}
	public void setFrequence(int frequence) {
		this.frequence = frequence;
	}
	public String getTaskType() {
		return taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

}
