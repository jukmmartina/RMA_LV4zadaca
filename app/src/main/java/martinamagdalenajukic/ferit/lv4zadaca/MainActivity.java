package martinamagdalenajukic.ferit.lv4zadaca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Item> itemList;
    private EditText etSearch;
    private Button btnSearch;
    private RecyclerAdapter adapter;
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSearch = findViewById(R.id.etSearch);
        btnSearch=findViewById(R.id.btnSearch);
        setUpRecyclerView();
        btnSearch.setOnClickListener(this);
    }

    private void setUpApiCall(String brand) {
        Call<List<Item>> apicall=NetworkUtils.getApiInterface().getItem(brand);
        apicall.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.isSuccessful()&&response.body()!=null){
                    Log.d("json", response.body().get(0).getBrand());
                   showItems(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                Log.d("error", t.getLocalizedMessage()) ;
            }
        });
    }

    private void showItems(List<Item> item) {
        adapter.setItemList(item);
    }

    private void setUpRecyclerView() {
        recycler=findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter=new RecyclerAdapter(itemList, this);
        recycler.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {
        String brand=etSearch.getText().toString();
        setUpApiCall(brand);
    }
}