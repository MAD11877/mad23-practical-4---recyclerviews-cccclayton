package sg.edu.np.mad.week3t04;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public ImageView userimageView;
    public TextView name;
    public TextView description;
    ImageView userimageView2;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        userimageView = itemView.findViewById(R.id.userImage);
        name = itemView.findViewById(R.id.name);
        description = itemView.findViewById(R.id.description);
        userimageView2 = itemView.findViewById(R.id.userImage2);
    }
}
