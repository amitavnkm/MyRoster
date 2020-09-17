package anakar01.packag.com.myroster;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class PickDate extends AppCompatActivity {

    private TextView tvEnterDate;
    private int year, month, day;
    //String DOB;
    Calendar calendar;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pickdate);
        tvEnterDate = findViewById(R.id.tv_enterDate);

        calendar = Calendar.getInstance();

        tvEnterDate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
               year = calendar.get(Calendar.YEAR);
               month = calendar.get(Calendar.MONTH);
               day = calendar.get(calendar.DAY_OF_MONTH);

                final DatePickerDialog datePickerDialog = new DatePickerDialog(getApplicationContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


                        String value = Integer.toString(dayOfMonth)+"/"+month+"/"+ year ;
                        tvEnterDate.setText(value);
                       // tvEnterDate.setText(dayOfMonth+"/"+month+"/"+year);
                        //DOB= (i+"/"+(i1+1)+"/"+i2);
                    }




                },year,month,day);

                datePickerDialog.show();


            }
        });

    }
}
