package com.orlinskas.rickandmortywiki.fragment;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class CharacterFragment extends Fragment {
    private Character character;
    private Context context;
    private EntityFragmentActions fragmentActions;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        fragmentActions = (EntityFragmentActions) context;
    }
}
