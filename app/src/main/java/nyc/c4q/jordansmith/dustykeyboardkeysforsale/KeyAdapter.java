package nyc.c4q.jordansmith.dustykeyboardkeysforsale;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.jordansmith.dustykeyboardkeysforsale.Model.AvailableKey;

/**
 * Created by jordansmith on 1/11/17.
 */

public class KeyAdapter extends RecyclerView.Adapter<KeyViewHolder> {
    List<AvailableKey> keysList;

    KeyAdapter(List<AvailableKey> keysList){
        this.keysList = keysList;
    }

    @Override
    public KeyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);

        return new KeyViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(final KeyViewHolder holder, final int position) {
       String keyName = keysList.get(position).getName();
        holder.keyTextView.setTextColor(Color.parseColor(keysList.get(position).getTextColor()));
        holder.keyTextView.setText(keyName);
        holder.keyTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.keyTextView.getContext(),PictureDisplay.class);
                intent.putExtra("Image Url",keysList.get(position).getUrl());
                holder.keyTextView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return keysList.size();
    }

}
