package com.pickban.ggbackend.recommendpick.presentation;


import com.pickban.ggbackend.recommendpick.application.RecommendPickFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RecommendPickApi {

    private final RecommendPickFacade recommendPickFacade;

    @GetMapping("/{ver}")
    public ResponseEntity getPick(@PathVariable String ver,
                                  @RequestParam String line, String emLineChamp, String teamChamp, String emTeamChamp) {
        return new ResponseEntity(recommendPickFacade.getRecommend(line, emLineChamp, teamChamp, emTeamChamp), HttpStatus.OK);
    }
}
