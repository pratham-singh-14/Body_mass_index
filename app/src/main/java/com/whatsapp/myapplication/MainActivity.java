package com.whatsapp.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private EditText edthft,edthin,edtwt;
    private Button btn;
    private TextView txt;
    private ImageView image,bmi1;
    private LinearLayout Linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edthft=findViewById(R.id.edthft);
        edthin=findViewById(R.id.edthin);
        edtwt=findViewById(R.id.edtwt);
        btn=findViewById(R.id.btn);
        txt=findViewById(R.id.txt);
        Linear=findViewById(R.id.lll);
        image=findViewById(R.id.imagegif);
        bmi1=findViewById(R.id.bmi);

btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
       String ff= edthft.getText().toString();
      String ww=  edtwt.getText().toString();
      String ii=  edthin.getText().toString();

        if(ff.isEmpty() || ii.isEmpty() || ww.isEmpty())
        {
            Toast.makeText(MainActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
        }
      else
        {
            int ft=Integer.parseInt(ff);
            int in=Integer.parseInt(ii);
            int wt=Integer.parseInt(ww);
            int tht=ft*12+in;

            double totalheightcm=tht*2.53;
            double totalheightmeter=totalheightcm/100;
            double bmi=wt/(totalheightmeter*totalheightmeter);
            if(bmi>25){
                txt.setText("You're Overweighted ");
                bmi1.setVisibility(View.GONE);
                txt.setVisibility(View.VISIBLE);
                Glide.with(MainActivity.this).load(getResources().getDrawable(R.drawable.shock)).into(image);
                image.setVisibility(View.VISIBLE);

            //    Linear.setBackgroundColor(getResources().getColor(R.color.red));
            }else if(bmi<18)
            {
                txt.setText("You're Underweighted");
                txt.setVisibility(View.VISIBLE);
                bmi1.setVisibility(View.GONE);
               Glide.with(MainActivity.this).load(getResources().getDrawable(R.drawable.normal)).into(image);
                image.setVisibility(View.VISIBLE);
                image.setImageResource(R.drawable.normal);

             //   Linear.setBackgroundColor(getResources().getColor(R.color.yellow));
            }else {
                txt.setText("You're Healthy");

                txt.setVisibility(View.VISIBLE);
              //  Glide.with(MainActivity.this).load(R.drawable.healthy).into(image);
                image.setVisibility(View.VISIBLE);
                bmi1.setVisibility(View.GONE);
                Glide.with(MainActivity.this).load(getResources().getDrawable(R.drawable.healthy)).into(image);
            }
          //  Linear.setBackgroundColor(getResources().getColor(R.color.green));
        }
    }
});

    }
}