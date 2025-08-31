package com.rmalvadkar.pocworks.globalaopmethodlogger;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/logTest")
@RequiredArgsConstructor
public class LogTestController {

    private final LogTestService logTestService;


    @GetMapping("check")
    public ResponseEntity<String> checkLog(){
        String name = logTestService.getName();
        System.out.println("name print in sout ");
        return ResponseEntity.ok().body(name);
    }

}
