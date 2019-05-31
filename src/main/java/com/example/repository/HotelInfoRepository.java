package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.HotelInfo;

/**
 * hotelsテーブルを操作するリポジトリ.
 * 
 * @author ryuheisugita
 */
@Repository
public class HotelInfoRepository {
	
private String tableName = "hotels";
    
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<HotelInfo> HOTELINFO_ROW_MAPPER =(rs,i) -> {
		HotelInfo hotelInfo = new HotelInfo();
		hotelInfo.setHotelName(rs.getString("hotel_name"));
		hotelInfo.setNearestStation(rs.getString("nearest_station"));
		hotelInfo.setPrice(rs.getInt("price"));
		return hotelInfo;
	};
	
	/**
	 * 価格以下のホテル情報を取得するメソッド.
	 * 
	 * @return ホテル情報を価格の降順で取得
	 */
	public List<HotelInfo> findAllByLessThanPrice(Integer price) {
		String sql = "select hotel_name,nearest_station,price from " +tableName
		                    +" where price <= :price order by price desc"; 
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		return template.query(sql,param, HOTELINFO_ROW_MAPPER);
	}
	
	/**
	 * 全てのホテル情報を価格順に取得するメソッド.
	 * 
	 * @return ホテル情報を価格の降順で取得
	 */
	public List<HotelInfo> findAll() {
		String sql = "select hotel_name,nearest_station,price from " +tableName
                           +" order by price desc"; 
		return template.query(sql, HOTELINFO_ROW_MAPPER);
	}

}
