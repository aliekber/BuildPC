package com.aliguraras.buildpc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.aliguraras.buildpc.Adapters.CustomAdapterMotherboard;
import com.aliguraras.buildpc.Adapters.CustomAdapterRamModule;
import com.aliguraras.buildpc.models.Motherboard;
import com.aliguraras.buildpc.models.RamModule;

import java.util.ArrayList;

public class RamModuleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ram_module);

        Button ramModuleSaveButton = findViewById(R.id.RamModuleSaveButton);
        final Spinner spinner = findViewById(R.id.RamModuleSpinner);

        RamModule corsair = new RamModule("CORSAIR", "Vengeance RGB Pro", 16);
        RamModule gskill = new RamModule("G.Skill", "Aegis", 8);
        RamModule hyperx = new RamModule("HYPERX", "Predator", 16);

        final ArrayList ramModules = new ArrayList<RamModule>();
        ramModules.add(corsair);
        ramModules.add(gskill);
        ramModules.add(hyperx);

        CustomAdapterRamModule adapter = new CustomAdapterRamModule(this, ramModules);
        spinner.setAdapter(adapter);

        ramModuleSaveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RamModule ramModule = (RamModule) ramModules.get(spinner.getSelectedItemPosition());
                Close(ramModule);
            }
        });
    }

    private void Close(RamModule ramModule){
        Intent intent = new Intent();
        intent.putExtra("RamModule", ramModule);
        setResult(RESULT_OK, intent);
        finish();
    }
}
