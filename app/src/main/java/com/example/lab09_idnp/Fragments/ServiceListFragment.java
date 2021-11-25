package com.example.lab09_idnp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.lab09_idnp.R;


public class ServiceListFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    )
    {
        container.removeAllViews();
        View view = inflater.inflate(R.layout.fragment_service_list, container, false);
        Bundle args = getArguments();
        if(args != null){
            String salary = args.getString("Salary", "");
            salary = "Salary: " + salary;
            String profession = args.getString("Profession", "");
            profession = "Profession: " + profession;
            String schedule = args.getString("Schedule", "");
            schedule = "Schedule: " + schedule;

            TextView sched = view.findViewById(R.id.scheduleText);
            sched.setText(schedule);
            TextView sal = view.findViewById(R.id.salaryText);
            sal.setText(salary);
            TextView prof = view.findViewById(R.id.professionText);
            prof.setText(profession);
        }

        return view;
    }
}