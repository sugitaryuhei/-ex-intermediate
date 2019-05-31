package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.TeamInfo;

/**
 * teamsテーブルを操作するリポジトリ.
 * 
 * @author ryuheisugita
 */
@Repository
public class TeamInfoRepository {
	
	private String tableName = "teams";
    
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<TeamInfo> TEAMINFO_ROW_MAPPER =(rs,i) -> {
		TeamInfo teamInfo = new TeamInfo();
		teamInfo.setTeamName(rs.getString("team_name"));
		teamInfo.setHeadquarters(rs.getString("headquarters"));
		teamInfo.setInauguration(rs.getString("inauguration"));
		teamInfo.setHistory(rs.getString("history"));
		return teamInfo;
	};
	
	/**
	 * 野球チームの情報を発足順に取得するメソッド.
	 * 
	 * @return 野球チームの情報の一覧
	 */
	public List<TeamInfo> showList() {
		String sql = "select team_name,headquarters,inauguration,history from " +tableName
		                    +" order by inauguration"; 
		return template.query(sql, TEAMINFO_ROW_MAPPER);
	}
	
	/**
	 * チーム名からそのチームの情報を取得するメソッド.
	 * 
	 * @param チーム名
	 * @return 指定したチームの情報
	 */
	public TeamInfo showDetail(String teamName) {
		String sql = "select team_name,headquarters,inauguration,history from " +tableName + 
						     " where team_name=:teamName";
		SqlParameterSource param = new MapSqlParameterSource().addValue("teamName", teamName);
		return template.queryForObject(sql, param, TEAMINFO_ROW_MAPPER);
	}
	
}
