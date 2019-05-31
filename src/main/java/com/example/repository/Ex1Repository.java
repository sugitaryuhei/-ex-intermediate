package com.example.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.domain.TeamInfo;

/**
 * teamsテーブルを操作するリポジトリ.
 * 
 * @author ryuheisugita
 */
@Repository
public class Ex1Repository {

	/**
	 * 野球チームの情報を発足順に取得するメソッド.
	 * 
	 * @return 野球チームの情報の一覧
	 */
	public List<TeamInfo> showList() {
		return null;
	}
	
	/**
	 * チーム名からそのチームの情報を取得するメソッド.
	 * 
	 * @param チーム名
	 * @return 指定したチームの情報
	 */
	public TeamInfo showDetail(String teamName) {
		return new TeamInfo();
	}
	
}
