package com.example.sammengistu.hahuhi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by SamMengistu on 11/24/15.
 */
public class StartGamePageActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.start_game_page_activity);

        ImageView startGame = (ImageView) findViewById(R.id.starter_page_button);
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartGamePageActivity.this, SelectGameActivity.class);
                startActivity(intent);
            }
        });
    }
}
