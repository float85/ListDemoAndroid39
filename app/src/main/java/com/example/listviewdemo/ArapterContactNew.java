package com.example.listviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ArapterContactNew extends BaseAdapter {
    List<Contact> contactList;

    public ArapterContactNew(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_contact, parent, false);

        Contact contact = contactList.get(position);

        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvPhone = view.findViewById(R.id.tvNumber);
        ImageView imgView = view.findViewById(R.id.imgContact);

        tvName.setText(contact.getName());

        if (contact.isIcon()) imgView.setVisibility(View.VISIBLE);
        else imgView.setVisibility(View.GONE);

        return view;
    }
}
