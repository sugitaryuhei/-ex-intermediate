package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.TeamInfo;
import com.example.repository.Ex1Repository;

/**
 * 演習１のメソッドを操作するサービス.
 * 
 * @author ryuheisugita
 */
@Service
@Transactional
public class Ex1Service {
	
	@Autowired
	private Ex1Repository repository;
	
	/**
	 * 野球チームの情報を発足順に取得するメソッド.
	 * 
	 * @return 野球チームの情報の一覧
	 */
	public List<TeamInfo> showList(){
		return repository.showList();
	}
	
	/**
	 * チーム名からそのチームの情報を取得するメソッド.
	 * 
	 * @param チーム名
	 * @return 指定したチームの情報
	 */
	public TeamInfo showDetail(String teamName) {
		return repository.showDetail(teamName);
	}

}
