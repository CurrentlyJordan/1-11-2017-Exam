package nyc.c4q.jordansmith.dustykeyboardkeysforsale;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.List;

import nyc.c4q.jordansmith.dustykeyboardkeysforsale.Model.AvailableKey;
import nyc.c4q.jordansmith.dustykeyboardkeysforsale.Model.ResponseFromJson;
import nyc.c4q.jordansmith.dustykeyboardkeysforsale.Service.KeysService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

/**
 * Created by jordansmith on 1/11/17.
 */
public class KeyListFragment extends Fragment {

    RecyclerView keyRecyclerview;
    List<AvailableKey> keyList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_activity, container, false);

        keyRecyclerview = (RecyclerView) view.findViewById(R.id.key_recyclerview);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        requestKeys();
    }

    private void requestKeys() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsjrobotics.nyc/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        KeysService keysService = retrofit.create(KeysService.class);
        Call<ResponseFromJson> httpRequest = keysService.getKeys();
        httpRequest.enqueue(new Callback<ResponseFromJson>() {
            @Override
            public void onResponse(Call<ResponseFromJson> call, Response<ResponseFromJson> response) {
                try {
                    if (response.isSuccessful()) {
                        keyList = response.body().getAvailableKeys();
                        KeyAdapter keyAdapter = new KeyAdapter(keyList);
                        keyRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
                        keyRecyclerview.setAdapter(keyAdapter);




                    } else {
                        Log.d(TAG, "Error" + response.errorBody().string());
                    }
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResponseFromJson> call, Throwable t) {
                Log.d("failure", "no connection");

            }
        });

    }
}
