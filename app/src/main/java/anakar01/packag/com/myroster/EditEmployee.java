package anakar01.packag.com.myroster;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EditEmployee extends Fragment {
    private EditText emp_FullName, emp_EmailId, emp_MobileNo;
    private String emp_Name, emp_Email, emp_Mobile;


        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View  timeView = inflater.inflate(R.layout.editemployee, container, false);
            emp_FullName= timeView.findViewById(R.id.et_empfullname);
            emp_EmailId= timeView.findViewById(R.id.et_empemailadd);
            emp_MobileNo= timeView.findViewById(R.id.et_empmobileno);

            getData();
            setData();


            return timeView;
        }

        private void getData() {
            /*if (getIntent().hasExtra("empName") && getIntent().hasExtra("empEmail") && getIntent().hasExtra("empMobile")) {
                emp_Name = getIntent().getStringExtra("empName");
                emp_Email = getIntent().getStringExtra("empEmail");
                emp_MobileNo = getIntent().getStringExtra("empMobile");


            } else {
                Toast.makeText(getContext(), "No data", Toast.LENGTH_SHORT).show();
            }*/
        }

        private void setData(){
            emp_FullName.setText(emp_Name);
            emp_EmailId.setText(emp_Email);
            emp_MobileNo.setText(emp_Mobile);


        }


}
