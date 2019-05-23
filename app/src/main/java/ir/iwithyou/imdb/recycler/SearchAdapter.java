package ir.iwithyou.imdb.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ir.iwithyou.imdb.R;
import ir.iwithyou.imdb.pojo.searchName.Search;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {
    List<Search> searchList;

    public SearchAdapter(List<Search> searchList, Context mContext) {
        this.searchList = searchList;
        this.mContext = mContext;
    }

    Context mContext;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View aView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new MyViewHolder(aView);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Search aSearch = searchList.get(i);
        myViewHolder.aPoster.setImageResource(aSearch.getPoster());
        myViewHolder.aYear.setText(aSearch.getYear());
        myViewHolder.aIMDB.setText(aSearch.getImdbID());

    }

    @Override
    public int getItemCount() {
        return searchList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView aPoster;
        public TextView aTitle;
        public TextView aYear;
        public TextView aIMDB;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            aPoster = itemView.findViewById(R.id.i_Poster);
            aTitle = itemView.findViewById(R.id.i_tv_Title);
            aIMDB = itemView.findViewById(R.id.i_tv_IMDB);
            aYear = itemView.findViewById(R.id.i_tv_Year);

        }
    }


}
