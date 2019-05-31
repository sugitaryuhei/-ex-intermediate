package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.HotelInfo;
import com.example.repository.Ex2Repository;

/**
 * 演習２を操作するメソッドのサービス
 * 
 * @author ryuheisugita
 */
@Service
@Transactional
public class Ex2Service {
	
	@Autowired
	private Ex2Repository repository;
	
	/**
	 * 価格以下のホテル情報を取得するメソッド.
	 * 
	 * @return ホテル情報を価格の降順で取得
	 */
	public List<HotelInfo> searhByLessThanPrice(Integer price){
		return repository.searchByLessThanPrice(price);
	}

}
