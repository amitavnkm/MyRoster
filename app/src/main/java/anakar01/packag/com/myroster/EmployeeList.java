package anakar01.packag.com.myroster;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EmployeeList extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employeelist);

        BottomNavigationView topNav = findViewById(R.id.nav_top);
        topNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Employee_List()).commit();


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
           Fragment selectedFragment = null;


           switch(item.getItemId()){
               case R.id.nav_searchEmployee:
                   selectedFragment = new Employee_List();
                   break;

               case R.id.nav_addEmployee:
                   selectedFragment = new AddEmployee();
                   break;

               case R.id.nav_editEmployee:
                   selectedFragment = new EditEmployee();
                   break;

               case R.id.nav_removeEmployee:
                   selectedFragment = new RemoveEmployee();
                   break;
            }


            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
            return true;

        }
    };
}
