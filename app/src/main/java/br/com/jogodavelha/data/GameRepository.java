package br.com.jogodavelha.data;

import java.util.ArrayList;

public class GameRepository {

    private static GameRepository repository;
    public static  GameRepository getInstance(){
        if (repository == null){
            repository = new GameRepository();
        }
        return repository;
    }

    private static ArrayList<storyGame> games = new ArrayList<>();

    public ArrayList<storyGame> listGames()
    {
        return games;
    }
    public void save(storyGame game)
    {
        games.add(game);
    }
}
