package com.project.wordGuessGame.Service.Impl;

import com.project.wordGuessGame.Service.GameService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Service
public class GameServiceImpl implements GameService {

    private String[] words = {
            "c",
            "java",
            "python",
            "cpp",
            "go",
            "rust",
            "javascript"
    };

    char[] dashes;


    // constructer
    public GameServiceImpl() {
        String generatedWord = words[random.nextInt(words.length)];
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
}
