package com.springSecurity.springSecurity_second.controller.SecuredEndpoints;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fastApi/dashboard")
public class DashBoardController {

    @GetMapping("/user")
    public ResponseEntity<String> hello(){
        return ResponseEntity.status(200).body("this end point is secured");
    }
}
