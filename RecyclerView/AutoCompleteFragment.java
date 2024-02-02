package com.example.drawerlayout2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AutoCompleteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AutoCompleteFragment extends Fragment {

    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapterItems;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AutoCompleteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AutoCompleteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AutoCompleteFragment newInstance(String param1, String param2) {
        AutoCompleteFragment fragment = new AutoCompleteFragment();
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


    private static final String[] BIRTHMONTHS = new String[] {
            "January", "February", "March", "April", "May"
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_auto_complete, container, false);

        autoCompleteTextView = view.findViewById(R.id.auto_complete_txt);
        adapterItems = new ArrayAdapter<String>(requireContext(), R.layout.list_item, BIRTHMONTHS);

        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemSelected = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(requireContext(), "Selected: " + itemSelected, Toast.LENGTH_SHORT).show();
            }
        });


        MaterialButton btnSave = view.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get the selected item in the autocomplete text view and toast as a message
                String itemSelected = autoCompleteTextView.getText().toString();
                Toast.makeText(requireContext(), "Selected: " + itemSelected, Toast.LENGTH_SHORT).show();

            }
        });


        //load the BIRTHMONTHS items into the spinner
        Spinner spinner = view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, BIRTHMONTHS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);




        return view;
    }
}