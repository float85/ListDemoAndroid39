package com.example.listviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ListView lvContact;
    Contact contact1, contact2, contact3, contact4, contact5;
    AdapterContact adapterContact;

    List<Contact> contactList;

    RelativeLayout btnAdd;
    int position;

    int ADD_CONTACT_LIST = 113;
    int EDIT_CONTACT_LIST = 115;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContact = findViewById(R.id.lvContact);
        btnAdd = findViewById(R.id.btnAdd);
        contactList = new ArrayList<>();

        contact1 = new Contact("Mr A", 12345678, false);
        contact2 = new Contact("Mr B", 1234432, true);
        contact3 = new Contact("Mr C", 12346542, false);
        contact4 = new Contact("Mr D", 1234467, true);
        contact5 = new Contact("Mr E", 1234432, false);

        contactList.add(contact1);
        contactList.add(contact2);
        contactList.add(contact3);
        contactList.add(contact4);
        contactList.add(contact5);

        adapterContact = new AdapterContact(contactList);
        lvContact.setAdapter(adapterContact);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getBaseContext(), AddNewList.class);
                //Truyền 1 object bằng intent
                intent.putExtra("contact", contact1);
//                startActivity(intent);
                startActivityForResult(intent, ADD_CONTACT_LIST);
            }
        });

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = contactList.get(i).getName();
                int number = contactList.get(i).getNumber();

                Toast.makeText(getBaseContext(), "Name: " + name
                        + "\n" + "Number: " + number, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getBaseContext(), AddNewList.class);
                //truyền 1 biến string qua activity khác
                intent.putExtra("name", name);
//                startActivity(intent);
                position = i;
                startActivityForResult(intent, EDIT_CONTACT_LIST);

            }
        });


//        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String name = contactList.get(i).getName();
//
//                Toast.makeText(getBaseContext(), name, Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            // hứng sự kiện khi chọn nút add thêm item
            if (requestCode == ADD_CONTACT_LIST) {
                String name = data.getStringExtra("name");
                int phone = data.getIntExtra("phone", 0);
                contactList.add(new Contact(name, phone, true));
            }
            // hứng sự kiện khi chọn nút edit item
            else if (requestCode == EDIT_CONTACT_LIST) {
                String phone = data.getStringExtra("phone");
                String name = data.getStringExtra("name");
                contactList.set(position, new Contact(name, Integer.parseInt(phone), true));
            }
        }
    }
}
