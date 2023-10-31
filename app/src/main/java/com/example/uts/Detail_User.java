package com.example.uts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class Detail_User extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);
        String[] alamatArray = getResources().getStringArray(R.array.data_alamat);
        String[] emailArray = getResources().getStringArray(R.array.data_email);

        Intent intent = getIntent();

        int position = getIntent().getIntExtra("position", 0);

        String name = intent.getStringExtra("name");
        String alamat = alamatArray[position];
        String email = emailArray[position];
        int photo = intent.getIntExtra("photo", 0);

        TextView nameTextView = findViewById(R.id.tv_item_name);
        TextView alamatTextView = findViewById(R.id.addressTextView);
        TextView emailTextView = findViewById(R.id.emailTextView);
        ImageView photoImageView = findViewById(R.id.img_item_photo);

        nameTextView.setText(name);
        alamatTextView.setText("Alamat: " + alamat);
        emailTextView.setText("Email: " + email);
        photoImageView.setImageResource(photo);

        Glide.with(this)
                .load(photo) // Isi dengan URL atau sumber gambar
                .circleCrop() // Menggunakan crop sirkuler
                .into(photoImageView);
    }
}
