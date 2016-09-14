package com.augmentis.ayp.time;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button btn;
    String a;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edt_text);



        textView = (TextView) findViewById(R.id.txt_view);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                a = editText.getText().toString();
                number = Integer.valueOf(a);

                new Asynctask().execute(number);
            }
        });

    }


    public class Asynctask extends AsyncTask<Integer,Integer,String> {

        @Override
        protected String doInBackground(Integer... integers) {

            for(int i = integers[0] ; i >= 0 ; i--) {
                publishProgress(i);
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return "FINISH";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            textView.setText(values[0].toString());
        }

        @Override
        protected void onPostExecute(String int1) {
            textView.setText(int1);
        }
    }
}
