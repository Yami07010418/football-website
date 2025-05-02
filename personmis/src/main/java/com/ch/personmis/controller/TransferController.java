package com.ch.personmis.controller;

import com.ch.personmis.entity.Transfer;
import com.ch.personmis.service.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class TransferController {
    @Resource
    private TransferService transferService;
    @GetMapping("/getBeforePost")
    public Transfer getBeforePost(int id){
        return transferService.getBeforePost(id);
    }
    @PostMapping("/addTransfer")
    public  String addTransfer(@RequestBody Transfer transfer){
        return transferService.addTransfer(transfer);
    }
    @GetMapping("/getTransfer")
    public Map<String, Object> getTransfer(Transfer transfer) {
        return transferService.getTransfer(transfer);
    }
    @PostMapping("/selectTransfersByCon")
    public  Map<String, Object> selectTransfersByCon(@RequestBody Transfer transfer){
        return transferService.selectTransfersByCon(transfer);
    }
}
