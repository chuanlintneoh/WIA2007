package com.example.drawerlayout2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecyclerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecyclerFragment extends Fragment {

    ArrayList<CardItemModel> cardItemModel = new ArrayList<>();

    int [] cardImages = {R.drawable.baseline_10k_24, R.drawable.baseline_10mp_24, R.drawable.baseline_11mp_24, R.drawable.baseline_12mp_24, R.drawable.baseline_13mp_24, R.drawable.baseline_14mp_24, R.drawable.baseline_15mp_24, R.drawable.baseline_123_24, R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground};

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RecyclerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecyclerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecyclerFragment newInstance(String param1, String param2) {
        RecyclerFragment fragment = new RecyclerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recycler, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        setUpCardItemModel();

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(requireContext(), cardItemModel);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        // Inflate the layout for this fragment
        return view;
    }

    private void setUpCardItemModel(){
        String [] itemName = getResources().getStringArray(R.array.item_name);
        String [] itemNumber = getResources().getStringArray(R.array.item_number);

        for(int i = 0; i < itemName.length; i++){
            cardItemModel.add(new CardItemModel(itemName[i], itemNumber[i], cardImages[i]));
        }
    }
}