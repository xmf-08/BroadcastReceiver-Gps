package xmf.developer.broadcastreciever

import android.content.BroadcastReceiver
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.location.LocationRequest
import android.util.Log
import android.widget.Toast

private const val TAG = "MyReceiver"
class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.d(TAG, "onReceive: BroadCast ReceiverMy")

        if (LocationManager.PROVIDERS_CHANGED_ACTION.equals(intent.action)){
            val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            val isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
            val isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

            if (isGpsEnabled || isNetworkEnabled){
                Log.d(TAG, "onReceive: Gps yondi")
                Toast.makeText(context, "Gps yondi", Toast.LENGTH_SHORT).show()
            }else{
                Log.d(TAG, "onReceive: Gps o'chdi")
                Toast.makeText(context, "Gps o'chdi", Toast.LENGTH_SHORT).show()
            }
        }
    }
}