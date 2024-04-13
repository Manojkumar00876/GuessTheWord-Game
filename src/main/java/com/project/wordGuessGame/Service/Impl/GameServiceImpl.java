package com.project.wordGuessGame.Service.Impl;

import com.project.wordGuessGame.Service.GameService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Service
public class GameServiceImpl implements GameService {

    private String[] words = {
            "mouse",
            "bean",
            "python",
            "project",
            "purse",
            "black",
            "table"
    };

    char[] dashes;
    String generatedWord;
   public static int wordsFound=0;
   public static int attempts=3;
    public static int hints=2;


    // constructer
    public GameServiceImpl() {
        generatedWord = words[random.nextInt(words.length)];
        dashes = new char[generatedWord.length()];
        Arrays.fill(dashes,'_');
    }

    Random random = new Random();
    @Override
    public String generateWord() {
        StringBuilder hiddenWord = new StringBuilder();

        for(char x : dashes)
            hiddenWord.append(x+ " ");

        return hiddenWord.toString() ;
    }

    @Override
    public void validateCharacter(String inputCharacter) {
        if(generatedWord.contains(String.valueOf(inputCharacter))){
            int index = generatedWord.indexOf(inputCharacter);
            if(inputCharacter.length() > 0){
                dashes[index] = inputCharacter.charAt(0);
                ++wordsFound;
            }
        }
        else {
            attempts--;
        }
    }

    @Override
    public void hintGenerate() {
        hints--;
        ++wordsFound;
        int index = random.nextInt(dashes.length-1);
        dashes[index] = generatedWord.charAt(index);
    }
}
