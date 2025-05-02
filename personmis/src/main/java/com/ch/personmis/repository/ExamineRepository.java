package com.ch.personmis.repository;

import com.ch.personmis.entity.PeriodByCon;
import com.ch.personmis.entity.Player;
import com.ch.personmis.entity.PlayerByCon;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ExamineRepository {
     int addPlayer(Player player);
     int addPlayerCoach(Player player);
     List<Player> selectPlayer(PlayerByCon playerByCon);
     List<Map<String,Object>>  getPlayer();
     List<Map<String,Object>>  getPlayerCoach();
//     List<Staff> getStaff(StaffByCon staffByCon);
     List<Player>  selectPlayerByCon(PlayerByCon playerByCon);
     Player selectAPlayer(int id);
     int updatePlayer(Player player);
     List<Player> selectPeriodPlayer(PeriodByCon periodByCon);
     List<Player> selectPeriodPlayerCon(PeriodByCon periodByCon);
     int periodOp(@Param("id") int id, @Param("status") String status);
     List<Map<String, Object>>  selectAssociatePlayer(int id);
     int deletePlayer(int id);
     int deletePlayerCoach(int id);
}
