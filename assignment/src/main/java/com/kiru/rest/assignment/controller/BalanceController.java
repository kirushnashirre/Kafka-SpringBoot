package com.kiru.rest.assignment.controller;

import com.kiru.rest.assignment.dto.BalanceDTO;
import com.kiru.rest.assignment.dto.BalanceQueryDTO;
import com.kiru.rest.assignment.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    @Autowired
    BalanceService balanceService;

    @PostMapping
    public BalanceDTO getLatest(@RequestBody BalanceQueryDTO dto){
        return balanceService.getLatestBalance(dto);
    }

}
