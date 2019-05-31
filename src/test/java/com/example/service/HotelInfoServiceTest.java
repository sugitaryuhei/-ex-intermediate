package com.example.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.HotelInfo;

/**
 * HotelInfoServiceのSearhByLessThanPrice()をテスト.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelInfoServiceTest {

	@Autowired
	private HotelInfoService service;

	/**
	 * HotelInfoServiceのsearhByLessThanPrice()をテスト.
	 */
	@Test
	public void testSearhByLessThanPrice() {
		try {
			List<HotelInfo> hotelListMinus1 = service.searhByLessThanPrice(-1);
			fail("例外が発生しなけらばなりません");
		} catch (IllegalArgumentException e) {
			assertThat("例外発生時のエラーメッセージが違います", e.getMessage(), is("価格が不正です"));
		}
		
	List<HotelInfo> hotelListPrice0 = service.searhByLessThanPrice(0);
	assertThat("価格が0の時のホテルリストの数が違います", hotelListPrice0.size(), is(0));
		
	List<HotelInfo> hotelListPrice5000 = service.searhByLessThanPrice(5000);
	assertThat("価格が5000の時のホテルリストの数が違います", hotelListPrice5000.size(), is(1));
	
	List<HotelInfo> hotelListPrice10000 = service.searhByLessThanPrice(10000);
	assertThat("価格が10000の時のホテルリストの数が違います", hotelListPrice10000.size(), is(3));
	
	List<HotelInfo> hotelListPrice20000 = service.searhByLessThanPrice(20000);
	assertThat("価格が20000の時のホテルリストの数が違います", hotelListPrice20000.size(), is(5));
	
	List<HotelInfo> hotelListPrice50000 = service.searhByLessThanPrice(50000);
	HotelInfo maxPriceHotel = hotelListPrice50000.get(0);
	HotelInfo minPriceHotel = hotelListPrice50000.get(4);
	assertThat("ホテルリストが価格順になっていません", maxPriceHotel.getPrice(), is(20000));
	assertThat("ホテルリストが価格順になっていません", minPriceHotel.getPrice(), is(5000));
	
	}
}
