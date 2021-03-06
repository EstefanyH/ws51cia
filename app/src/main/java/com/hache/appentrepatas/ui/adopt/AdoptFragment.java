package com.hache.appentrepatas.ui.adopt;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hache.appentrepatas.MainActivity;
import com.hache.appentrepatas.R;
import com.hache.appentrepatas.adapter.AdoptAdapter;
import com.hache.appentrepatas.bean.Adopt;
import com.hache.appentrepatas.ui.home.HomeFragment;
import com.hache.appentrepatas.ui.request.ConfirmFragment;
import com.hache.appentrepatas.ui.request.DetailFragment;

import java.util.ArrayList;

public class AdoptFragment extends Fragment implements View.OnClickListener {

    private RecyclerView recyclerView ;
    private ArrayList<Adopt> adopts;
    private AdoptAdapter adoptAdapter;
    private static final String BACK_STACK_ROOT_TAG = "root_fragment";
    private  Adopt[] items = null;
    Adopt item;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_adopt, container, false);

        recyclerView = (RecyclerView) root.findViewById(R.id.recycler_adopts);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(root.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        adopts = new ArrayList<Adopt>();

        item = new Adopt();
        item.setNombre("Dacota");
        adopts.add(item);

        item = new Adopt();
        item.setNombre("Firulay");
        adopts.add(item);

        item = new Adopt();
        item.setNombre("Loki");
        adopts.add(item);

        adoptAdapter = new AdoptAdapter(new OnSelectClick(), adopts);
        recyclerView.setAdapter(adoptAdapter);

        return  root;
    }

    public void onDetach() {
        super.onDetach();
    }

    private class OnSelectClick implements AdoptAdapter.MiListenerClick{

        @Override
        public void clickItem(View itemView, int posicion) {
            ((MainActivity) getActivity()).setFragment(1);
            //((MainActivity) getActivity()).setFragment(new DetailFragment());
        }
    }

    @Override
    public void onClick(View v) {
    }

}