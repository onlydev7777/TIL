package com.jpatest.api;


import com.jpatest.domain.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TeamController {
    private final TeamService service;

    @PostMapping("/save")
    public String save(@RequestParam String name){
        service.save(name);
        return "saved!";
    }
}
