package com.example.contexmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityTwo extends AppCompatActivity {


    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        //Tell the system this button is long press button for context menu
        textView = findViewById(R.id.context_menu_on_view);
        registerForContextMenu(textView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return new MainActivity().getMenuOption(item, this);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu_with_label, menu);
        menu.setHeaderTitle("Choose Your Option");

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        //Get the current selected context menu option
        int item_id = item.getItemId();

        switch (item_id) {
            case R.id.option1:

                Toast.makeText(this, "Enable Save In File", Toast.LENGTH_SHORT).show();
                break;
            case R.id.option2:
                item.setChecked(true);
                Toast.makeText(this, "GDrive Option Checked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.option3:
                item.setChecked(false);
                Toast.makeText(this, "Background Process Checked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.option4:
                Toast.makeText(this, "Enable", Toast.LENGTH_SHORT).show();
                break;
            case R.id.option51:
                Toast.makeText(this, "Share To Google", Toast.LENGTH_SHORT).show();
                break;
            case R.id.option52:
                Toast.makeText(this, "Share To Laylay", Toast.LENGTH_SHORT).show();
                break;
            case R.id.option53:
                Toast.makeText(this, "Share To Youtube", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @SuppressLint("NonConstantResourceId")
    public void showPopup(View view) {
        System.out.println("Pop");
        PopupMenu popup = new PopupMenu(ActivityTwo.this, view);
        popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(item -> {
            int item_id = item.getItemId();
            Intent intent;
            switch (item_id) {
                case R.id.activity_one:
                    intent = new Intent(ActivityTwo.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.activity_two:
                    intent = new Intent(ActivityTwo.this, ActivityTwo.class);
                    startActivity(intent);
                    break;
                case R.id.activity_three:
                    intent = new Intent(ActivityTwo.this, ActivityThree.class);
                    startActivity(intent);
                    break;
            }

            return true;
        });


        popup.show();
    }


}