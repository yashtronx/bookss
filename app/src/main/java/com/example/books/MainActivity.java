package com.example.books;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    String[] bookNames = {"The Silence of the Lambs","The Girl with the Dragon Tattoo","Kiss the Girls","In Cold Blood","The Da Vinci Code","The Shining","And Then There Were None","The Hunt tor Red October","The Hound of the Baskervilles","Dracula","The Stand","The Bone Collector","Jurassic Park"};
    String[] authors = {"Thomas Harris","Stieg Larsson","James Patterson","Truman Capote","Dan Brown","Stephen King","Agatha Christie","Tom Clancy","Sir Athur Conan Doyle","Bram Stoker","Stephen King","Jeffery Deaver","Michael Crichton"};
    int[] bookImages = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l,R.drawable.m};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter();

        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),GridItemActivity.class);

                intent.putExtra("name",bookNames[i]);
                intent.putExtra("image",bookImages[i]);
                intent.putExtra("author",authors[i]);
                startActivity(intent);

            }
        });
    }

    private class CustomAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return bookImages.length;

        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data,null);

            ImageView image = view1.findViewById(R.id.images);

            image.setImageResource(bookImages[i]);

            return view1;

        }
    }
}
