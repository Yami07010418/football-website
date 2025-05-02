package com.ch.personmis.service;

import com.ch.personmis.entity.PeriodByCon;
import com.ch.personmis.entity.Player;
import com.ch.personmis.entity.PlayerByCon;
import com.ch.personmis.repository.PlayerCoachRepository;
import com.ch.personmis.repository.PlayerRepository;
import com.ch.personmis.util.MyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlayerCoachServiceImpl implements PlayerCoachService {
    @Resource
    private PlayerCoachRepository playerCoachRepository;

    @Override
    public String addPlayerCoach(Player player) {
        byte[] myfile = player.getLogoFile();
        if(myfile != null && myfile.length > 0) {
            String path = "D:\\VUE\\personmis-vue\\src\\assets";
            //获得上传文件原名
            String fileName = player.getFileName();
            //对文件重命名
            String fileNewName = MyUtil.getNewFileName(fileName);
            File filePath = new File(path + File.separator + fileNewName);
            //如果文件目录不存在，创建目录
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
            }
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(filePath);
                out.write(myfile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //将重命名后的图片名存到player对象中，添加时使用
            player.setPicture(fileNewName);
        }
        if(playerCoachRepository.addPlayerCoach(player) > 0)
            return "ok";
        return "no";
    }

//    @Override
//    public List<Staff> getStaff() {
//        return staffRepository.getStaff(null);
//    }
    @Override
    public Map<String, Object> selectPlayerCoach() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> PlayerList = playerCoachRepository.getPlayerCoach();
        map.put("player", PlayerList);
        return map;
    }


    @Override
    public Map<String, Object> selectPlayerCoachByPage(PlayerByCon playerByCon) {
        Map<String, Object> map = new HashMap<String, Object>();
        playerByCon.setAct("byPage");
        List<Player> players = playerCoachRepository.selectPlayerCoach(playerByCon);
        map.put("players", players);
        playerByCon.setAct("byNoPage");
        map.put("total", playerCoachRepository.selectPlayerCoach(playerByCon).size());
        return map;
    }
//    @Override
//    public Map<String, Object> selectPlayerCoachByPage(PlayerByCon playerByCon) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        playerByCon.setAct("byPage");
//        List<Player> players = playerCoachRepository.selectPlayerCoach(playerByCon);
//        map.put("players", players);
//        playerByCon.setAct("byNoPage");
//        map.put("total", playerCoachRepository.selectPlayerCoach(playerByCon).size());
//        return map;
//    }

    @Override
    public Map<String, Object> selectPlayerCoachByCon(PlayerByCon playerByCon) {
        Map<String, Object> map = new HashMap<String, Object>();
        playerByCon.setAct("byPage");
        List<Player> players = playerCoachRepository.selectPlayerCoachByCon(playerByCon);
        map.put("players", players);
        playerByCon.setAct("byNoPage");
        map.put("total", playerCoachRepository.selectPlayerCoachByCon(playerByCon).size());
        return map;
    }

    @Override
    public Player getPlayerCoachDetail(int id) {
        return playerCoachRepository.selectAPlayerCoach(id);
    }

    @Override
    public String updatePlayerCoach(Player player) {
        if(playerCoachRepository.updatePlayerCoach(player) > 0)
            return "ok";
        return "no";
    }
    //试用期管理
//    @Override
//    public Map<String, Object> selectPeriodsByPage(PeriodByCon periodByCon) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        periodByCon.setAct("byPage");
//        List<Player> periods = playerCoachRepository.selectPeriodPlayer(periodByCon);
//        map.put("periods", periods);
//        periodByCon.setAct("byNoPage");
//        map.put("total", playerCoachRepository.selectPeriodPlayer(periodByCon).size());
//        return map;
//    }
//
//    @Override
//    public Map<String, Object> selectPeriodByCon(PeriodByCon periodByCon) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        periodByCon.setAct("byPage");
//        List<Player> periods = playerCoachRepository.selectPeriodPlayerCon(periodByCon);
//        map.put("periods", periods);
//        periodByCon.setAct("byNoPage");
//        map.put("total", playerCoachRepository.selectPeriodPlayerCon(periodByCon).size());
//        return map;
//    }
//
//    @Override
//    public String periodOp(int id, String status) {
//        if (playerCoachRepository.periodOp(id, status) > 0)
//            return "ok";
//        return "no";
//    }

//    @Override
//    public String deletePlayer(int id) {
//        //先查询是否有关联数据
//        List<Map<String, Object>>  listMap =playerCoachRepository.selectAssociatePlayer(id);
//        if (listMap.size() <= 0) {
//            if (playerCoachRepository.deletePlayer(id) > 0)
//                return "ok";
//        }
//        return "no";
//    }
    @Override
    public String deletePlayerCoach(int id) {
        //先查询是否有关联数据
//        List<Map<String, Object>>  listMap =playerRepository.selectAssociatePlayer(id);
//        if (listMap.size() <= 0) {
            if (playerCoachRepository.deletePlayerCoach(id) > 0){
                return "ok";
            }

//        }
        return "no";
    }
}
