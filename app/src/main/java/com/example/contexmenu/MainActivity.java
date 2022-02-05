package com.example.contexmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tell the system this button is long press button for context menu
        Button contextButton = findViewById(R.id.context_menu_button);
        registerForContextMenu(contextButton);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return getMenuOption(item, this);
    }


    @SuppressLint("NonConstantResourceId")
    public boolean getMenuOption(@NonNull MenuItem item, Context context) {
        //Find current selected option in the menu
        int item_id = item.getItemId();
        System.out.println(item.getTitle() + "----------------");
        switch (item_id) {
            case R.id.android:
                Toast.makeText(context, "This is Android option item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting:
                Toast.makeText(context, "This is Setting option item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.download:
                Toast.makeText(context, "This is Download option item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.profile:
                Toast.makeText(context, "This is Profile option item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share:
                Toast.makeText(context, "This is Share option item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit: {
                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setTitle("System Warning");
                alert.setMessage("This action close entire application");
                alert.setPositiveButton("Yes", (dialog, which) -> System.exit(0));
                alert.setNegativeButton("No", (dialog, which) -> Toast.makeText(context, "This is Exit option item", Toast.LENGTH_SHORT).show());
                alert.show();
            }
        }

        return true;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        return getContextItem(item,this);
    }

    @SuppressLint("NonConstantResourceId")
    public boolean getContextItem(@NonNull MenuItem item, Context context) {
        //Get the current selected context menu option
        int item_id = item.getItemId();

        switch (item_id) {
            case R.id.share_google:
                Toast.makeText(context, "Your file share to google", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share_i_search:
                Toast.makeText(context, "Your file share to ISearch", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share_chrome:
                Toast.makeText(context, "Your file share to chrome", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }


    @SuppressLint("NonConstantResourceId")
    public void showPopup(View view) {
        System.out.println("Pop");
        PopupMenu popup = new PopupMenu(MainActivity.this, view);
        popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(item -> extracted(item, this) );
        popup.show();

    }

    @SuppressLint("NonConstantResourceId")
    public boolean extracted(MenuItem item, Context context) {
        int item_id = item.getItemId();
        Intent intent;
        switch (item_id) {
            case R.id.activity_one:
                intent = new Intent(context, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.activity_two:
                intent = new Intent(context, ActivityTwo.class);
                startActivity(intent);
                break;
            case R.id.activity_three:
                intent = new Intent(context, ActivityThree.class);
                startActivity(intent);
                break;
        }

        return true;
    }
}








