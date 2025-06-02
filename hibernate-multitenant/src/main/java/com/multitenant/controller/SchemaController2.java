package com.multitenant.controller;

import com.multitenant.service.MemberService;
import com.multitenant.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/newbp_local2")
@RestController
public class SchemaController2 {
    private final MemberService memberService;
    private final TeamService teamService;

    @GetMapping("/member/{name}")
    public String name(@PathVariable String name) {
        return memberService.findByName(name);
    }

    @GetMapping("/member")
    public String nameWithTeam(@RequestParam(required = false) String teamName, @RequestParam String name) {
        return memberService.findByNameWithTeam(teamName, name);
    }

    @GetMapping("/team/{name}")
    public String teamName(@PathVariable String name) {
        return teamService.findByName(name);
    }

    @PostMapping("/member/{teamName}/{memberName}")
    public String saveMember(@PathVariable String teamName, @PathVariable String memberName) {
        return memberService.save(teamName, memberName);
    }

    @PostMapping("/team/{name}")
    public String saveTeam(@PathVariable String name) {
        return teamService.save(name);
    }


    //================================ Native ================================//
    @GetMapping("/native-query/member/{name}")
    public String nameWithNative(@PathVariable String name) {
        return memberService.findByNameWithNative(name);
    }
    @PostMapping("/native-query/member/{teamName}/{memberName}")
    public String saveMemberWithNative(@PathVariable String teamName, @PathVariable String memberName) {
        return memberService.saveWithNative(teamName, memberName);
    }

    //================================ JdbcTemplate ================================//
    @GetMapping("/jdbc-template/member/{name}")
    public String nameWithJdbcTemplate(@PathVariable String name) {
        return memberService.findByNameWithJdbcTemplate(name);
    }
    @PostMapping("/jdbc-template/member/{teamName}/{memberName}")
    public String saveMemberWithJdbcTemplate(@PathVariable String teamName, @PathVariable String memberName) {
        return memberService.saveWithJdbcTemplate(teamName, memberName);
    }

    //================================ newbp_local에만 있는 teamSchema 엔터티 데이터 확인 ================================//
    @GetMapping("/team-schema/{teamName}")
    public String getTeamSchema(@PathVariable String teamName) {
        return teamService.findTeamSchemaName(teamName);
    }

    //================================ 신규 트랜잭션 생성 테스트 ================================//
    @PostMapping("/admin-member/{teamName}/{memberName}")
    public String saveAdminMember(@PathVariable String teamName, @PathVariable String memberName) {
        return memberService.saveWithAdmin(teamName, memberName);
    }

    @PostMapping("/admin-member-error/{teamName}/{memberName}")
    public String saveAdminMemberButError(@PathVariable String teamName, @PathVariable String memberName) {
        return memberService.saveWithAdminButException(teamName, memberName);
    }
}
