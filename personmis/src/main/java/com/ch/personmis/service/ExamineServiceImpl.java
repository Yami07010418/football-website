package com.ch.personmis.service;

import com.ch.personmis.entity.PeriodByCon;
import com.ch.personmis.entity.Player;
import com.ch.personmis.entity.PlayerByCon;
import com.ch.personmis.repository.ExamineRepository;
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
public class ExamineServiceImpl implements ExamineService {
    @Resource
    private ExamineRepository examineRepository;
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
        if(examineRepository.addPlayer(player) > 0)
            return "ok";
        return "no";
    }

    @Override
    public String addPlayerCoach(Player player) {
        byte[] myfile = player.getLogoFile();
        if(myfile != null && myfile.length > 0) {
            String path = "D:\\VUE\\personmis-vue\\src\\assets";//绝对路径
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
//                建一个文件输出流，指向目标文件 filePath，以便将数据写入该文件。
                out.write(myfile);
//                通过文件输出流将字节数组 myfile 写入到目标文件中。
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //将重命名后的图片名存到card对象中，添加时使用
            player.setPicture(fileNewName);
//            将文件重命名后的名称（fileNewName）存储到 player 对象中的图片属性中。这里假设 player 是一个对象，并且有一个名为 setPicture 的方法，用于设置图片属性。
//            try 里面是可能出现的 异常块
        }
        if(examineRepository.addPlayerCoach(player) > 0)
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
            List<Map<String, Object>> PlayerList = examineRepository.getPlayer();
            map.put("player", PlayerList);
        return map;
    }
    @Override
    public Map<String, Object> selectPlayerCoach() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> PlayerList = examineRepository.getPlayerCoach();
//        List集合中每一个对象都是Map类型
        map.put("player", PlayerList);
        return map;
    }
    @Override
    public Map<String, Object> selectPlayerByPage(PlayerByCon playerByCon) {
        Map<String, Object> map = new HashMap<String, Object>();
        playerByCon.setAct("byPage");
        List<Player> players = examineRepository.selectPlayer(playerByCon);
        map.put("players", players);
        playerByCon.setAct("byNoPage");
        map.put("total", examineRepository.selectPlayer(playerByCon).size());
        return map;
    }

    @Override
    public Map<String, Object> selectPlayerByCon(PlayerByCon playerByCon) {
        Map<String, Object> map = new HashMap<String, Object>();
        playerByCon.setAct("byPage");
        List<Player> players = examineRepository.selectPlayerByCon(playerByCon);
        map.put("players", players);
        playerByCon.setAct("byNoPage");
        map.put("total", examineRepository.selectPlayerByCon(playerByCon).size());
        return map;
    }

    @Override
    public Player getPlayerDetail(int id) {
        return examineRepository.selectAPlayer(id);
    }

    @Override
    public String updatePlayer(Player player) {
        if(examineRepository.updatePlayer(player) > 0)
            return "ok";
        return "no";
    }
    //试用期管理
    @Override
    public Map<String, Object> selectPeriodsByPage(PeriodByCon periodByCon) {
        Map<String, Object> map = new HashMap<String, Object>();
        periodByCon.setAct("byPage");
        List<Player> periods = examineRepository.selectPeriodPlayer(periodByCon);
        map.put("periods", periods);
        periodByCon.setAct("byNoPage");
        map.put("total", examineRepository.selectPeriodPlayer(periodByCon).size());
        return map;
    }

    @Override
    public Map<String, Object> selectPeriodByCon(PeriodByCon periodByCon) {
        Map<String, Object> map = new HashMap<String, Object>();
        periodByCon.setAct("byPage");
        List<Player> periods = examineRepository.selectPeriodPlayerCon(periodByCon);
        map.put("periods", periods);
        periodByCon.setAct("byNoPage");
        map.put("total", examineRepository.selectPeriodPlayerCon(periodByCon).size());
        return map;
    }

    @Override
    public String periodOp(int id, String status) {
        if (examineRepository.periodOp(id, status) > 0)
            return "ok";
        return "no";
    }

    @Override
    public String deletePlayer(int id) {
        //先查询是否有关联数据
        List<Map<String, Object>>  listMap =examineRepository.selectAssociatePlayer(id);
        if (listMap.size() <= 0) {
            if (examineRepository.deletePlayer(id) > 0)
                return "ok";
        }
        return "no";
    }
    @Override
    public String deletePlayerCoach(int id) {
        //先查询是否有关联数据
//        List<Map<String, Object>>  listMap =playerRepository.selectAssociatePlayer(id);
//        if (listMap.size() <= 0) {
            if (examineRepository.deletePlayerCoach(id) > 0){
                return "ok";
            }

//        }
        return "no";
    }
}
