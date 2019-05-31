package com.example.domain;

import java.util.Date;

/**
 * 野球チームの情報のドメイン.
 * 
 * @author ryuheisugita
 */
public class TeamInfo {
	
	/** 球団名 */
	private String teamName;
	/** 本拠地 */
	private String headquaters;
	/** 発足 */
	private Date inauguration;
	/** 歴史 */
	private String history;
	
	@Override
	public String toString() {
		return "TeamInfo [teamName=" + teamName + ", headquaters=" + headquaters + ", inauguration=" + inauguration
				+ ", history=" + history + "]";
	}
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getHeadquaters() {
		return headquaters;
	}
	public void setHeadquaters(String headquaters) {
		this.headquaters = headquaters;
	}
	public Date getInauguration() {
		return inauguration;
	}
	public void setInauguration(Date inauguration) {
		this.inauguration = inauguration;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	
}
