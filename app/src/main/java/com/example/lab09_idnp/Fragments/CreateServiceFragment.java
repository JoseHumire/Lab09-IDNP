package com.example.lab09_idnp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.lab09_idnp.R;


public class CreateServiceFragment extends Fragment {
    private EditText inputSchedule, inputSalary, inputProfession;
    private Button saveBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_service, container, false);

        inputSalary = view.findViewById(R.id.textInputEditTextSalary);
        inputSchedule = view.findViewById(R.id.textInputEditTextSchedule);
        inputProfession = view.findViewById(R.id.textInputEditTextProfession);
        saveBtn = view.findViewById(R.id.btnSave);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle result = new Bundle();
                result.putString("Salary", inputSalary.getText().toString());
                result.putString("Schedule", inputSchedule.getText().toString());
                result.putString("Profession", inputProfession.getText().toString());
                Fragment fragment = new ServiceListFragment();

                fragment.setArguments(result);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_main, fragment, "tag");
                fragmentTransaction.addToBackStack("tag");
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}