package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.HotelInfo;
import com.example.repository.HotelInfoRepository;

/**
 * 演習２を操作するメソッドのサービス
 * 
 * @author ryuheisugita
 */
@Service
@Transactional
public class HotelInfoService {
	
	@Autowired
	private HotelInfoRepository repository;
	
	/**
	 * 価格以下のホテル情報を取得するメソッド.
	 * 
	 * @return ホテル情報を価格の降順で取得
	 */
	public List<HotelInfo> searhByLessThanPrice(Integer price){
		if(price<0) {
			throw new IllegalArgumentException("価格が不正です");
		}
		return repository.findAllByLessThanPrice(price);
	}
	
	/**
	 * 全てのホテル情報を価格順に取得するメソッド.
	 * 
	 * @return ホテル情報を価格の降順で取得
	 */
	public List<HotelInfo> searchAll(){
		return repository.findAll();
	}
	
}
