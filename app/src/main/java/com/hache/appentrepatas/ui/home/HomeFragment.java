package com.hache.appentrepatas.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.hache.appentrepatas.MainActivity;
import com.hache.appentrepatas.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public void onResume(){
        super.onResume();
        ((MainActivity) getActivity())
                .setActionBarTitle("Solicitud de adopción");
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        return root;
    }
}