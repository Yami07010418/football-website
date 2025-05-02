package com.ch.personmis.service;

import com.ch.personmis.entity.PeriodByCon;
import com.ch.personmis.entity.Player;
import com.ch.personmis.entity.PlayerByCon;

import java.util.Map;

public interface PlayerCoachService {
//    String addPlayer(Player player);
    String addPlayerCoach(Player player);
//    List<Staff> getStaff();
//     Map<String, Object> selectPlayer();
    Map<String, Object> selectPlayerCoach();
    Map<String, Object> selectPlayerCoachByPage(PlayerByCon playerByCon);
//    Map<String, Object> selectPlayerByPage(PlayerByCon playerByCon);
    Map<String, Object> selectPlayerCoachByCon(PlayerByCon playerByCon);
//    Map<String, Object> selectPlayerByCon(PlayerByCon playerByCon);
    Player getPlayerCoachDetail(int id);
//    Player getPlayerDetail(int id);
String updatePlayerCoach(Player player);
//    String updatePlayer(Player player);
//    Map<String, Object> selectPeriodsByPage(PeriodByCon periodByCon);
//    Map<String, Object> selectPeriodByCon(PeriodByCon periodByCon);
//    String periodOp(int id, String status);
//    String deletePlayer(int id);
    String deletePlayerCoach(int id);
}
