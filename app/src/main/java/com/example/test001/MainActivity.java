package com.example.test001;

import static java.security.AccessController.getContext;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
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

/*        int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 0;
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.GET_ACCOUNTS)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.GET_ACCOUNTS)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.GET_ACCOUNTS},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            }
        }*/


        //AccountManager accountManager = (AccountManager) this.getSystemService(ACCOUNT_SERVICE);
        //AccountManager accountManager = AccountManager.get(this);
        //Account[] accounts = accountManager.getAccountsByType(null);
        //AccountManager manager = (AccountManager) getApplicationContext().getSystemService(Context.ACCOUNT_SERVICE);
        //Account[] accounts = manager.getAccounts();
/*        final AccountManager accountManager = AccountManager.get(getApplicationContext());
        final Account[] accounts = accountManager.getAccountsByType(null);*/
        //Log.d("boom", Arrays.toString(accounts));
        //for (Account account : accounts) {
        //    Log.d("boom", account.name);
/*       //     if (accounts[index].type.intern() == AUTHORITY)
         //       accountManager.removeAccount(accounts[index], null, null);*/
        //}
        final var ACCOUNT_PICK = 1;
        AccountManager accountManager = AccountManager.get(getApplicationContext());
        Intent intent = AccountManager.newChooseAccountIntent(
                null,
                null,
                null,
                false,
                null,
                null,
                null,
                null);
        //startActivityForResult(intent, ACCOUNT_PICK);

        Log.d("boom", Arrays.toString(accountManager.getAuthenticatorTypes()));
        Log.d("boom", Arrays.toString(accountManager
                .getAccountsByTypeForPackage("com.yandex.passport","ru.kinopoisk.tv")));
        Account[] accounts = accountManager.getAccountsByType(null);

        Log.d("boom", Arrays.toString(accounts));
        for (Account account : accounts) {
            Log.d("boom", "account: " + account.name + " : " + account.type);
            Log.d("boom", "mmmmmm");
            accountManager.removeAccount(account, null, null);

        }

    }
}

