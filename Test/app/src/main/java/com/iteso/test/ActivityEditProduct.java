package com.iteso.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.iteso.test.Beans.ItemProduct;

public class ActivityEditProduct extends AppCompatActivity {
    private ItemProduct itemProduct;
    private ImageView image;
    private EditText title;
    private EditText store;
    private EditText location;
    private EditText phone;
    private Button send, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);

        image    = findViewById(R.id.activity_edit_image);
        title    = findViewById(R.id.activity_edit_name);
        store    = findViewById(R.id.activity_edit_store);
        location = findViewById(R.id.activity_edit_location);
        phone    = findViewById(R.id.activity_edit_phone);
        send     = findViewById(R.id.activity_edit_save);
        cancel   = findViewById(R.id.activity_edit_cancel);

        itemProduct = getIntent().getExtras().getParcelable("PRODUCT");
        if(itemProduct != null){
            switch (itemProduct.getImage()){
                case 0:
                    image.setImageResource(R.drawable.mac);
                    break;
                case 1:
                    image.setImageResource(R.drawable.alienware);
                    break;
            }

            title.setText(itemProduct.getTitle());
            store.setText(itemProduct.getStore());
            location.setText(itemProduct.getLocation());
            phone.setText(itemProduct.getPhone());
        }

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemProduct.setTitle(title.getText().toString().trim());
                itemProduct.setStore(store.getText().toString().trim());
                itemProduct.setLocation(location.getText().toString().trim());
                itemProduct.setPhone(phone.getText().toString().trim());

                Intent result = new Intent();
                result.putExtra("PRODUCT", itemProduct);
                setResult(RESULT_OK, result);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();
                setResult(RESULT_CANCELED, result);
                finish();
            }
        });

    }
}
