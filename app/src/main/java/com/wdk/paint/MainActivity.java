package com.wdk.paint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import yuku.ambilwarna.AmbilWarnaDialog;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.wdk.paint.display.colorList;
import static com.wdk.paint.display.current_brush;
import static com.wdk.paint.display.pathList;

public class MainActivity extends AppCompatActivity {
  public static Path path = new Path();
  public static Paint paint_brush = new Paint();

  int mDefaultcolor;
  Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button5 = findViewById(R.id.button5);

        mDefaultcolor = ContextCompat.getColor(MainActivity.this, R.color.colorPrimary);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openColorpicker();
            }
        });

    }

    public void openColorpicker(){
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, mDefaultcolor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                 mDefaultcolor = color;
                paint_brush.setColor(mDefaultcolor);
                currentcolor(paint_brush.getColor());
            }
        });
        colorPicker.show();
    }



    public void eraser(View view) {
paint_brush.setColor(Color.WHITE);
currentcolor(paint_brush.getColor());

    }



    public void currentcolor (int c){
        current_brush =c;
        path = new Path();
    }
}
