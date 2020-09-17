package anakar01.packag.com.myroster;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import anakar01.packag.com.myroster.Database.DatabaseHelper;
import anakar01.packag.com.myroster.Database.Employee;

public class Employee_List extends Fragment {

    private RecyclerView rv_EmpList;
    private DatabaseHelper databaseHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        databaseHelper = new DatabaseHelper(getContext());
        View empListView = inflater.inflate(R.layout.employee_list, container, false);

        rv_EmpList = empListView.findViewById(R.id.rvEmpList);
        LinearLayoutManager empLayoutManager = new LinearLayoutManager(getContext());
        empLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_EmpList.setLayoutManager(empLayoutManager);

        ArrayList<ModelClass> modelClassList = databaseHelper.showEmployeeList();
        //User input data
       /* List<ModelClass> modelClassList = new ArrayList<>();
        modelClassList.add(new ModelClass("Amitav","a@gmail.com", "+61426186880"));
        modelClassList.add(new ModelClass("Basanta","b@gmail.com", "+61436186880"));
        modelClassList.add(new ModelClass("Amitav","a@gmail.com", "+61426186880"));
        modelClassList.add(new ModelClass("Basanta","b@gmail.com", "+61436186880"));
        modelClassList.add(new ModelClass("Amitav","a@gmail.com", "+61426186880"));
        modelClassList.add(new ModelClass("Basanta","b@gmail.com", "+61436186880"));
        modelClassList.add(new ModelClass("Amitav","a@gmail.com", "+61426186880"));
        modelClassList.add(new ModelClass("Basanta","b@gmail.com", "+61436186880"));
        modelClassList.add(new ModelClass("Amitav","a@gmail.com", "+61426186880"));
        modelClassList.add(new ModelClass("Basanta","b@gmail.com", "+61436186880"));*/


        RvAdapter rvAdapter = new RvAdapter(modelClassList);
        rv_EmpList.setAdapter(rvAdapter);
        rvAdapter.notifyDataSetChanged();

        return empListView;
    }
}
