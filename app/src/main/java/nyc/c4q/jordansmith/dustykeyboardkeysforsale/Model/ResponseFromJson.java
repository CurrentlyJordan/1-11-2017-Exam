package nyc.c4q.jordansmith.dustykeyboardkeysforsale.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jordansmith on 1/11/17.
 */

public class ResponseFromJson {
    private boolean success;
    @SerializedName("available keys")
    @Expose
    private List<AvailableKey> availableKeys;


    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<AvailableKey> getAvailableKeys() {
        return availableKeys;
    }

    public void setAvailable_keys(List<AvailableKey> availableKeys) {
        this.availableKeys = availableKeys;
    }
}
