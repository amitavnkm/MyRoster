package anakar01.packag.com.myroster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DashBoardActivity extends AppCompatActivity {

    private TextView employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        employee = (TextView) findViewById(R.id.btn_Employee);

        employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoardActivity.this, EmployeeList.class);
                startActivity(intent);
            }
        });
    }
}