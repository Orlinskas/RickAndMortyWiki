package com.orlinskas.rickandmortywiki.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.orlinskas.rickandmortywiki.entity.Character;
import com.orlinskas.rickandmortywiki.entity.CharactersPage;
import com.orlinskas.rickandmortywiki.fragment.CharacterFragment;
import com.orlinskas.rickandmortywiki.fragment.EntityFragmentActions;
import com.orlinskas.rickandmortywiki.fragment.PageTurnerActions;
import com.orlinskas.rickandmortywiki.fragment.PagerTurnerFragment;
import com.orlinskas.rickandmortywiki.repository.ApiResponsibleListener;
import com.orlinskas.rickandmortywiki.R;
import com.orlinskas.rickandmortywiki.repository.CharacterRepository;

import org.parceler.Parcels;

public class CharactersPageActivity extends AppCompatActivity implements ApiResponsibleListener, PageTurnerActions, EntityFragmentActions {
    private static final String PARCEL_CHARACTERS_PAGE = "charactersPage";
    private int currentPage = 1;
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
            loadPage(currentPage);
        }

        showPageTurner();
    }

    private void loadPage(int pageNumber) {
        progressBar.setVisibility(View.VISIBLE);
        CharacterRepository repository = new CharacterRepository(this);
        repository.getResultPage(pageNumber);
    }

    @Override
    public void onDonePageResponse(final Object data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.INVISIBLE);
                charactersPage = (CharactersPage) data;
                showPage(charactersPage);
            }
        });
    }

    private void showPageTurner() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.activity_characters_page_ll_page_turner_container);
        if (fragment == null) {
            fragment = new PagerTurnerFragment();
            ((PagerTurnerFragment) fragment).currentPage = currentPage;
            fm.beginTransaction()
                    .add(R.id.activity_characters_page_ll_page_turner_container, fragment)
                    .commit();
        }
    }

    private void showPage(CharactersPage charactersPage) {
        FragmentManager fm = getSupportFragmentManager();
        fm.getFragments().clear();

        for (Character character : charactersPage.getCharacters()){
            Fragment fragment = fm.findFragmentById(R.id.activity_characters_page_ll_container);
            if (fragment == null) {
                fragment = new CharacterFragment();
                ((CharacterFragment) fragment).character = character;
                fm.beginTransaction()
                        .add(R.id.activity_characters_page_ll_container, fragment)
                        .commit();
            }
            //else {
            //    fragment = new CharacterFragment();
            //    ((CharacterFragment) fragment).character = character;
            //    fm.beginTransaction()
            //            .add(R.id.activity_characters_page_ll_container, fragment)
            //            .commit();
            //}
        }
    }

    @Override
    public void onDoneConcreteResponse(Object data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public void onFailResponse(String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(PARCEL_CHARACTERS_PAGE, Parcels.wrap(charactersPage));
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
    public void openNextPage() {
        loadPage(currentPage++);
    }

    @Override
    public void openPrevPage() {
        loadPage(currentPage--);
    }

    @Override
    public void openEntity(Object object) {

    }
}
