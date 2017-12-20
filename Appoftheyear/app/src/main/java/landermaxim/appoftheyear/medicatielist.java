package landermaxim.appoftheyear;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Lander on 20/12/2017.
 */

public class medicatielist extends ArrayAdapter<Medicate> {

    private Activity context;
    private List<Medicate> medilist;

    public medicatielist(Activity context, List<Medicate> medilist){
        super(context, R.layout.list_layout, medilist);
        this.context = context;
        this.medilist = medilist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View ListViewItem = inflater.inflate(R.layout.list_layout,null,true);

        TextView textViewnaam = (TextView) ListViewItem.findViewById(R.id.textViewnaam);
        TextView textViewtijd = (TextView) ListViewItem.findViewById(R.id.textViewtijd);
        TextView textViewnote = (TextView) ListViewItem.findViewById(R.id.textViewnote);

        Medicate medicate = medilist.get(position);

        textViewnaam.setText(medicate.getNaam());
        textViewtijd.setText(medicate.getTijd());
        textViewnote.setText(medicate.getNote());

        return ListViewItem;
    }
}
