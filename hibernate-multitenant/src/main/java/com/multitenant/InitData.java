package com.multitenant;

import com.multitenant.entity.TeamSchema;
import com.multitenant.entity.TempMember;
import com.multitenant.repository.TeamRepository;
import com.multitenant.repository.TeamSchemaRepository;
import com.multitenant.repository.TempMemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class InitData {
    private final TeamSchemaRepository teamSchemaRepository;
    private final TeamRepository teamRepository;
    private final TempMemberRepository tempMemberRepository;
    private final Map<String, String> initTeamSchemaMap = Map.of(
            "dev", "newbp_local",
            "dev2", "newbp_local2"
    );

    private final Map<String, List<String>> initTempMemberMap = Map.of(
            "dev", List.of("ykj","ehm","cje"),
            "dev2", List.of("ldh","sch","ksj")
    );

    @PostConstruct
    public void teamSchemaInit() {
        teamRepository.findAll().forEach(t-> {
            teamSchemaRepository.findByTeamName(t.getName()).orElseGet(() ->
                    teamSchemaRepository.save(new TeamSchema(t.getName(), initTeamSchemaMap.get(t.getName())))
            );

            initTempMemberMap.get(t.getName()).forEach(mName ->
                    tempMemberRepository.findByTeamNameAndName(t.getName(), mName).orElseGet(()->
                            tempMemberRepository.save(new TempMember(t.getName(), mName))
                    )
            );
        });
    }
}
