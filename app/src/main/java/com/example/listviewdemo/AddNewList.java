package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewList extends AppCompatActivity {

    EditText etName, etPhone;
    Button btnOK,btnEdit;
    String name="", phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_list);

        etName = findViewById(R.id.etNameNew);
        etPhone = findViewById(R.id.etPhoneNew);
        btnOK = findViewById(R.id.btnOK);
        btnEdit = findViewById(R.id.btnEdit);

        Intent intent = getIntent();

        name = intent.getStringExtra("name");

        etName.setText(name);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = etName.getText().toString();
                phone = etPhone.getText().toString();

                Intent intent=new Intent(getBaseContext(),MainActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("phone",phone);

                setResult(RESULT_OK,intent);
                finish();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etName.getText().toString();
             phone = etPhone.getText().toString();

                Intent intent=new Intent(getBaseContext(),MainActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("phone", phone);

                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
