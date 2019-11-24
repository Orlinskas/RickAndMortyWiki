package com.orlinskas.rickandmortywiki.fragment;

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

import com.orlinskas.rickandmortywiki.R;

public class PagerTurnerFragment extends Fragment {
    private static final String PAGE = "page";
    private Context context;
    private PageTurnerActions pageTurnerActions;
    public int currentPage;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        pageTurnerActions = (PageTurnerActions) context;
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_turner_fragment, container, false);

        if(savedInstanceState != null) {
            currentPage = savedInstanceState.getInt(PAGE,1);
        }
        //else {
        //    if (getArguments() != null) {
        //
        //    }
        //}

        final Animation clickAnimation = AnimationUtils.loadAnimation(context, R.anim.animation_button);

        ImageView prevBtn = view.findViewById(R.id.fragment_turner_fragment_iv_previos);
        ImageView nextBtn = view.findViewById(R.id.fragment_turner_fragment_iv_next);
        TextView currentPageTv = view.findViewById(R.id.fragment_turner_fragment_tv_currentPage);

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(clickAnimation);
                pageTurnerActions.openPrevPage();
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(clickAnimation);
                pageTurnerActions.openNextPage();
            }
        });

        currentPageTv.setText(currentPage);

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(PAGE,currentPage);
    }
}
