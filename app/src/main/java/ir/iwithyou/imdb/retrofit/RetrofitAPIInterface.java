package ir.iwithyou.imdb.retrofit;

import ir.iwithyou.imdb.pojo.searchName.SearchName;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitAPIInterface {


    @GET("/")
    Call<SearchName> searchNameCall(@Query("s") String movieName, @Query("apikey") String apiKey);

/*
    @GET("/")
    Call<Resultsearchbyid> MOVIE_CALL(@Query("i") String movieName, @Query("apikey") String apiKey);*/
}
