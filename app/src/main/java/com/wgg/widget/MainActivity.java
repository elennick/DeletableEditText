package com.wgg.widget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Test activity with an example of a DeletableEditText in use.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        DeletableEditText editText = (DeletableEditText)findViewById(R.id.deletableEditTextExample);

        //can set clear button size to SMALL, NORMAL or BIG
        editText.setButtonSize(DeletableEditText.BUTTON_SIZE_NORMAL);

        //can listen for events that are triggered when the clear button is pressed
        editText.setOnTextClearedListener(new DeletableEditText.OnTextClearedListener() {
            @Override
            public void beforeTextCleared(final String textInEditText) {
                MainActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        Toast.makeText(
                            MainActivity.this,
                            "About to clear text: " + textInEditText,
                            Toast.LENGTH_SHORT
                        ).show();
                    }
                });
            }

            @Override
            public void afterTextCleared() {
                MainActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        Toast.makeText(
                            MainActivity.this,
                            "Text cleared!",
                            Toast.LENGTH_SHORT
                        ).show();
                    }
                });
            }
        });
    }
}
