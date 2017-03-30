package hemantgtx950.com.ui_practice.Utility;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by hemba on 3/18/2017.
 */

public class Util {
    public static void toastS(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
}
