package com.example.jesustovartrujillo.barbermarket;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.example.jesustovartrujillo.barbermarket.MainPeluquerias.EXTRA_NAME;
import static com.example.jesustovartrujillo.barbermarket.MainPeluquerias.EXTRA_URL;

public class PeluqueriaDetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peluqueria_detalle);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String name = intent.getStringExtra(EXTRA_NAME);

        ImageView imageView = findViewById(R.id.image_view_detail);
        TextView textViewName = findViewById(R.id.text_view_name_detail);

        Picasso.get().load(imageUrl).fit().centerInside().into(imageView);
        textViewName.setText(name);
    }
}
