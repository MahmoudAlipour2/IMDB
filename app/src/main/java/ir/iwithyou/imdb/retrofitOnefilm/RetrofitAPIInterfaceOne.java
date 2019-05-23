package ir.iwithyou.imdb.retrofitOnefilm;

import ir.iwithyou.imdb.pojo.searchID.Searchbyid;
import ir.iwithyou.imdb.pojo.searchName.SearchName;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitAPIInterfaceOne {

    @GET("/")
    Call<Searchbyid> searchIDCall(@Query("i") String IMDBID, @Query("apikey") String apiKey);


}
