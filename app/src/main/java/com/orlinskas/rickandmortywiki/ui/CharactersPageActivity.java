package com.orlinskas.rickandmortywiki.ui;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.orlinskas.rickandmortywiki.ToastBuilder;
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
    public int currentPage = 1;
    private CharactersPage charactersPage;
    private ProgressBar progressBar;
    private FragmentManager fm = getSupportFragmentManager();

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
    }

    private void loadPage(int pageNumber) {
        lockScreenOrientation();
        progressBar.setVisibility(View.VISIBLE);
        CharacterRepository repository = new CharacterRepository(this);
        repository.getResultPage(pageNumber);
    }

    @Override
    public void onDonePageResponse(final Object data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                unlockScreenOrientation();
                progressBar.setVisibility(View.INVISIBLE);
                charactersPage = (CharactersPage) data;
                showPage(charactersPage);
            }
        });
    }

    private void showPage(CharactersPage charactersPage) {
        for(Fragment fragment : fm.getFragments()) {
            fm.beginTransaction().remove(fragment).commit();
        }

        for (Character character : charactersPage.getCharacters()) {
            pasteCharacterFragment(fm, character);
        }

        showPageTurnerFragment();
    }

    private void pasteCharacterFragment(FragmentManager fm, Character character) {
        Fragment fragment = new CharacterFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(CharacterFragment.PARCEL_CHARACTER, Parcels.wrap(character));
        fragment.setArguments(bundle);
        fm.beginTransaction()
                .add(R.id.activity_characters_page_ll_characters_container, fragment)
                .commit();
    }

    private void showPageTurnerFragment() {
        Fragment fragment = new PagerTurnerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(PagerTurnerFragment.PAGE, currentPage);
        fragment.setArguments(bundle);
        fm.beginTransaction()
                .add(R.id.activity_characters_page_ll_page_turner_container, fragment)
                .commit();
    }

    @Override
    public void openNextPage() {
        if(isValidPage(currentPage + 1)){
            loadPage(++currentPage);
        }
    }

    @Override
    public void openPrevPage() {
        if(isValidPage(currentPage - 1)){
            loadPage(--currentPage);
        }
    }

    private boolean isValidPage(int i) {
        return i > 0 && i <= charactersPage.getInfo().getPages();
    }

    @Override
    public void onDoneConcreteResponse(Object data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                unlockScreenOrientation();
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public void onFailResponse(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                unlockScreenOrientation();
                progressBar.setVisibility(View.INVISIBLE);
                ToastBuilder.create(getApplicationContext(), message);
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
    public void openEntity(Object object) {

    }

    private void lockScreenOrientation() {
        int currentOrientation = getResources().getConfiguration().orientation;
        if (currentOrientation == Configuration.ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    private void unlockScreenOrientation() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
    }
}
