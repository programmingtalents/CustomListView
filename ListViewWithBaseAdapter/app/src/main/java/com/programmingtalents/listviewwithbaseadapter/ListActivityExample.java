package com.programmingtalents.listviewwithbaseadapter;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;


import com.programmingtalents.listviewwithbaseadapter.adapters.CustomAdapter;
import com.programmingtalents.listviewwithbaseadapter.models.CustomHandler;

import java.util.ArrayList;

/**
 * Created by Amit on 6/21/2016.
 */
public class ListActivityExample extends ListActivity {

    String subjects[]=new String[]{
            "Maths","Science", "English", "Chemistry", "Biology", "Physical Education", "Computers", "Music", "Moral Science"
    } ;
    ArrayList<CustomHandler> model= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity_example);
        for(int i=0; i<subjects.length; i++){
            CustomHandler handler= new CustomHandler();
            handler.setName(subjects[i]);
            handler.setDescription("This is description about "+ subjects[i]);
            model.add(handler);
        }
       CustomAdapter adapter= new CustomAdapter(this, model);
       setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(this,subjects[position] + "\n "+ model.get(position).getDescription(), Toast.LENGTH_SHORT).show();
    }
}
