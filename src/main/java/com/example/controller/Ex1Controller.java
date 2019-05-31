package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 演習１のアプリケーションを動かすためのコントローラー.
 * 
 * @author ryuheisugita
 */
@Controller
@RequestMapping("/ex1")
public class Ex1Controller {
	
	/**
	 * 野球チーム一覧画面を表示する.
	 * 
	 * @return 野球チーム一覧画面を表示
	 */
	@RequestMapping("/")
	public String index() {
		return "team-list";
	}
	
	/**
	 * 野球チーム詳細ページ表示する.
	 * 
	 * @return 野球チーム詳細ページ表示
	 */
	@RequestMapping("/show-detail")
	public String showDetail() {
		return "team-detail";
	}

}
