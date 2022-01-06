package com.example.myproject2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class new_regitration extends AppCompatActivity {


    FirebaseAuth mAuth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    AlertDialog.Builder dialog;

    EditText ed1, ed2, ed3, ed4;
    Button b1;



    private boolean validateName() {
        String val = ed1.getEditableText().toString();
        if (val.isEmpty()) {
            ed1.setError("Field can not be empty");
            return false;
        } else {
            ed1.setError(null);
            return true;
        }

    }

    private boolean validatePhone() {
        String val = ed1.getEditableText().toString();
        if (val.isEmpty()) {
            ed2.setError("Field can not be empty");
            return false;
        } else {
            ed2.setError(null);
            return true;
        }

    }

    private boolean validateEmail() {
        String val = ed1.getEditableText().toString();
        if (val.isEmpty()) {
            ed3.setError("Field can not be empty");
            return false;
        } else {
            ed3.setError(null);
            return true;
        }

    }

    private boolean validatePassword() {
        String val = ed1.getEditableText().toString();
        if (val.isEmpty()) {
            ed4.setError("Field can not be empty");
            return false;
        } else {
            ed4.setError(null);
            return true;
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_regitration);


        ed1 = findViewById(R.id.new_userNmae);
        ed2 = findViewById(R.id.new_user_mobile_no);
        ed3 = findViewById(R.id.new_user_password);
        ed4 = findViewById(R.id.new_user_email_id);
        b1 = findViewById(R.id.register);


        mAuth = FirebaseAuth.getInstance();

        String phoneNo;

        dialog =new AlertDialog.Builder(new_regitration.this);
        AlertDialog dialog1=dialog.create();
        dialog1.setTitle("please wait..");
        dialog1.setMessage("we are creating your profile ");



        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        if (mAuth.getCurrentUser() != null) {
            dialog1.cancel();
            Intent intent = new Intent(new_regitration.this, user_profile.class);
            startActivity(intent);
            finish();

        } else


            b1.setOnClickListener(new View.OnClickListener() {
                private static final String TAG = "hi";

                @Override
                public void onClick(View v) {


                    if (!validateName() | !validatePhone() | !validateEmail() | !validatePassword()) {
                        return;
                    } else {
                        dialog1.show();


                        String name = ed1.getEditableText().toString();
                        String phoneNo = ed2.getEditableText().toString();
                        String password = ed3.getEditableText().toString();
                        String Email = ed4.getEditableText().toString();


                        // register the user by  auth

                        mAuth.createUserWithEmailAndPassword(Email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    Toast.makeText(new_regitration.this, "user created", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(new_regitration.this, user_main_interface.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(new_regitration.this, "Error ! " + task.getException(), Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
                    }
                }
            });
    }
}


//
//                user_data userData = new user_data(name, phoneNo, Email, password);
//
//
//                Toast.makeText(new_regitration.this, " clicked ", Toast.LENGTH_SHORT).show();
//
//                rootNode = FirebaseDatabase.getInstance("https://my-project-2-fe245-default-rtdb.asia-southeast1.firebasedatabase.app/");
//                reference = rootNode.getReference("user");
//                reference.child(phoneNo).setValue(userData);
//
//            }
//        });
//
//
//    }
//
//
//}


