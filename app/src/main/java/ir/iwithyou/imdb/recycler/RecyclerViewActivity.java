package ir.iwithyou.imdb.recycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ir.iwithyou.imdb.R;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        btn = findViewById(R.id.btn_Net);
        editText = findViewById(R.id.et_Title);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MovieName = editText.getText().toString();

                RetrofitAPIInterface client = RetrofitServiceGenerator.createService(RetrofitAPIInterface.class);
                Call<SearchName> searchNameCall = client.searchNameCall(MovieName, "77d67210");
                searchNameCall.enqueue(new Callback<SearchName>() {
                    @Override
                    public void onResponse(Call<SearchName> call, Response<SearchName> response) {
                        Toast.makeText(RecyclerViewActivity.this, "OK", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<SearchName> call, Throwable t) {
                        Toast.makeText(RecyclerViewActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


    }
}
