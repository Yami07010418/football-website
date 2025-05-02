package com.ch.personmis.controller;

import com.ch.personmis.entity.Player;
import com.ch.personmis.entity.PlayerByCon;
import com.ch.personmis.service.PlayerCoachService;
import com.ch.personmis.service.PlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

@RestController
public class PlayerCoachController {
    @Resource
    private PlayerCoachService playerCoachService;
    private static String fileName;
    private static byte[] filecontent;
    @PostMapping("/fileInit1")
    public void fileInit(@RequestBody MultipartFile file) {
//        MultipartFile对象不能在另一个方法中使用，所以把文件对象变成字节数组
        try {
            filecontent = file.getBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileName = file.getOriginalFilename();
    }

    @PostMapping("/addPlayerCoach")//前端接受的数据长什么样子
    public  String addPlayerCoach(@RequestBody Player player ){
        player.setFileName(fileName);
        player.setLogoFile(filecontent);
        return playerCoachService.addPlayerCoach(player);
    }

    @GetMapping("/getPlayerCoachByPage")
    public Map<String, Object> selectPlayerCoachByPage(PlayerByCon playerByCon) {
        return playerCoachService.selectPlayerCoachByPage(playerByCon);
    }
    @PostMapping("/selectPlayerCoachByCon")
    public Map<String, Object> selectPlayerByCon(@RequestBody PlayerByCon playerByCon){
        return playerCoachService.selectPlayerCoachByCon(playerByCon);
    }
    @GetMapping("/getPlayerCoachDetail")
    public Player getPlayerDetail(int id){
        return playerCoachService.getPlayerCoachDetail(id);
    }
    @PostMapping("/updatePlayerCoach")
    public  String updatePlayer(@RequestBody Player player ){
        return playerCoachService.updatePlayerCoach(player);
    }
//    //试用期管理
//    @GetMapping("/getPeriods")
//    public Map<String, Object> selectPeriodsByPage(PeriodByCon periodByCon) {
//        return playerService.selectPeriodsByPage(periodByCon);
//    }
//    @PostMapping("/selectPeriodByCon")
//    public Map<String, Object> selectPeriodByCon(@RequestBody PeriodByCon periodByCon){
//        return playerService.selectPeriodByCon(periodByCon);
//    }
//    @PostMapping("/periodOp")
//    public String periodOp(int id, String status){
//        return playerService.periodOp(id, status);
//    }
    @PostMapping("/deletePlayerCoach")
    public  String deletePlayerCoach(int id){
        return playerCoachService.deletePlayerCoach(id);
    }
    @GetMapping("/getplayercoach")
    public Map<String, Object> selectPlayerCoach() {
//        System.out.println();
        return playerCoachService.selectPlayerCoach();
    }

}
