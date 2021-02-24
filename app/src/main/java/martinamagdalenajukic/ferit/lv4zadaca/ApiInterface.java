package martinamagdalenajukic.ferit.lv4zadaca;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("api/v1/products.json?")
    Call<List<Item>> getItem(@Query("brand") String brand);

}