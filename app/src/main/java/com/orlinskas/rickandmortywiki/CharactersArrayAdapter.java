package com.orlinskas.rickandmortywiki;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.orlinskas.rickandmortywiki.entity.Character;

import java.util.List;

public class CharactersArrayAdapter extends ArrayAdapter<Character> {
    private Context context;
    private List<Character> characters;
    private int resourceID;

    public CharactersArrayAdapter(Context context, int resourceID, List<Character> characters) {
        super(context, resourceID, characters);
        this.context = context;
        this.characters = characters;
        this.resourceID = resourceID;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        @SuppressLint("ViewHolder")
        View row = inflater.inflate(resourceID, parent, false);

        TextView name = row.findViewById(R.id.fragment_character_minimized_tv_name);
        TextView id = row.findViewById(R.id.fragment_character_minimized_tv_id);
        TextView species = row.findViewById(R.id.fragment_character_minimized_tv_species);
        TextView status = row.findViewById(R.id.fragment_character_minimized_tv_status);
        TextView origin = row.findViewById(R.id.fragment_character_minimized_tv_origin);

        name.setText(characters.get(position).getName());
        //id.setText(characters.get(position).getId());
        species.setText(characters.get(position).getSpecies());
        status.setText(characters.get(position).getStatus());
        origin.setText(characters.get(position).getOrigin().getName());

        return row;
    }
}