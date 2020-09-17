package anakar01.packag.com.myroster.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.EditText;
import android.widget.ScrollView;

import java.util.ArrayList;

import anakar01.packag.com.myroster.AddEmployee;
import anakar01.packag.com.myroster.ModelClass;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Roster.db";
    public static final int DATABASE_VERSION = 1;

    //For Users
    public static final String username = "username";
    public static final String email = "email";
    public static final String mobileNo = "mobile";
    public static final String password = "password";
    public static final String signUpTableName = "Register";

    //For Employee
    public static final String addEmployeeTableName = "AddEmployee";
    //public static final String empID = "Employee_ID";
    public static final String empFullName = "Employee_Full_Name";
    public static final String empEmailID = "Employee_Email_ID";
    public static final String empMobile = "Employee_Mobile_No";
    public static final String rosterSunday = "RosterSunday";
    public static final String rosterMonday = "RosterMonday";
    public static final String rosterTuesday = "RosterTuesday";
    public static final String rosterWednesday = "RosterWednesday";
    public static final String rosterThursday = "RosterThursday";
    public static final String rosterFriday = "RosterFriday";
    public static final String rosterSaturday = "RosterSaturday";






    /*This is DatabaseHelper Constructor , when  an object of DatabaseHelper Class is created, it will initialise with following parramaters*/
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override

    public void onCreate(SQLiteDatabase db) {

//        //Signup Table
        String signUpTableCreationQuery = "create table if not exists " + signUpTableName + "(" +
                username + " text," +
                email + " text," +
                mobileNo + " real,"+
                password + " text)";
        db.execSQL(signUpTableCreationQuery);

        //Add Employee Table
        String addEmployeeTableCreationQuery = "create table if not exists " + addEmployeeTableName + "(" +
                empFullName+" text," +
                empEmailID+" text," +
                empMobile+" text," +
                rosterSunday+" text," +
                rosterMonday+" text," +
                rosterTuesday+" text," +
                rosterWednesday+" text," +
                rosterThursday+" text," +
                rosterFriday+" text," +
                rosterSaturday+" text)";

        /*String addEmployeeTableCreationQuery = "create table if not exists " + addEmployeeTableName + " (" +
                empFullName + " text," +
                empEmailID + " text," +
                empMobile + " text)";*/
        db.execSQL(addEmployeeTableCreationQuery);


                ;

//
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + signUpTableName);
        //db.execSQL("DROP TABLE IF EXISTS " + addEmployeeTableName);

        //Drop if exists
        onCreate(db);
    }

    public void addUsers(Users userObject) {
        SQLiteDatabase database = getWritableDatabase(); // this will help to read and write the table
        Log.i("MyError", "Test1");
        String addUsersSQLCommand = "insert into " + signUpTableName + " values(  " +
                                    "'" + userObject.getUserFullName() + "'," +
                                    "'" + userObject.getUserEmail() + "'," +
                                    "'" + userObject.getUserMobileNo() + "'," +
                                    "'" +userObject.getUserPassword() + "')";

        Log.i("MyError", "Test2");
        database.execSQL(addUsersSQLCommand);
        Log.i("MyError", "Test3");
        database.close();

    }

    public void addEmployee(String empName, String empEmail, String empMobile, ArrayList<String> rosterDay) {
        SQLiteDatabase database = getWritableDatabase(); // this will help to read and write the table
        Log.i("MyError", "Testing1");

       /* String addEmployeeSQLCommand = "insert into " + addEmployeeTableName + " values(  " +
                "'" +  empName + "'," +
                "'" + empEmail + "'," +
                "'" + empMobile +  "')";*/

        String addEmployeeSQLCommand = "insert into " + addEmployeeTableName + " values(  " +
                "'" +  empName + "'," +
                "'" + empEmail + "'," +
                "'" + empMobile + "'," +
                "'" + rosterDay.get(0) + "'," +
                "'" + rosterDay.get(1) + "'," +
                "'" + rosterDay.get(2) + "'," +
                "'" + rosterDay.get(3) + "'," +
                "'" + rosterDay.get(4) + "'," +
                "'" + rosterDay.get(5) + "'," +
                "'" + rosterDay.get(6) + "')";
               /* "'" + rosterDay + "')";*/


        Log.i("MyError", "Testing2");
        database.execSQL(addEmployeeSQLCommand);
        Log.i("MyError", "Testing3");
        database.close();
    }

    public void deleteEmployeeFromDataBaseByEmailID(String empemail){
        SQLiteDatabase database = getWritableDatabase();
        String deleteEmployeeSQLCommand = " delete from " + addEmployeeTableName + " where " + empEmailID + " = " +empemail;
        database.execSQL(deleteEmployeeSQLCommand);
        database.close();
    }

    public void modifyEmployeeRecord(String empName, String empEmail, String empMobile, ArrayList<String> rosterDay){
        SQLiteDatabase database = getWritableDatabase();
        String modifyEmployeeCommand = " update " + addEmployeeTableName +
                " set " + empFullName + " = '" + empName +
                "', " + empEmailID + " = '" + empEmail +
                "', " + this.empMobile + " = '" + empMobile +
                "', " + rosterSunday + " = '" + rosterDay.get(0) +
                "', " + rosterMonday + " = '" + rosterDay.get(1) +
                "', " + rosterTuesday + " = '" + rosterDay.get(2) +
                "', " + rosterWednesday + " = '" + rosterDay.get(3) +
                "', " + rosterThursday + " = '" + rosterDay.get(4) +
                "', " + rosterFriday + " = '" + rosterDay.get(5) +
                "', " + rosterSaturday + " = '" + rosterDay.get(6) +
                "'  " + " where " + empEmailID + " = " + empEmail;
        database.execSQL(modifyEmployeeCommand);
        database.close();

    }


    //Using Employee Class
    /*public ArrayList<Employee> showEmployeeList(){
        SQLiteDatabase database = getWritableDatabase();
        String showEmployeeCommand = "select * from " + addEmployeeTableName;
        Cursor cursor = database.rawQuery(showEmployeeCommand, null);
        //ArrayList<String> employeeDetails = new ArrayList<>();
        ArrayList<Employee> employeeList = new ArrayList<>();

        while(cursor.moveToNext()) {
            *//*String employeeName = cursor.getString(0);
            String employeeEmail = cursor.getString(1);
            String employeeMobile = cursor.getString(2);*//*

            Employee employeeListObject = new Employee(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2));

            employeeList.add(employeeListObject);
        }
        database.close();
        return employeeList;
        }*/

    public ArrayList<ModelClass> showEmployeeList(){
        SQLiteDatabase database = getWritableDatabase();
        String showEmployeeCommand = "select * from " + addEmployeeTableName;
        Cursor cursor = database.rawQuery(showEmployeeCommand, null);
        //ArrayList<String> employeeDetails = new ArrayList<>();
        ArrayList<ModelClass> employeeList = new ArrayList<>();

        while(cursor.moveToNext()) {
            /*String employeeName = cursor.getString(0);
            String employeeEmail = cursor.getString(1);
            String employeeMobile = cursor.getString(2);*/

            ModelClass employeeListObject = new ModelClass(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2));

            employeeList.add(employeeListObject);
        }
        database.close();
        return employeeList;
    }

    public String getSpecificColumnValueOnMatching(String tableName, String regName){


        System.out.println(tableName+ regName);

        String returnValue = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from " + tableName + " where " +  DatabaseHelper.username + " = '" +regName +"'", null);

        if (rs != null && rs.getCount() > 0) {
            rs.moveToFirst();
            returnValue = rs.getString(rs.getColumnIndex(DatabaseHelper.password));
            rs.close();
        }



        db.close();
        System.out.println("Here is Required Return Value:"+returnValue);
        return returnValue;



    }





}