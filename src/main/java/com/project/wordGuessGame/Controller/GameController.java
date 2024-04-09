package com.project.wordGuessGame.Controller;

import com.project.wordGuessGame.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping("/homepage")
    public String gameHomePage(Model model){
        String generatedWord = gameService.generateWord();
        model.addAttribute("word",generatedWord);
        return "home-page";
    }
}