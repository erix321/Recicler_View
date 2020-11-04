package com.example.recicler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.ListItemClick{

    private RecyclerView listaRecorridos;
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaRecorridos=findViewById(R.id.recorridos);
        listaRecorridos.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        LinearLayoutManager linearManager = new LinearLayoutManager(this);
        listaRecorridos.setLayoutManager(linearManager);

        int numElements=20;

        RecyclerAdapter mAdapter = new RecyclerAdapter(numElements,this);
        listaRecorridos.setAdapter(mAdapter);

    }

    @Override
    public void onListItemClick(int clickedItem) {

        if(mToast!=null){
            mToast.cancel();
        }

        String msjToast="Recorrido #"+(clickedItem+1)+" Seleccionado";
        mToast=Toast.makeText(this,msjToast,Toast.LENGTH_SHORT);
        mToast.show();

    }
}
