package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.TeamInfo;
import com.example.service.TeamInfoService;

/**
 * 演習１のアプリケーションを動かすためのコントローラー.
 * 
 * @author ryuheisugita
 */
@Controller
@RequestMapping("/ex1")
public class Ex1Controller {
	
	@Autowired
	private TeamInfoService service;
	
	/**
	 * 野球チーム一覧画面を表示する.
	 * 
	 * @return 野球チーム一覧画面を表示
	 */
	@RequestMapping("")
	public String index(Model model) {
		List<TeamInfo> teamList = service.showList(); 
		model.addAttribute("teamList", teamList);
		System.out.println("list");
		return "team-list";
	}
	
	/**
	 * 野球チーム詳細ページ表示する.
	 * 
	 * @return 野球チーム詳細ページ表示
	 */
	@RequestMapping("/show-detail")
	public String showDetail(String teamName, Model model) {
		TeamInfo teamInfo = new TeamInfo();
		teamInfo = service.showDetail(teamName);
		model.addAttribute("teamInfo", teamInfo);
		return "show-detail";
	}

}
