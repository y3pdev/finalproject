package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateActivity extends AppCompatActivity {
    public EditText txt_name,txt_email,txt_password,txt_cfpassword,txt_phone;
    public TextView buttoncreateacc;
    public FirebaseAuth auth;
    public ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        txt_name = findViewById(R.id.txt_name);
        txt_email = findViewById(R.id.txt_email);
        txt_password = findViewById(R.id.txt_password);
        txt_cfpassword = findViewById(R.id.txt_cfpassword);
        txt_phone = findViewById(R.id.txt_phone);
        buttoncreateacc = findViewById(R.id.buttoncreateacc);

        auth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);

        if(auth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            finish();
        }

        buttoncreateacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String name = txt_name.getText().toString();
                String email = txt_email.getText().toString();
                String password = txt_password.getText().toString();
                //String cfpassword = txt_cfpassword.getText().toString();
                //String phone = txt_phone.getText().toString();

                if(TextUtils.isEmpty(email)){
                    txt_email.setError("กรุณากรอกอีเมล");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    txt_email.setError("กรุณากรอกรหัสผ่าน");
                    return;
                }

                if(password.length()<6){
                    txt_password.setError("รหัสผ่านควรมีความยาวมากกว่า 6 ตัวอักษร");
                }

                progressBar.setVisibility(View.VISIBLE);

                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(CreateActivity.this, "สมัครสมาชิกสำเร็จ", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else {
                            Toast.makeText(CreateActivity.this, "เกิดข้อผิดพลาดในการสมัคร" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}