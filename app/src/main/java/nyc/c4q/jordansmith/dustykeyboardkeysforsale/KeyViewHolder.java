package nyc.c4q.jordansmith.dustykeyboardkeysforsale;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by jordansmith on 1/11/17.
 */

public class KeyViewHolder extends RecyclerView.ViewHolder {
    TextView keyTextView;

    public KeyViewHolder(View itemView) {
        super(itemView);
        keyTextView = (TextView) itemView.findViewById(R.id.key_text_view);

    }
}
