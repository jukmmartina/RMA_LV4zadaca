package martinamagdalenajukic.ferit.lv4zadaca;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkUtils {
    private static final String BASE_URL="http://makeup-api.herokuapp.com/";
    private static  ApiInterface apiInterface;

    public static ApiInterface getApiInterface(){
        if (apiInterface==null){
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiInterface=retrofit.create(ApiInterface.class);
        }
        return apiInterface;
    }
}
