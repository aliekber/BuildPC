package com.aliguraras.buildpc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aliguraras.buildpc.models.Computer;
import com.aliguraras.buildpc.models.GraphicsCard;
import com.aliguraras.buildpc.models.RamModule;

public class BuildActivity extends AppCompatActivity {

    private Button buildUpdateButton;
    private Button buildCloseButton;
    private Computer computer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build);

        computer = (Computer) getIntent().getExtras().getSerializable("Computer");

        createTextViews();

        getButtons();

        setListeners();
    }

    private void createTextViews(){
        TextView motherboard = findViewById(R.id.ResultBuildMotherbordTextView);
        motherboard.setText("Moederbord:\n" + computer.getMotherboard().getBrand() + " " + computer.getMotherboard().getModel());
        TextView ramModule = findViewById(R.id.ResultBuildRamModuleTextView);
        ramModule.setText("Ram module:\n" + computer.getRamModule().getBrand() + " " + computer.getRamModule().getModel() + " " + computer.getRamModule().getSizeInGb());
        TextView graphicsCard = findViewById(R.id.ResultBuildGraphicsCardTextView);
        graphicsCard.setText("Videokaart:\n" + computer.getGraphicsCard().getBrand() + " " + computer.getGraphicsCard().getModel() + " " + computer.getGraphicsCard().getSizeInGb());

    }

    private void getButtons(){
        buildUpdateButton = findViewById(R.id.BuildUpdateButton);
        buildCloseButton = findViewById(R.id.BuildCloseButton);
    }

    private void setListeners(){
        buildUpdateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Close(true);
            }
        });

        buildCloseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Close(false);
            }
        });
    }

    private void Close(Boolean update){
        Intent intent = new Intent();
        intent.putExtra("Update", update);
        setResult(RESULT_OK, intent);
        finish();
    }
}
