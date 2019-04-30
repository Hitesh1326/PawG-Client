package com.petfinder.pawg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * This is the home page of the application which consist of text box for user and button to send the query.
 */
public class MainActivity extends AppCompatActivity {


    EditText userQuery;
    Button btnSearch;
    ImageView lookingImage, homepageImage, searchLineImage;
//nice
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userQuery = (EditText) findViewById(R.id.userQuery);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        lookingImage = (ImageView) findViewById(R.id.lookingImage);
        homepageImage = (ImageView) findViewById(R.id.homepageImage);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = userQuery.getText().toString().trim();
                //validation of query, it should not be empty.
                if (query.isEmpty()) {
                    userQuery.setError("Input is required");
                    userQuery.requestFocus();
                    return;
                }
                Intent intent = new Intent(MainActivity.this, Result.class);
                intent.putExtra(Intent.EXTRA_TEXT, query);
                startActivity(intent);
            }
        });


    }
}
