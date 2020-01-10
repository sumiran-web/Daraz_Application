package com.example.daraz_application;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AdminAddNewProduct  extends AppCompatActivity
{
    private String CategoryName;
    private Button AddNewProductButton;
    private EditText InputProductName, InputProductDescription, InputProductPrice;
    private ImageView InputProductImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_new_product);



        CategoryName = getIntent().getExtras().get("category").toString();

        AddNewProductButton = findViewById(R.id.add_new_product);
        InputProductName = findViewById(R.id.product_name);
        InputProductDescription = findViewById(R.id.product_description);
        InputProductPrice = findViewById(R.id.product_price);
        InputProductImage = findViewById(R.id.select_product_image);

    }
}

