package com.orlinskas.rickandmortywiki.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.Menu;
import android.view.MenuItem;

import com.orlinskas.rickandmortywiki.R;
import com.orlinskas.rickandmortywiki.fragment.CharacterFragment;
import com.orlinskas.rickandmortywiki.entity.Character;
import com.orlinskas.rickandmortywiki.fragment.EntityFragmentActions;

import org.parceler.Parcels;

public class ConcreteCharacterActivity extends AppCompatActivity implements EntityFragmentActions {
    public static final String PARCEL_CHARACTER = "character";
    private Character character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concrete_character);

        if (savedInstanceState != null) {
            character = Parcels.unwrap(savedInstanceState.getParcelable(PARCEL_CHARACTER));
        } else {
            if(getIntent().getExtras() != null){
                character = Parcels.unwrap(getIntent().getExtras().getParcelable(PARCEL_CHARACTER));
            }
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        try {
            fragmentManager.beginTransaction().remove(fragmentManager.getFragments().get(0)).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Fragment fragment = new CharacterFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(PARCEL_CHARACTER, Parcels.wrap(character));
        bundle.putBoolean(CharacterFragment.IS_FULL_MODE, true);
        fragment.setArguments(bundle);
        fragmentManager.beginTransaction()
                .add(R.id.activity_concrete_character_rl_character_fragment_container, fragment)
                .commit();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(PARCEL_CHARACTER, Parcels.wrap(character));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void openEntity(Object object) {

    }
}
