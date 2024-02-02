package com.example.drawerlayout2;

import android.content.Context;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    EditText ETBgColorCode;
    EditText ETImageNumber;

    ConstraintLayout settingsLayout;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    private static final String USER_FILE_NAME = "user_file";




    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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


        View view = inflater.inflate(R.layout.fragment_home, null, false);
        //Check if the internal storage has the userfile or not
        Context context = view.getContext();
        //Create a file handler
        File UserFile = new File(context.getFilesDir(), USER_FILE_NAME);

        //Check the existence of the userfile
        //If exist - turn off fragment visibility, read the file and display the username
        if (UserFile.exists()) {
            LinearLayout linearLogin = view.findViewById(R.id.linear_login);
            linearLogin.setVisibility(View.GONE);

            String username = readUserName();
            TextView TVWelcome = view.findViewById(R.id.TVWelcome);
            TVWelcome.setText("Welcome Mr " + username);
        }

        // Inflate the layout for this fragment

        Button BtnSubmit = view.findViewById(R.id.BtnSubmit);

        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ETUsername = view.findViewById(R.id.ETUsername);
                String filename = "user_file";
                String fileContents = ETUsername.getText().toString();
                try (FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE)) {
                    fos.write(fileContents.getBytes());
                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return view;
    }


    protected String readUserName() {
        String FileContent = "";
        FileInputStream FIS = null;
        try {
            FIS = requireContext().openFileInput(USER_FILE_NAME);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader inputStreamReader = new InputStreamReader(FIS, StandardCharsets.UTF_8);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append('\n');
                line = reader.readLine();
            }
        } catch (IOException e) {
            // Error occurred when opening raw file for reading.
            System.out.println(e);
        } finally {
            FileContent = stringBuilder.toString();
        }
        return FileContent;
    }
}