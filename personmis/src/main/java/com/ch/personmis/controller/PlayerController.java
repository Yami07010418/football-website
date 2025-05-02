package com.ch.personmis.controller;

import com.ch.personmis.entity.*;
import com.ch.personmis.service.PlayerService;
import com.ch.personmis.service.StaffService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

@RestController
public class PlayerController {
    @Resource
    private PlayerService playerService;
    private static String fileName;
    private static byte[] filecontent;
    @PostMapping("/fileInit")
    public void fileInit(@RequestBody MultipartFile file) {
//        MultipartFile对象不能在另一个方法中使用，所以把文件对象变成字节数组
        try {
            filecontent = file.getBytes();
//            fileInit() 方法中将 MultipartFile 对象转换为字节数组，并获取文件
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileName = file.getOriginalFilename();
    }
    @PostMapping("/addPlayer")//前端接受的数据长什么样子
    public  String addPlayer(@RequestBody Player player ){
        player.setFileName(fileName);
        player.setLogoFile(filecontent);
        return playerService.addPlayer(player);
    }

//    @PostMapping("/addPlayerCoach")//前端接受的数据长什么样子
//    public  String addPlayerCoach(@RequestBody Player player ){
//        player.setFileName(fileName);
//        player.setLogoFile(filecontent);
//        return playerService.addPlayerCoach(player);
//    }

    @GetMapping("/getPlayerByPage")
    public Map<String, Object> selectPlayerByPage(PlayerByCon playerByCon) {
        return playerService.selectPlayerByPage(playerByCon);
    }
    @PostMapping("/selectPlayerByCon")
    public Map<String, Object> selectPlayerByCon(@RequestBody PlayerByCon playerByCon){
        return playerService.selectPlayerByCon(playerByCon);
    }
    @GetMapping("/getPlayerDetail")
    public Player getPlayerDetail(int id){
        return playerService.getPlayerDetail(id);
    }
    @PostMapping("/updatePlayer")
    public  String updatePlayer(@RequestBody Player player ){
        return playerService.updatePlayer(player);
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
    @PostMapping("/deletePlayer")
    public  String deletePlayer(int id){
        return playerService.deletePlayer(id);
    }
//    @PostMapping("/deletePlayerCoach")
//    public  String deletePlayerCoach(int id){
//        return playerService.deletePlayerCoach(id);
//    }
    @GetMapping("/getplayer")
    public Map<String, Object> selectPlayer() {
//        System.out.println();
        return playerService.selectPlayer();
    }
//    @GetMapping("/getplayercoach")
//    public Map<String, Object> selectPlayerCoach() {
////        System.out.println();
//        return playerService.selectPlayerCoach();
//    }
//    @GetMapping("/getstaff")
//    public List<Staff> getstaff() {
//        return staffService.getStaff();
//    }
//    public String getStaff()

}
