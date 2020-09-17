package anakar01.packag.com.myroster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import anakar01.packag.com.myroster.Database.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    private Button signUp;
    private Button signIn; //Sign in button
    private EditText email; //Email
    private EditText password;
    private CheckBox keepLogin;
    private TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.edt_email);
        password = findViewById(R.id.edt_password);
        forgotPassword = findViewById(R.id.tv_forgotpassword);
        keepLogin = findViewById(R.id.chkbox_keeplogin);
        signIn = findViewById(R.id.btn_signin);
        signUp = findViewById(R.id.btn_newusers);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!email.getText().toString().isEmpty()) {

                    if (!password.getText().toString().isEmpty()) {
                        validate((email.getText()).toString().trim(), (password.getText()).toString().trim());


                    } else {
                        Toast.makeText(MainActivity.this, "Password Field Is Empty", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Email Field Is Empty", Toast.LENGTH_LONG).show();

                }

            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUp.class); // need to create new sign up java page
                startActivity(intent);


            }
        });

        /*signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EmployeeList.class); // need to create new sign up java page
                startActivity(intent);


            }
        });*/

    }

    private void validate(String userName, String userPassword) {


        // List<String> usernameList= new ArrayList<>();
        String password;
        DatabaseHelper db = new DatabaseHelper(this);
        //usernameList=db.getAllUserNameFromDatabase();


        password = db.getSpecificColumnValueOnMatching(DatabaseHelper.signUpTableName, userName.trim());



        if (userPassword.equals(password.trim())) {


            Intent intent = new Intent(MainActivity.this, DashBoardActivity.class);
            startActivity(intent);


        } else {
            Toast.makeText(MainActivity.this,
                    "Incorrect Password Or Name", Toast.LENGTH_LONG).show();

        }

    }

}
