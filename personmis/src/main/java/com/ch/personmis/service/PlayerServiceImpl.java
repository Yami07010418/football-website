package com.ch.personmis.service;

import com.ch.personmis.entity.*;
import com.ch.personmis.repository.PlayerRepository;
import com.ch.personmis.repository.StaffRepository;
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
public class PlayerServiceImpl implements PlayerService {
    @Resource
    private PlayerRepository playerRepository;
    @Override
    public String addPlayer(Player player) {
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
            //将重命名后的图片名存到card对象中，添加时使用
            player.setPicture(fileNewName);
        }
        if(playerRepository.addPlayer(player) > 0)
            return "ok";
        return "no";
    }

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
            //将重命名后的图片名存到card对象中，添加时使用
            player.setPicture(fileNewName);
        }
        if(playerRepository.addPlayerCoach(player) > 0)
            return "ok";
        return "no";
    }

//    @Override
//    public List<Staff> getStaff() {
//        return staffRepository.getStaff(null);
//    }
    @Override
    public Map<String, Object> selectPlayer() {
        Map<String, Object> map = new HashMap<String, Object>();
            List<Map<String, Object>> PlayerList = playerRepository.getPlayer();
            map.put("player", PlayerList);
        return map;
    }
    @Override
    public Map<String, Object> selectPlayerCoach() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> PlayerList = playerRepository.getPlayerCoach();
        map.put("player", PlayerList);
        return map;
    }
    @Override
    public Map<String, Object> selectPlayerByPage(PlayerByCon playerByCon) {
        Map<String, Object> map = new HashMap<String, Object>();
        playerByCon.setAct("byPage");
        List<Player> players = playerRepository.selectPlayer(playerByCon);
        map.put("players", players);
        playerByCon.setAct("byNoPage");
        map.put("total", playerRepository.selectPlayer(playerByCon).size());
        return map;
    }

    @Override
    public Map<String, Object> selectPlayerByCon(PlayerByCon playerByCon) {
        Map<String, Object> map = new HashMap<String, Object>();
        playerByCon.setAct("byPage");
        List<Player> players = playerRepository.selectPlayerByCon(playerByCon);
        map.put("players", players);
        playerByCon.setAct("byNoPage");
        map.put("total", playerRepository.selectPlayerByCon(playerByCon).size());
        return map;
    }

    @Override
    public Player getPlayerDetail(int id) {
        return playerRepository.selectAPlayer(id);
    }

    @Override
    public String updatePlayer(Player player) {
        if(playerRepository.updatePlayer(player) > 0)
            return "ok";
        return "no";
    }
    //试用期管理
    @Override
    public Map<String, Object> selectPeriodsByPage(PeriodByCon periodByCon) {
        Map<String, Object> map = new HashMap<String, Object>();
        periodByCon.setAct("byPage");
        List<Player> periods = playerRepository.selectPeriodPlayer(periodByCon);
        map.put("periods", periods);
        periodByCon.setAct("byNoPage");
        map.put("total", playerRepository.selectPeriodPlayer(periodByCon).size());
        return map;
    }

    @Override
    public Map<String, Object> selectPeriodByCon(PeriodByCon periodByCon) {
        Map<String, Object> map = new HashMap<String, Object>();
        periodByCon.setAct("byPage");
        List<Player> periods = playerRepository.selectPeriodPlayerCon(periodByCon);
        map.put("periods", periods);
        periodByCon.setAct("byNoPage");
        map.put("total", playerRepository.selectPeriodPlayerCon(periodByCon).size());
        return map;
    }

    @Override
    public String periodOp(int id, String status) {
        if (playerRepository.periodOp(id, status) > 0)
            return "ok";
        return "no";
    }

    @Override
    public String deletePlayer(int id) {
        //先查询是否有关联数据
        List<Map<String, Object>>  listMap =playerRepository.selectAssociatePlayer(id);
        if (listMap.size() <= 0) {
            if (playerRepository.deletePlayer(id) > 0)
                return "ok";
        }
        return "no";
    }



    @Override
    public String deletePlayerCoach(int id) {
        //先查询是否有关联数据
//        List<Map<String, Object>>  listMap =playerRepository.selectAssociatePlayer(id);
//        if (listMap.size() <= 0) {
            if (playerRepository.deletePlayerCoach(id) > 0){
                return "ok";
            }

//        }
        return "no";
    }
}
