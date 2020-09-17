package anakar01.packag.com.myroster;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import anakar01.packag.com.myroster.Database.DatabaseHelper;
import anakar01.packag.com.myroster.Database.Users;

public class SignUp extends AppCompatActivity {


    private EditText etFullName;
    private EditText etEmailAdd;
    private EditText etMobileno;
    private EditText etPassword;
    private EditText etCPassword;
    private CheckBox cbAgree;
    private Button btnSignUp;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);


        etFullName = findViewById(R.id.et_fullname);
        etEmailAdd = findViewById(R.id.et_emailadd);
        etMobileno = findViewById(R.id.et_mobileno);
        etPassword = findViewById(R.id.et_password);
        etCPassword = findViewById(R.id.et_cpassword);
        cbAgree = findViewById(R.id.cb_agree);
        btnSignUp = findViewById(R.id.btn_signup);

        databaseHelper = new DatabaseHelper(SignUp.this);// here you have to pass context object ie this (object of this class)

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!etFullName.getText().toString().isEmpty()){

                    if(!etEmailAdd.getText().toString().isEmpty()){

                        if(!etMobileno.getText().toString().isEmpty()){

                            if(!etPassword.getText().toString().isEmpty()){

                                if(!etCPassword.getText().toString().isEmpty()){

                                    Log.i("MyTag", etPassword +"" );
                                    Log.i("MyTag", etCPassword +"" );


                                    if ((etPassword.getText().toString()).equals( etCPassword.getText().toString())){

                                        registerUser();
                                        Intent intent = new Intent(SignUp.this, MainActivity.class);
                                        startActivity(intent);

                                    } else{
                                        Toast.makeText(SignUp.this, "Please input the same password in Password and Confirm Password!", Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Toast.makeText(SignUp.this, "Confirm Password is Empty! Please input the same password", Toast.LENGTH_LONG).show();

                                }
                            } else {
                                Toast.makeText(SignUp.this, "Password is Empty! Please input the password", Toast.LENGTH_LONG).show();

                            }
                        } else {
                            Toast.makeText(SignUp.this, "Mobile Number is Empty! Please enter your Mobile number." , Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(SignUp.this, "Email is Empty! Please enter your Email address.", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(SignUp.this, "Name is Empty! Please enter your Full Name.", Toast.LENGTH_LONG).show();
                }


            }
        });

    }





    private void registerUser() {

        String fullName = etFullName.getText().toString();
        String email = etEmailAdd.getText().toString();
        String mobileNo = etMobileno.getText().toString();
        String password = etPassword.getText().toString();


        // Creating object of databasehelper class as db
        //DatabaseHelper databaseHelper = new DatabaseHelper(this);// here you have to pass context object ie this (object of this class)

        /*Note we have to create object  to call methods of that class */
        try {
            int intMobileNo = Integer.parseInt(mobileNo);
            Users users = new Users(fullName,email,intMobileNo,password);
            databaseHelper.addUsers(users);// calling insertIntoSignUpTable methods in class databasehelper
            Toast.makeText(SignUp.this, "New Account Created", Toast.LENGTH_SHORT).show();


        } catch (Exception e) {
            System.out.println(e.toString());
            Toast.makeText(SignUp.this, e.toString(), Toast.LENGTH_SHORT).show();


        }


    }
}
