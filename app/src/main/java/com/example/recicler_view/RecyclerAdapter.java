package com.example.recicler_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecorridosViewHolder>{

    private int numItems;
    final private ListItemClick mOnClickListener;

    public RecyclerAdapter(int numItems, ListItemClick listener){

        this.numItems=numItems;
        mOnClickListener=listener;

    }

    public interface ListItemClick{
        void onListItemClick(int clickedItem);
    }

    @NonNull
    @Override
    public RecorridosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context myContext = parent.getContext();
        int layout_id_ListItem=R.layout.lista_recorridos_item;
        LayoutInflater inflater = LayoutInflater.from(myContext);
        boolean attachToParent = false;

        View view = inflater.inflate(layout_id_ListItem,parent,attachToParent);

        RecorridosViewHolder viewHolder= new RecorridosViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecorridosViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return numItems;
    }

    class RecorridosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvListaRecorridosView;

        public RecorridosViewHolder(@NonNull View itemView) {
            super(itemView);
            tvListaRecorridosView=itemView.findViewById(R.id.tv_recorrido);
            itemView.setOnClickListener(this);
        }
        void bind (int indexList){
            tvListaRecorridosView.setText("Recorrido N° "+String.valueOf(indexList+1));
        }

        @Override
        public void onClick(View v) {
            int clickedItem=getAdapterPosition();
            mOnClickListener.onListItemClick(clickedItem);
        }
    }

}
