package com.pickban.ggbackend.recommendpick.presentation;


import com.pickban.ggbackend.recommendpick.application.RecommendPickFacade;
import com.pickban.ggbackend.recommendpick.constantmodel.ChampValueConst;
import com.pickban.ggbackend.recommendpick.domain.MockDataSave;
import com.pickban.ggbackend.recommendpick.dto.ProgamerPickDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendPickDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommend")
public class RecommendPickApi {

    private final RecommendPickFacade recommendPickFacade;

    private final MockDataSave mockDataSave;

    public RecommendPickApi(RecommendPickFacade recommendPickFacade, MockDataSave mockDataSave) {
        this.recommendPickFacade = recommendPickFacade;
        this.mockDataSave = mockDataSave;
    }

    @GetMapping("")
    public ResponseEntity<List<RecommendPickDto>> getPick(@RequestParam String team, String line, String bans, String emBans, String picks, String emPicks) {
        return new ResponseEntity<>(recommendPickFacade.getRecommend(team, line,
                RecommendRequestDto.builder()
                        .bans(checkParam(bans))
                        .emBans(checkParam(emBans))
                        .picks(checkParam(picks))
                        .emPicks(checkParam(emPicks))
                        .build()), HttpStatus.OK);
    }

    @GetMapping("/progamer")
    public ResponseEntity<List<ProgamerPickDto>> getPickProgamer(@RequestParam String team, String line, String bans, String emBans, String picks, String emPicks) {
        return new ResponseEntity<>(recommendPickFacade.getRecommendProgamer(team, line,
                RecommendRequestDto.builder()
                        .bans(checkParam(bans))
                        .emBans(checkParam(emBans))
                        .picks(checkParam(picks))
                        .emPicks(checkParam(emPicks))
                        .build()), HttpStatus.OK);
    }

    @PostMapping("/dev")
    public ResponseEntity<HttpStatus> saveChampions() {
        mockDataSave.saveTestData();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/dev/{champId}")
    public ResponseEntity<Object> findChampions(@PathVariable Long champId) {
        return new ResponseEntity<>(mockDataSave.findTestData(champId), HttpStatus.OK);
    }

    private String checkParam(String championId) {
        if (championId==null || championId.isBlank()) return ChampValueConst.NOT_EXISTS_CHAMP_ID_VALUE;
        return championId;
    }
}
