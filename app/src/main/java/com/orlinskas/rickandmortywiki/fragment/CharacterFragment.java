package com.orlinskas.rickandmortywiki.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.orlinskas.rickandmortywiki.ImageLoader;
import com.orlinskas.rickandmortywiki.R;
import com.orlinskas.rickandmortywiki.entity.Character;

import org.parceler.Parcels;

public class CharacterFragment extends Fragment {
    public static final String PARCEL_CHARACTER = "character";
    private Character character;
    private Context context;
    private EntityFragmentActions fragmentActions;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        fragmentActions = (EntityFragmentActions) context;
    }

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_character_minimized, container, false);

        if(savedInstanceState != null) {
            character = Parcels.unwrap(savedInstanceState.getParcelable(PARCEL_CHARACTER));
        }
        else {
            if (getArguments() != null) {
                character = Parcels.unwrap(getArguments().getParcelable(PARCEL_CHARACTER));
            }
        }

        ImageView avatar = view.findViewById(R.id.fragment_character_minimized_iv_avatar);
        ImageLoader.fetchImage(character.getImage(), avatar);

        TextView name = view.findViewById(R.id.fragment_character_minimized_tv_name);
        TextView id = view.findViewById(R.id.fragment_character_minimized_tv_id);
        TextView species = view.findViewById(R.id.fragment_character_minimized_tv_species);
        TextView status = view.findViewById(R.id.fragment_character_minimized_tv_status);
        TextView origin = view.findViewById(R.id.fragment_character_minimized_tv_origin);

        name.setText(character.getName());
        id.setText(character.getId().toString());
        species.setText(character.getSpecies());
        status.setText(character.getStatus());
        origin.setText(character.getOrigin().getName());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation clickAnimation = AnimationUtils.loadAnimation(context, R.anim.animation_button);
                v.startAnimation(clickAnimation);
                fragmentActions.openEntity(character);
            }
        });

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(PARCEL_CHARACTER, Parcels.wrap(character));
    }
}
