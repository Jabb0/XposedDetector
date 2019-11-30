package de.jabb0.xposeddetector;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.PrintWriter;
import java.io.StringWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean xposedFound = false;
        try {
            String iAmAString = null;
            iAmAString.contains("Trololol");
        } catch (NullPointerException ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            if (exceptionAsString.toLowerCase().contains("de.robv.android.xposed")) {
                xposedFound = true;
            }
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (xposedFound) {
            builder.setMessage(R.string.dialog_message_xposed_found)
                    .setTitle(R.string.dialog_title_xposed_found);
        } else {
            builder.setMessage(R.string.dialog_message_xposed_not_found)
                    .setTitle(R.string.dialog_title_xposed_not_found);
        }
        builder.setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
