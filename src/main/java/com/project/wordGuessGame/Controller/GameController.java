package com.project.wordGuessGame.Controller;

import com.project.wordGuessGame.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.project.wordGuessGame.Service.Impl.GameServiceImpl.*;

@Controller
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping("/homepage")
    public String gameHomePage(Model model,
                               @RequestParam(value="inputCharacter" , required = false) String inputCharacter){
        String generatedWord = gameService.generateWord();

        if(inputCharacter != null) {
            gameService.validateCharacter(inputCharacter);
            String updatedWord = gameService.generateWord();
            generatedWord=updatedWord;
        }

        model.addAttribute("word",generatedWord);
        // static variable from service
        String attemptDisplay=String.valueOf(attempts);
        if(attempts==0) {
            attemptDisplay="You Lose!";
        }
        model.addAttribute("attempts",attemptDisplay);
        model.addAttribute("hints",hints);

        if(wordsFound*2 == generatedWord.length()) {
            model.addAttribute("result","Congrats You won!");
        }
       ;
        return "home-page";
    }

    @GetMapping("/hint")
    public String gameHomePage(){
        if(hints>0){
            gameService.hintGenerate();
        }
        return "redirect:/homepage";
    }
}
