package com.example.myproject2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
/**import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
**/
public class log_in extends AppCompatActivity {

    private static final String TAG = "anurag";
    EditText et1, et2;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        //  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        et1 = findViewById(R.id.userName);
        et2 = findViewById(R.id.password);
        firebaseAuth=FirebaseAuth.getInstance();


    }

    public void registration(View view) {
        Toast.makeText(this, "you clicked on registration", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(log_in.this, new_regitration.class);
        startActivity(intent);
        finish();

    }




    private boolean validateName() {
        String val = et1.getEditableText().toString();
        if (val.isEmpty()) {
            et1.setError("Field can not be empty");
            return false;
        } else {
            et2.setError(null);
            return true;
        }

    }

    private boolean validatePassword() {
        String val = et2.getEditableText().toString();
        if (val.isEmpty()) {
            et2.setError("Field can not be empty");
            return false;
        } else {
            et2.setError(null);
            return true;
        }

    }

    public void Log_in(View view) {

        if (!validateName() || !validatePassword()){
            return;

        }else {
            AlertDialog.Builder dialog =new AlertDialog.Builder(this);
            AlertDialog dialog1 = dialog.create();
            dialog1.setTitle("please wait..");
            dialog1.setMessage("we are connecting your information ");
            dialog1.show();
            user();


        }




    }

    private void user() {

        String userEmail = et1.getEditableText().toString().trim();
        String userPassword = et2.getEditableText().toString().trim();

        firebaseAuth.signInWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull  Task<AuthResult> task) {

                if (task.isSuccessful()){
                    Toast.makeText(log_in.this, "logged in successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(log_in.this , user_main_interface.class);
                    startActivity(intent);
                    finish();

                }else {
                    Toast.makeText(log_in.this, "Email or Password are incorrect", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }
}




