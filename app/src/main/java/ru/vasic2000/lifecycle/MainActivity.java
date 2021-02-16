package ru.vasic2000.lifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final String score1 = "Count1", score2 = "Count2", score3 = "Count3";

    public int count1 = 0, count2 = 0, count3 = 0;
    Button plus1, plus2, plus3;
    Button minus1, minus2, minus3;
    TextView text1, text2, text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            count1 = savedInstanceState.getInt(score1);
            count2 = savedInstanceState.getInt(score2);
            count3 = savedInstanceState.getInt(score3);
        }
        setContentView(R.layout.activity_main);

        initElements();

        Toast.makeText(getApplicationContext(), "OnCreated", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(score1, count1);
        outState.putInt(score2, count2);
        outState.putInt(score3, count3);

        Toast.makeText(getApplicationContext(), "InstanceSave", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "OnStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "OnResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "OnRestarted", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "OnPaused", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "OnStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "OnDestroy", Toast.LENGTH_SHORT).show();
    }

    private void initElements() {
        plus1 = findViewById(R.id.button12);
        plus2 = findViewById(R.id.button22);
        plus3 = findViewById(R.id.button32);

        minus1 = findViewById(R.id.button11);
        minus2 = findViewById(R.id.button21);
        minus3 = findViewById(R.id.button31);

        text1 = findViewById(R.id.textView1);
        text2 = findViewById(R.id.textView2);
        text3 = findViewById(R.id.textView3);

        View.OnClickListener onClickListener1p = v -> {
            count1++;
            text1.setText(String.valueOf(count1));
        };
        View.OnClickListener onClickListener2p = v -> {
            count2++;
            text2.setText(String.valueOf(count2));
        };
        View.OnClickListener onClickListener3p = v -> {
            count3++;
            text3.setText(String.valueOf(count3));
        };

        View.OnClickListener onClickListener1m = v -> {
            count1--;
            text1.setText(String.valueOf(count1));
        };
        View.OnClickListener onClickListener2m = v -> {
            count2--;
            text2.setText(String.valueOf(count2));
        };
        View.OnClickListener onClickListener3m = v -> {
            count3--;
            text3.setText(String.valueOf(count3));
        };

        plus1.setOnClickListener(onClickListener1p);
        plus2.setOnClickListener(onClickListener2p);
        plus3.setOnClickListener(onClickListener3p);

        minus1.setOnClickListener(onClickListener1m);
        minus2.setOnClickListener(onClickListener2m);
        minus3.setOnClickListener(onClickListener3m);

        text1.setText(String.valueOf(count1));
        text2.setText(String.valueOf(count2));
        text3.setText(String.valueOf(count3));
    }
}