package com.test.ndkcountupdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  // Used to load the 'native-lib' library on application startup.
  static {
    System.loadLibrary("native-lib");
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    final TextView tv = (TextView) findViewById(R.id.counter);
    tv.setText("0");

    Button actionBtn = (Button) findViewById(R.id.actionBtn);
    actionBtn.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        int newCount = countFromJNI(Integer.parseInt(tv.getText().toString()));
        tv.setText(String.valueOf(newCount));
      }
    });
  }

  /**
   * A native method that is implemented by the 'native-lib' native library,
   * which is packaged with this application.
   */
  public native int countFromJNI(int currentCount);
}
