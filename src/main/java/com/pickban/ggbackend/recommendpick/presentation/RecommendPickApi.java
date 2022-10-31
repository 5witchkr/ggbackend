package com.pickban.ggbackend.recommendpick.presentation;


import com.pickban.ggbackend.recommendpick.application.RecommendPickFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommend")
@RequiredArgsConstructor
public class RecommendPickApi {

    private final RecommendPickFacade recommendPickFacade;

    @GetMapping("")
    public ResponseEntity getPick(@RequestParam String team, String line, String ban, String emLine, String teamChamp, String emChamp) {
        return new ResponseEntity(recommendPickFacade.getRecommend(team, line, ban, emLine, teamChamp, emChamp), HttpStatus.OK);
    }

    @GetMapping("/progamer")
    public ResponseEntity getPickProgamer(@RequestParam String team, String line, String ban, String emLine, String teamChamp, String emChamp) {
        return new ResponseEntity(recommendPickFacade.getRecommendProgamer(team, line, ban, emLine, teamChamp, emChamp), HttpStatus.OK);
    }
}
