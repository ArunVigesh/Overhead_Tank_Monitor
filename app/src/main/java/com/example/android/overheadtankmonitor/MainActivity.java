package com.example.android.overheadtankmonitor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    data value;
    int s1,s2;
    int m1,m2;
    int mb1,mb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView statuss1= findViewById(R.id.statustank1);
        final TextView statuss2=findViewById(R.id.statustank2);
        final TextView motors1= findViewById(R.id.textView3);
        final TextView motors2=findViewById(R.id.textView4);
        final ImageView low11=findViewById(R.id.imageView4);
        final ImageView low12=findViewById(R.id.imageView6);
        final ImageView low21=findViewById(R.id.imageView5);
        final ImageView low22=findViewById(R.id.imageView7);
        final ImageView mid11=findViewById(R.id.imageView10);
        final ImageView mid12=findViewById(R.id.imageView11);
        final ImageView mid21=findViewById(R.id.imageView8);
        final ImageView mid22=findViewById(R.id.imageView13);
        final ImageView high11=findViewById(R.id.imageView12);
        final ImageView high12=findViewById(R.id.imageView15);
        final ImageView high21=findViewById(R.id.imageView14);
        final ImageView high22=findViewById(R.id.imageView16);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                value = dataSnapshot.getValue(data.class);
                Log.d("TAG", "S1 Value is: " + value.getStatus1());
                Log.d("TAG", "S2 Value is: " + value.getStatus2());
                s1=value.getStatus1();
                s2=value.getStatus2();
                m1=value.getMotor1();
                m2=value.getMotor2();
                mb1=value.getMotor1();
                mb2=value.getMotor2();
                if(s1==0)
                {
                    statuss1.setText("Low Water");
                    statuss1.setTextColor(Color.rgb(255,0,0));
                    low11.setVisibility(View.VISIBLE);
                    low12.setVisibility(View.VISIBLE);
                    mid11.setVisibility(View.GONE);
                    mid12.setVisibility(View.GONE);
                    high11.setVisibility(View.GONE);
                    high12.setVisibility(View.GONE);
                    database.getReference("motor1").setValue(1);


                }
                else if(s1==1)
                {
                    statuss1.setText("Sufficient Water");
                    statuss1.setTextColor(Color.rgb(0,0,255));
                    low11.setVisibility(View.VISIBLE);
                    low12.setVisibility(View.VISIBLE);
                    mid11.setVisibility(View.VISIBLE);
                    mid12.setVisibility(View.VISIBLE);
                    high11.setVisibility(View.GONE);
                    high12.setVisibility(View.GONE);
                }
                else if(s1==2)
                {
                    statuss1.setText("Overflow");
                    statuss1.setTextColor(Color.rgb(0,255,0));
                    low11.setVisibility(View.VISIBLE);
                    low12.setVisibility(View.VISIBLE);
                    mid11.setVisibility(View.VISIBLE);
                    mid12.setVisibility(View.VISIBLE);
                    high11.setVisibility(View.VISIBLE);
                    high12.setVisibility(View.VISIBLE);
                    database.getReference("motor1").setValue(0);
                }
                if(s2==0)
                {
                    statuss2.setText("Low Water");
                    statuss2.setTextColor(Color.rgb(255,0,0));
                    low21.setVisibility(View.VISIBLE);
                    low22.setVisibility(View.VISIBLE);
                    mid21.setVisibility(View.GONE);
                    mid22.setVisibility(View.GONE);
                    high21.setVisibility(View.GONE);
                    high22.setVisibility(View.GONE);
                    database.getReference("motor2").setValue(1);

                }
                else if(s2==1)
                {
                    statuss2.setText("Sufficient Water");
                    statuss2.setTextColor(Color.rgb(0,0,255));
                    low21.setVisibility(View.VISIBLE);
                    low22.setVisibility(View.VISIBLE);
                    mid21.setVisibility(View.VISIBLE);
                    mid22.setVisibility(View.VISIBLE);
                    high21.setVisibility(View.GONE);
                    high22.setVisibility(View.GONE);
                }
                else if(s2==2)
                {
                    statuss2.setText("Overflow");
                    statuss2.setTextColor(Color.rgb(0,255,0));
                    low21.setVisibility(View.VISIBLE);
                    low22.setVisibility(View.VISIBLE);
                    mid21.setVisibility(View.VISIBLE);
                    mid22.setVisibility(View.VISIBLE);
                    high21.setVisibility(View.VISIBLE);
                    high22.setVisibility(View.VISIBLE);
                    database.getReference("motor2").setValue(0);
                }
                if(m1==0){
                    motors1.setText("OFF");
                    motors1.setTextColor(Color.rgb(255,0,0));

                }
                else if(m1==1)
                {
                    motors1.setText("ON");
                    motors1.setTextColor(Color.rgb(0,255,0));
                }
                if(m2==0)
                {
                    motors2.setText("OFF");
                    motors2.setTextColor(Color.rgb(255,0,0));
                }
                else if(m2==1)
                {
                    motors2.setText("ON");
                    motors2.setTextColor(Color.rgb(0,255,0));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
    }

}
