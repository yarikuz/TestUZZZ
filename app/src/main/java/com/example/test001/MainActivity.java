package com.example.test001;

import static java.security.AccessController.getContext;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        TextView textViewContext = new TextView(getApplicationContext());
        textViewContext.setTextSize(30);
        textViewContext.setText("Application Context");
        textViewContext.setTextColor(Color.RED);
        TextView textViewActivityContext = new TextView(this);
        textViewActivityContext.setTextSize(30);
        textViewActivityContext.setText("Activity Context");
        linearLayout.addView(textViewContext);
        linearLayout.addView(textViewActivityContext);

/*        AccountManager accountManager = (AccountManager) this.getSystemService(ACCOUNT_SERVICE);
        //AccountManager accountManager = AccountManager.get(this);
        Account[] accounts = accountManager.getAccountsByType(null);*/

        final AccountManager accountManager = (AccountManager.get(getApplicationContext()));
        final Account[] accounts = accountManager.getAccountsByType(null);
        Log.d("boom", Arrays.toString(accounts));
        for (Account account : accounts) {
            Log.d("boom", account.name);
/*            if (accounts[index].type.intern() == AUTHORITY)
                accountManager.removeAccount(accounts[index], null, null);*/
        }

    }
}