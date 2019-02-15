package com.aliguraras.buildpc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.aliguraras.buildpc.Adapters.CustomAdapterMotherboard;
import com.aliguraras.buildpc.models.Motherboard;

import java.util.ArrayList;

public class MotherboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motherboard);

        Button MotherboardSaveButton = findViewById(R.id.MotherboardSaveButton);
        final Spinner dropdown = findViewById(R.id.MotherboardSpinner);

        Motherboard asus = new Motherboard("ASUS", "EX-A320M-GAMING");
        Motherboard gigabyte = new Motherboard("GIGABYTE", "Z370P D3");
        Motherboard msi = new Motherboard("MSI", "MPG Z390 GAMING PRO CARBON");

        final ArrayList motherboards = new ArrayList<Motherboard>();
        motherboards.add(asus);
        motherboards.add(gigabyte);
        motherboards.add(msi);

        CustomAdapterMotherboard adapter = new CustomAdapterMotherboard(this, motherboards);
        dropdown.setAdapter(adapter);

        MotherboardSaveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Motherboard motherboard = (Motherboard) motherboards.get(dropdown.getSelectedItemPosition());
                Close(motherboard);
            }
        });
    }

    private void Close(Motherboard motherboard){
        Intent intent = new Intent();
        intent.putExtra("Motherboard", motherboard);
        setResult(RESULT_OK, intent);
        finish();
    }
}
