package com.ch.personmis.repository;

import com.ch.personmis.entity.PeriodByCon;
import com.ch.personmis.entity.Player;
import com.ch.personmis.entity.PlayerByCon;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PlayerCoachRepository {
//     int addPlayer(Player player);
     int addPlayerCoach(Player player);
     List<Player> selectPlayerCoach(PlayerByCon playerByCon);
//     List<Player> selectPlayer(PlayerByCon playerByCon);
//     List<Map<String,Object>>  getPlayer();
     List<Map<String,Object>>  getPlayerCoach();
//     List<Staff> getStaff(StaffByCon staffByCon);
     List<Player>  selectPlayerCoachByCon(PlayerByCon playerByCon);
//     List<Player>  selectPlayerByCon(PlayerByCon playerByCon);
     Player selectAPlayerCoach(int id);
//     Player selectAPlayer(int id);
     int updatePlayerCoach(Player player);
     int updatePlayer(Player player);
     List<Player> selectPeriodPlayer(PeriodByCon periodByCon);
     List<Player> selectPeriodPlayerCon(PeriodByCon periodByCon);
     int periodOp(@Param("id") int id, @Param("status") String status);
     List<Map<String, Object>>  selectAssociatePlayer(int id);
     int deletePlayer(int id);
     int deletePlayerCoach(int id);
}
