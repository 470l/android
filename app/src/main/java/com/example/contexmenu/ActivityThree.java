package com.example.contexmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class ActivityThree extends AppCompatActivity {

    private Button contextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        //Tell the system this button is long press button for context menu
        contextButton = findViewById(R.id.context_menu_button);
        registerForContextMenu(contextButton);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_for, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return new MainActivity().getMenuOption(item, this);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        return new MainActivity().getContextItem(item,this);
    }

    @SuppressLint("NonConstantResourceId")
    public void showPopup(View view) {
        System.out.println("Pop");
        PopupMenu popup = new PopupMenu(ActivityThree.this, view);
        popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(item -> {

                    int item_id = item.getItemId();
                    Intent intent;
                    switch (item_id) {
                        case R.id.activity_one:
                            intent = new Intent(ActivityThree.this, MainActivity.class);
                            startActivity(intent);
                            break;
                        case R.id.activity_two:
                            intent = new Intent(ActivityThree.this, ActivityTwo.class);
                            startActivity(intent);
                            break;
                        case R.id.activity_three:
                            intent = new Intent(ActivityThree.this, ActivityThree.class);
                            startActivity(intent);
                            break;
                    }
                    return true;
                }
        );
        popup.show();
    }


}