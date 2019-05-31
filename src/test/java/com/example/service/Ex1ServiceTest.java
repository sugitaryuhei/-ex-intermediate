package com.example.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.TeamInfo;
import com.example.service.Ex1Service;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Ex1ServiceTest {

	@Autowired
	private Ex1Service service;

	/**
	 * Ex1ServiceのshowList()をテスト.
	 */
	@Test
	public void testShowList() {

		int totalTeamNumber = 6;

		List<TeamInfo> teamList = service.showList();
		TeamInfo firstTeam = teamList.get(0);
		TeamInfo lastTeam = teamList.get(totalTeamNumber - 1);

		assertThat("チームが発足順になっていません", firstTeam.getTeamName(), is("読売ジャイアンツ"));
		assertThat("チームが発足順になっていません", lastTeam.getTeamName(), is("東京ヤクルトスワローズ"));
		assertThat("チーム数が違います", teamList.size(), is(6));

	}

	/**
	 * Ex1ServiceのshowDetail()をテスト.
	 */
	@Test
	public void testShowDetail() {

		TeamInfo giants = service.showDetail("読売ジャイアンツ");
		TeamInfo baystars = service.showDetail("横浜DeNAベイスターズ");

		assertThat("読売ジャイアンツのチーム名が違います", giants.getTeamName(), is("読売ジャイアンツ"));
		assertThat("読売ジャイアンツの本拠地が違います", giants.getHeadquarters(), is("東京ドーム（東京都・文京区）"));
		assertThat("横浜DeNAベイスターズのチーム名が違います", baystars.getTeamName(), is("横浜DeNAベイスターズ"));
		assertThat("横浜DeNAベイスターズの本拠地が違います", baystars.getHeadquarters(), is("横浜スタジアム（神奈川県・横浜市中区）"));

	}

}
