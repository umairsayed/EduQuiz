package com.example.quiz;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Subject extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"C++", "Java", "Python", "Android"};
    String mDescription[] = {"Quiz on C++", "Quiz on Java ", "Quiz on Python", "Quiz on Android"};
    int images[] = {R.drawable.c, R.drawable.java, R.drawable.python, R.drawable.android,};
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        intent = new Intent(this,Test.class);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.listView);
        // now create an adapter class

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Toast.makeText(Subject.this, "C++ Quiz started", Toast.LENGTH_SHORT).show();
                    {
                        intent.putExtra("Subject", 1);
                        startActivity(intent);
                        finish();
                    }

                }
                if (position ==  1) {
                    Toast.makeText(Subject.this, "Java Quiz started", Toast.LENGTH_SHORT).show();
                    {
                        intent.putExtra("Subject", 2);
                        startActivity(intent);
                        finish();
                    }
                }
                if (position ==  2) {
                    Toast.makeText(Subject.this, "Python Quiz started", Toast.LENGTH_SHORT).show();
                    {
                        intent.putExtra("Subject", 3);
                        startActivity(intent);
                        finish();
                    }
                }
                if (position ==  3) {
                    Toast.makeText(Subject.this, "Android Quiz started", Toast.LENGTH_SHORT).show();
                    {
                        intent.putExtra("Subject", 4);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;
        }
    }
}
