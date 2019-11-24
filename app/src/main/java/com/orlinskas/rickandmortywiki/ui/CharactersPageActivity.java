package com.orlinskas.rickandmortywiki.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.orlinskas.rickandmortywiki.entity.CharactersPage;
import com.orlinskas.rickandmortywiki.repository.ApiResponsibleListener;
import com.orlinskas.rickandmortywiki.R;

import org.parceler.Parcels;

public class CharactersPageActivity extends AppCompatActivity implements ApiResponsibleListener {
    private static final String PARCEL_CHARACTERS_PAGE = "charactersPage";
    private int currentPage;
    private CharactersPage charactersPage;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters_page);
        progressBar = findViewById(R.id.activity_characters_page_pb);

        if (savedInstanceState != null) {
            charactersPage = Parcels.unwrap(savedInstanceState.getParcelable(PARCEL_CHARACTERS_PAGE));
        } else {
            new FindDaysTask().execute();
        }

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
    public void onDonePageResponse(Object data) {

    }

    @Override
    public void onDoneConcreteResponse(Object data) {

    }

    @Override
    public void onFailResponse(String message) {

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(PARCEL_CHARACTERS_PAGE, Parcels.wrap(charactersPage));
    }
}
