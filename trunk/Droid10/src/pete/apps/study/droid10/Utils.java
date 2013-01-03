package pete.apps.study.droid10;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;


public class Utils {

	/** handle the required pre-installed app */
	public static boolean handleRequiredApp(Context context, PackageManager pm, String packageName)
	{
		Intent iApp = pm.getLaunchIntentForPackage(packageName);
		try {
			// this line will trigger exception if not found
			pm.getApplicationInfo(packageName, 0);
			return true;
		} catch (Exception ex) {
			// launch the market for installation
			launchMarket(context, packageName);
			return false;
		} 
	}

	/** launch market to certain app */
	public static void launchMarket(Context context, String packageName)
	{
		Uri uri = Uri.parse("market://details?id=" + packageName);
		Intent iDown = new Intent(Intent.ACTION_VIEW, uri);
		context.startActivity(iDown);
	}
}
