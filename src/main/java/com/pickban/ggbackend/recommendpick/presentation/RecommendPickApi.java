package com.pickban.ggbackend.recommendpick.presentation;


import com.pickban.ggbackend.recommendpick.application.RecommendPickFacade;
import com.pickban.ggbackend.recommendpick.constantmodel.ChampValueConst;
import com.pickban.ggbackend.recommendpick.domain.MockDataSave;
import com.pickban.ggbackend.recommendpick.dto.RecommendRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommend")
@RequiredArgsConstructor
public class RecommendPickApi {

    private final RecommendPickFacade recommendPickFacade;

    private final MockDataSave mockDataSave;

    @GetMapping("")
    public ResponseEntity getPick(@RequestParam String team, String line, String bans, String emLine, String picks, String emPicks) {
        return new ResponseEntity(recommendPickFacade.getRecommend(team, line,
                RecommendRequestDto.builder()
                        .ban(checkParam(bans))
                        .emLine(checkParam(emLine))
                        .teamChamp(checkParam(picks))
                        .emChamp(checkParam(emPicks))
                        .build()), HttpStatus.OK);
    }

    @GetMapping("/progamer")
    public ResponseEntity getPickProgamer(@RequestParam String team, String line, String bans, String emLine, String picks, String emPicks) {
        return new ResponseEntity(recommendPickFacade.getRecommendProgamer(team, line,
                RecommendRequestDto.builder()
                        .ban(checkParam(bans))
                        .emLine(checkParam(emLine))
                        .teamChamp(checkParam(picks))
                        .emChamp(checkParam(emPicks))
                        .build()), HttpStatus.OK);
    }

    @PostMapping("/dev")
    public ResponseEntity saveChampions() {
        mockDataSave.saveTestData();
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @GetMapping("/dev/{champId}")
    public ResponseEntity findChampions(@PathVariable Long champId) {
        return new ResponseEntity(mockDataSave.findTestData(champId), HttpStatus.OK);
    }

    private String checkParam(String championId) {
        if (championId==null || championId.isBlank()) return ChampValueConst.NOT_EXISTS_CHAMP_ID_VALUE;
        return championId;
    }
}
