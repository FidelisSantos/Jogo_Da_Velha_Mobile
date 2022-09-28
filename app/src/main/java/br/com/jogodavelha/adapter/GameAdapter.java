package br.com.jogodavelha.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import br.com.jogodavelha.R;
import br.com.jogodavelha.data.GameRepository;
import br.com.jogodavelha.data.storyGame;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class GameAdapter extends  RecyclerView.Adapter<GameAdapter.GameViewHolder>{

    private ArrayList<storyGame> games;

    public GameAdapter(ArrayList<storyGame> games)
    {
        this.games = games;
    }
    @NonNull
    @NotNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View layout = inflater.inflate(R.layout.view_story, parent, false);


        return new GameViewHolder (layout);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull GameViewHolder holder, int position) {
        storyGame game = games.get(position);
        TextView textGame = holder.itemView.findViewById(R.id.textJogo);
        TextView textWinner = holder.itemView.findViewById(R.id.textWinner);

        textGame.setText(game.getGame());
        textWinner.setText(game.getWinner());
    }

    @Override
    public int getItemCount() {
        return  games.size();
    }

    public static class GameViewHolder extends RecyclerView.ViewHolder {
        public GameViewHolder(View itemView) {
            super(itemView);
        }
    }
}
