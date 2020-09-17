package anakar01.packag.com.myroster;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import anakar01.packag.com.myroster.Database.DatabaseHelper;

public class AddEmployee extends Fragment implements View.OnClickListener {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    ArrayList<String> day= new ArrayList<String>();
    private EditText empFullName;
    private EditText empEmail;
    private EditText empMobileno;
    private Spinner spinnerSundayStart;
    private Spinner spinnerSundayEnd;
    private Spinner spinnerMondayStart;
    private Spinner spinnerMondayEnd;
    private Spinner spinnerTuesdayStart;
    private Spinner spinnerTuesdayEnd;
    private Spinner spinnerWednesdayStart;
    private Spinner spinnerWednesdayEnd;
    private Spinner spinnerThursdayStart;
    private Spinner spinnerThursdayEnd;
    private Spinner spinnerFridayStart;
    private Spinner spinnerFridayEnd;
    private Spinner spinnerSaturdayStart;
    private Spinner spinnerSaturdayEnd;

    private Button addEmployee;

    private String empSundayStart;
    private String empSundayEnd;
    private String empMondayStart;
    private String empMondayEnd;
    private String empTuesdayStart;
    private String empTuesdayEnd;
    private String empWednesdayStart;
    private String empWednesdayEnd;
    private String empThursdayStart;
    private String empThursdayEnd;
    private String empFridayStart;
    private String empFridayEnd;
    private String empSaturdayStart;
    private String empSaturdayEnd;



    DatabaseHelper databaseHelper;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



       View  timeView = inflater.inflate(R.layout.addemployee, container, false);

            adapter = ArrayAdapter.createFromResource(getActivity(), R.array.timeAvailable,android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinnerSundayStart = timeView.findViewById(R.id.spinnerSundayStart);
            spinnerSundayStart.setAdapter(adapter);
            spinnerSundayEnd = timeView.findViewById(R.id.spinnerSundayEnd);
            spinnerSundayEnd.setAdapter(adapter);
            spinnerMondayStart = timeView.findViewById(R.id.spinnerMondayStart);
            spinnerMondayStart.setAdapter(adapter);
            spinnerMondayEnd = timeView.findViewById(R.id.spinnerMondayEnd);
            spinnerMondayEnd.setAdapter(adapter);
            spinnerTuesdayStart = timeView.findViewById(R.id.spinnerTuesdayStart);
            spinnerTuesdayStart.setAdapter(adapter);
            spinnerTuesdayEnd = timeView.findViewById(R.id.spinnerTuesdayEnd);
            spinnerTuesdayEnd.setAdapter(adapter);
            spinnerWednesdayStart = timeView.findViewById(R.id.spinnerWednesdayStart);
            spinnerWednesdayStart.setAdapter(adapter);
            spinnerWednesdayEnd = timeView.findViewById(R.id.spinnerWednesdayEnd);
            spinnerWednesdayEnd.setAdapter(adapter);
            spinnerThursdayStart = timeView.findViewById(R.id.spinnerThursdayStart);
            spinnerThursdayStart.setAdapter(adapter);
            spinnerThursdayEnd = timeView.findViewById(R.id.spinnerThursdayEnd);
            spinnerThursdayEnd.setAdapter(adapter);
            spinnerFridayStart = timeView.findViewById(R.id.spinnerFridayStart);
            spinnerFridayStart.setAdapter(adapter);
            spinnerFridayEnd = timeView.findViewById(R.id.spinnerFridayEnd);
            spinnerFridayEnd.setAdapter(adapter);
            spinnerSaturdayStart = timeView.findViewById(R.id.spinnerSaturdayStart);
            spinnerSaturdayStart.setAdapter(adapter);
            spinnerSaturdayEnd = timeView.findViewById(R.id.spinnerSaturdayEnd);
            spinnerSaturdayEnd.setAdapter(adapter);


           /* adapter = ArrayAdapter.createFromResource(getActivity(), R.array.timeAvailable,android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);*/


            empFullName = (EditText)timeView.findViewById(R.id.et_empfullname);
            empEmail = (EditText) timeView.findViewById(R.id.et_empemailadd);
            empMobileno = (EditText)timeView.findViewById(R.id.et_empmobileno);
            addEmployee = (Button)timeView.findViewById(R.id.btnAddEmployee);
            addEmployee.setOnClickListener(AddEmployee.this);


            return timeView;
        }

    private void addEmployeeToDatabase(){
            databaseHelper = new DatabaseHelper(getContext());

            String empFull_Name = empFullName.getText().toString();
            String empEmailID = empEmail.getText().toString();
            String empMobile = empMobileno.getText().toString();


            empSundayStart = spinnerSundayStart.getSelectedItem().toString();
            empSundayEnd = spinnerSundayEnd.getSelectedItem().toString();
            empMondayStart = spinnerMondayStart.getSelectedItem().toString();
            empMondayEnd = spinnerMondayEnd.getSelectedItem().toString();
            empTuesdayStart = spinnerTuesdayStart.getSelectedItem().toString();
            empTuesdayEnd = spinnerTuesdayEnd.getSelectedItem().toString();
            empWednesdayStart = spinnerWednesdayStart.getSelectedItem().toString();
            empWednesdayEnd = spinnerWednesdayEnd.getSelectedItem().toString();
            empThursdayStart = spinnerThursdayStart.getSelectedItem().toString();
            empThursdayEnd = spinnerThursdayEnd.getSelectedItem().toString();
            empFridayStart = spinnerFridayStart.getSelectedItem().toString();
            empFridayEnd = spinnerFridayEnd.getSelectedItem().toString();
            empSaturdayStart = spinnerSaturdayStart.getSelectedItem().toString();
            empSaturdayEnd = spinnerSaturdayEnd.getSelectedItem().toString();

            String sun = empSundayStart + empSundayEnd;
            String mon = empMondayStart + empMondayEnd;
            String tue = empTuesdayStart + empTuesdayEnd;
            String wed = empWednesdayStart + empWednesdayEnd;
            String thu = empThursdayStart + empThursdayEnd;
            String fri = empFridayStart + empFridayEnd;
            String sat = empSaturdayStart +  empSaturdayEnd;

            day.add(sun);
            day.add(mon);
            day.add(tue);
            day.add(wed);
            day.add(thu);
            day.add(fri);
            day.add(sat);


        try {
            int empMobileNoInt = Integer.parseInt(empMobile);
            databaseHelper.addEmployee(empFull_Name, empEmailID,empMobile, day);
            /*databaseHelper.addEmployee(empFull_Name, empEmailID,empMobile,day);*/

            Toast.makeText(getContext(), empFull_Name + "" + "Employee is added to the database", Toast.LENGTH_LONG).show();


        } catch (Exception e){
            e.printStackTrace(); // to trace where error occurred

        }



    }

    @Override
    public void onClick(View v) {
        addEmployeeToDatabase();
        Toast.makeText(getContext(),empFullName.getText()+""+
                "\n" + empEmail.getText() + ""+
                "\n"+ empMobileno.getText()+""+
                "\n"+empSundayStart+"",Toast.LENGTH_LONG).show();


    }
}
