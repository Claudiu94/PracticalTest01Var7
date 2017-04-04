package ro.pub.cs.systems.eim.practicaltest01Var07;

import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var07MainActivity extends AppCompatActivity {


    private EditText editable = null;
    private EditText nonEditable = null;
    private Button add = null;
    private Button compute = null;
    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.add:
                    int number = Integer.parseInt(editable.getText().toString());
                    String str = nonEditable.getText().toString();
                    str += " + ";
                    str += String.valueOf(number);
                    nonEditable.setText(str);
                    break;
                case R.id.compute:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var07SecondaryActivity.class);
                    String nonEditableContent = nonEditable.getText().toString();
                    intent.putExtra("nonEditableContent", nonEditableContent);
                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);

        editable = (EditText)findViewById(R.id.editable);
        nonEditable = (EditText)findViewById(R.id.nonEditable);
        nonEditable.setText(String.valueOf(0));


        add = (Button)findViewById(R.id.add);
        compute = (Button)findViewById(R.id.compute);

        add.setOnClickListener(buttonClickListener);
        compute.setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
}
