package nyc.c4q.jordansmith.dustykeyboardkeysforsale.Service;

import nyc.c4q.jordansmith.dustykeyboardkeysforsale.Model.ResponseFromJson;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jordansmith on 1/11/17.
 */

public interface KeysService {

    @GET("cgi-bin/1_11_2017_exam.pl")
    Call<ResponseFromJson> getKeys();

}
