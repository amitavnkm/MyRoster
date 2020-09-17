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

import anakar01.packag.com.myroster.Database.DatabaseHelper;

public class RemoveEmployee extends Fragment {
    private RecyclerView rv_RMV_EmpList;
    private DatabaseHelper databaseHelper;


        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            databaseHelper = new DatabaseHelper(getContext());

            View rmvEmpList = inflater.inflate(R.layout.removeemployee, container, false);

            rv_RMV_EmpList = rmvEmpList.findViewById(R.id.rmv_RecyclerView);
            LinearLayoutManager rvempLayoutManager = new LinearLayoutManager(getContext());
            rvempLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rv_RMV_EmpList.setLayoutManager(rvempLayoutManager);

            ArrayList<ModelClass> modelClassList = databaseHelper.showEmployeeList();

            RvAdapter rvAdapter = new RvAdapter(modelClassList);
            rv_RMV_EmpList.setAdapter(rvAdapter);
            rvAdapter.notifyDataSetChanged();

            return rmvEmpList;
        }
}
