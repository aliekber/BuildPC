package com.aliguraras.buildpc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.aliguraras.buildpc.Adapters.CustomAdapterGraphicsCard;
import com.aliguraras.buildpc.Adapters.CustomAdapterMotherboard;
import com.aliguraras.buildpc.models.GraphicsCard;
import com.aliguraras.buildpc.models.Motherboard;

import java.util.ArrayList;

public class GraphicsCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphics_card);

        Button GraphicsCardSaveButton = findViewById(R.id.GraphicsCardSaveButton);
        final Spinner spinner = findViewById(R.id.GraphicsCardSpinner);

        GraphicsCard asus = new GraphicsCard("ASUS", "ROG Strix GeForce RTX 2080 Ti", 11);
        GraphicsCard gigabyte = new GraphicsCard("GIGABYTE", "GeForce RTX 2060 OC", 6);
        GraphicsCard msi = new GraphicsCard("MSI", "GeForce RTX 2070 ARMOR", 8);

        final ArrayList graphicsCards = new ArrayList<GraphicsCard>();
        graphicsCards.add(asus);
        graphicsCards.add(gigabyte);
        graphicsCards.add(msi);

        CustomAdapterGraphicsCard adapter = new CustomAdapterGraphicsCard(this, graphicsCards);
        spinner.setAdapter(adapter);

        GraphicsCardSaveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GraphicsCard graphicsCard = (GraphicsCard) graphicsCards.get(spinner.getSelectedItemPosition());
                Close(graphicsCard);
            }
        });
    }

    private void Close(GraphicsCard graphicsCard){
        Intent intent = new Intent();
        intent.putExtra("GraphicsCard", graphicsCard);
        setResult(RESULT_OK, intent);
        finish();
    }
}
