package ir.iwithyou.imdb.recycler;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import ir.iwithyou.imdb.DescriptionActivity;
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
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {

        View aView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);

        aView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, DescriptionActivity.class);
                intent.putExtra("IMDBID", searchList.get(i).getImdbID());
                mContext.startActivity(intent);
            }
        });


        return new MyViewHolder(aView);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Search aSearch = searchList.get(i);
        Picasso.get().load(aSearch.getPoster()).into(myViewHolder.aPoster);
        myViewHolder.aTitle.setText(aSearch.getTitle());
        myViewHolder.aYear.setText(aSearch.getYear());
        // myViewHolder.aIMDB.setText(aSearch.getImdbID());

    }

    @Override
    public int getItemCount() {
        return searchList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView aPoster;
        public TextView aTitle;
        public TextView aYear;
        // public TextView aIMDB;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            aPoster = itemView.findViewById(R.id.i_Poster);
            aTitle = itemView.findViewById(R.id.i_tv_Title);
            //aIMDB = itemView.findViewById(R.id.i_tv_IMDB);
            aYear = itemView.findViewById(R.id.i_tv_Year);

        }
    }


}
