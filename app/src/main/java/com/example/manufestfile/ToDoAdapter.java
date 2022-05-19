package com.example.manufestfile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ToDoAdapter extends  ArrayAdapter<ToDo> {
    private Context context;
    private int resourse;
    List<ToDo> toDos;

    ToDoAdapter(Context context, int resourse, List<ToDo>  toDos){
        super(context,resourse,toDos);
        this.context=context;
        this.resourse = resourse;
        this.toDos = toDos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resourse,parent,false);

        TextView category = row.findViewById(R.id.category);
        TextView price = row.findViewById(R.id.price);
        TextView count = row.findViewById(R.id.count);
        TextView period = row.findViewById(R.id.period);
       // ImageView imageView = row.findViewById(R.id.Editpizza);

        ToDo todo = toDos.get(position);
        category.setText(todo.getCatagory());
        price.setText(todo.getPrice());
        count.setText(todo.getCount());
        period.setText(todo.getPeriod());
        //imageView.setVisibility(View.VISIBLE);

     return row;
    }
}
