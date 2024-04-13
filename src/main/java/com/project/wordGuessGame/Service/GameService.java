package com.project.wordGuessGame.Service;




public interface GameService {
    public String generateWord();

    void validateCharacter(String inputCharacter);

    void hintGenerate();
}
