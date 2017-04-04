package ro.pub.cs.systems.eim.practicaltest01Var07;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PracticalTest01Var07SecondaryActivity extends Activity {

    private TextView sum = null;
    private TextView resultSum = null;
    private Button compute = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.compute:
                    setResult(RESULT_OK, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_secondary);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("nonEditableContent")) {
            String result = intent.getStringExtra("nonEditableContent");

            int suma = 0;
            String res[] = result.split("+");
            for(String s : res) {
                suma += Integer.valueOf(s);
            }
            resultSum = (EditText)findViewById(R.id.result);
            resultSum.setText(String.valueOf(suma));
        }

        compute.setOnClickListener(buttonClickListener);
    }
}
