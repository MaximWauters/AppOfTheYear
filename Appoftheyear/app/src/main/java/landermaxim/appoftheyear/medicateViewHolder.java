package landermaxim.appoftheyear;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Lander on 30/12/2017.
 */

public class medicateViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    View mview;

    public medicateViewHolder(View itemview) {
        super(itemview);
        itemview.setOnClickListener(this);
        mview = itemview;
    }

    public void setData(String naam, String tijd,String note){

        TextView textViewnaam = (TextView) mview.findViewById(R.id.textViewnaam);
        TextView textViewtijd = (TextView) mview.findViewById(R.id.textViewtijd);
        TextView textViewnote = (TextView) mview.findViewById(R.id.textViewnote);

        textViewnaam.setText(naam);
        textViewtijd.setText(tijd);
        textViewnote.setText(note);
    }
<<<<<<< Updated upstream

    @Override
    public void onClick(View v) {
        int pos = getAdapterPosition();


    }
=======
>>>>>>> Stashed changes
}
