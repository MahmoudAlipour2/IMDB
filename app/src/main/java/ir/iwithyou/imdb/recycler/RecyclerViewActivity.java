package ir.iwithyou.imdb.recycler;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import ir.iwithyou.imdb.R;
import ir.iwithyou.imdb.pojo.searchName.Search;
import ir.iwithyou.imdb.pojo.searchName.SearchName;
import ir.iwithyou.imdb.retrofit.RetrofitAPIInterface;
import ir.iwithyou.imdb.retrofit.RetrofitServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewActivity extends AppCompatActivity {

    Button btn;
    String MovieName;
    EditText editText;
    RecyclerView myRecycler;

    private SearchAdapter mySearchAdapter;
    private LinearLayoutManager linearLayoutManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);


        String MovieName = getIntent().getStringExtra("MovieName");


                RetrofitAPIInterface client = RetrofitServiceGenerator.createService(RetrofitAPIInterface.class);
                Call<SearchName> searchNameCall = client.searchNameCall(MovieName, "77d67210");
                searchNameCall.enqueue(new Callback<SearchName>() {
                    @Override
                    public void onResponse(Call<SearchName> call, Response<SearchName> response) {
                        List<Search> searchList = response.body().getSearch();
                        setupRecyclerView(searchList);


                    }

                    @Override
                    public void onFailure(Call<SearchName> call, Throwable t) {
                        Toast.makeText(RecyclerViewActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                    }
                });




            }



    private void setupRecyclerView(List<Search> searchList) {
        myRecycler = findViewById(R.id.rv_film);
        mySearchAdapter = new SearchAdapter(searchList, this);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        myRecycler.setAdapter(mySearchAdapter);
        myRecycler.setLayoutManager(linearLayoutManager);
        myRecycler.setItemAnimator(new DefaultItemAnimator());
    }
}
