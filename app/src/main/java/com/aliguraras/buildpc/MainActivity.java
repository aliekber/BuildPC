package com.aliguraras.buildpc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aliguraras.buildpc.models.Computer;
import com.aliguraras.buildpc.models.GraphicsCard;
import com.aliguraras.buildpc.models.Motherboard;
import com.aliguraras.buildpc.models.RamModule;

public class MainActivity extends AppCompatActivity {

    private Computer computer = new Computer();
    private Button motherboardButton;
    private Button ramModuleButton;
    private Button graphicsCardButton;
    private Button deleteButton;
    private Button buildButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getButtons();

        buildButton.setEnabled(false);

        setListeners();

    }

    private void getButtons(){
        motherboardButton = findViewById(R.id.MotherboardButton);
        ramModuleButton = findViewById(R.id.RamModuleButton);
        graphicsCardButton = findViewById(R.id.GraphicsCardButton);
        deleteButton = findViewById(R.id.DeleteButton);
        buildButton = findViewById(R.id.ResultButton);
    }

    private void setListeners(){
        motherboardButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openMotherboardActivity();
            }
        });

        ramModuleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openRamModuleActivity();
            }
        });

        graphicsCardButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openGraphicsCardActivity();
            }
        });

        buildButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openBuildActivity();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                computer.deleteBuild();
                motherboardButton.setEnabled(true);
                ramModuleButton.setEnabled(true);
                graphicsCardButton.setEnabled(true);
                buildButton.setEnabled(false);
                motherboardButton.setText("Kiezen");
                ramModuleButton.setText("Kiezen");
                graphicsCardButton.setText("Kiezen");
            }
        });
    }

    private void openMotherboardActivity(){
        Intent intent = new Intent(this, MotherboardActivity.class);
        startActivityForResult(intent, 1);
    }

    private void openRamModuleActivity(){
        Intent intent = new Intent(this, RamModuleActivity.class);
        startActivityForResult(intent, 2);
    }

    private void openGraphicsCardActivity(){
        Intent intent = new Intent(this, GraphicsCardActivity.class);
        startActivityForResult(intent, 3);
    }

    private void openBuildActivity(){
        Intent intent = new Intent(this, BuildActivity.class);
        intent.putExtra("Computer", computer);
        startActivityForResult(intent, 4);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                Motherboard motherboard = (Motherboard) data.getExtras().getSerializable("Motherboard");
                computer.setMotherboard(motherboard);
                if (computer.getMotherboard() != null){
                    motherboardButton.setEnabled(false);
                    motherboardButton.setText("Gekozen");
                }
            }
        }

        if (requestCode == 2) {
            if(resultCode == RESULT_OK) {
                RamModule ramModule = (RamModule) data.getExtras().getSerializable("RamModule");
                computer.setRamModule(ramModule);
                if (computer.getRamModule() != null){
                    ramModuleButton.setEnabled(false);
                    ramModuleButton.setText("Gekozen");
                }
            }
        }

        if (requestCode == 3) {
            if(resultCode == RESULT_OK) {
                GraphicsCard graphicsCard = (GraphicsCard) data.getExtras().getSerializable("GraphicsCard");
                computer.setGraphicsCard(graphicsCard);
                if (computer.getGraphicsCard() != null){
                    graphicsCardButton.setEnabled(false);
                    graphicsCardButton.setText("Gekozen");
                }
            }
        }

        if (requestCode == 4) {
            if(resultCode == RESULT_OK) {
                Boolean update = data.getExtras().getBoolean("Update");
                if (update){
                    motherboardButton.setEnabled(true);
                    ramModuleButton.setEnabled(true);
                    graphicsCardButton.setEnabled(true);
                    motherboardButton.setText("Wijzigen");
                    ramModuleButton.setText("Wijzigen");
                    graphicsCardButton.setText("Wijzigen");
                }
            }
        }

        if (computer.getMotherboard() != null && computer.getRamModule() != null && computer.getGraphicsCard() != null){
            buildButton.setEnabled(true);
        }
    }

}
