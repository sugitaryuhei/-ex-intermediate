package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.HotelInfo;
import com.example.service.HotelInfoService;

/**
 * 演習２のアプリケーションを動かすコントローラー.
 * 
 * @author ryuheisugita
 */
@Controller
@RequestMapping("/ex2")
public class Ex2Controller {
	
	@Autowired
	private HotelInfoService service;
	
	/**
	 * ホテル検索画面を表示する.
	 * 
	 * @return ホテル検索画面
	 */
	@RequestMapping("")
	public String index() {
		return "hotel-search";
	}
	
	/**
	 * 入力された価格以下のホテルを表示する.
	 * 入力された値がない場合は全てのホテル情報を表示する.
	 * 
	 * @param price 検索するための価格
	 * @return 得られたホテル情報が表示されたホテル検索画面
	 */
	@RequestMapping("/search")
	public String search(String price, Model model) {
		if(price == "") {			
			List<HotelInfo> hotelList = service.searchAll();
			model.addAttribute("hotelList", hotelList);
		}else {
		List<HotelInfo> hotelList = service.searhByLessThanPrice(Integer.parseInt(price));
		model.addAttribute("hotelList", hotelList);
		}
		return "hotel-search";
	}

}
