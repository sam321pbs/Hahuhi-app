package com.example.sammengistu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;

import HahuhiGame.hahuhi.R;

/**
 * Created by SamMengistu on 12/2/15.
 */
public class SelectGameActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle onSavedInstanceState){
        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.second_page_activity);

        ImageView hahuhiGameIcon = (ImageView) findViewById(R.id.hahuhi_game_starter);
        hahuhiGameIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectGameActivity.this, MainBalloonActivity.class);
                startActivity(intent);
            }
        });
    }
}
