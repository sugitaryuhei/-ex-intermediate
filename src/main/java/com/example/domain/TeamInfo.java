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
	private String headquarters;
	/** 発足 */
	private String inauguration;
	/** 歴史 */
	private String history;
	
	@Override
	public String toString() {
		return "TeamInfo [teamName=" + teamName + ", headquarters=" + headquarters + ", inauguration=" + inauguration
				+ ", history=" + history + "]";
	}
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getHeadquarters() {
		return headquarters;
	}
	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}
	public String getInauguration() {
		return inauguration;
	}
	public void setInauguration(String inauguration) {
		this.inauguration = inauguration;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	
}
