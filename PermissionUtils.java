//TODO Add the package

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gustavo on 11/20/2017.
 */

public class PermissionUtils {

    public static void requestCameraPermission(Activity activity) {
        String[] permissions = new String[]{
                Manifest.permission.CAMERA
        };
        PermissionUtils.requestPermission(activity, Constants.PERMISSIONS_REQUEST_CAMERA, permissions);
    }

    public static boolean checkCameraPermission(Activity activity) {
        String[] permissions = new String[]{
                Manifest.permission.CAMERA
        };
        return permissionGranted(activity, permissions);
    }

    public static void requestCameraStoragePermission(Activity activity) {
        String[] permissions = new String[]{
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        PermissionUtils.requestPermission(activity, Constants.PERMISSIONS_REQUEST_CAMERA, permissions);
    }

    public static boolean checkCameraStoragePermission(Activity activity) {
        String[] permissions = new String[]{
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        return permissionGranted(activity, permissions);
    }

    public static void requestStoragePermission(Activity activity) {
        String[] permissions = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        PermissionUtils.requestPermission(activity, Constants.PERMISSIONS_REQUEST_STORAGE, permissions);
    }

    public static boolean checkStoragePermission(Activity activity) {
        String[] permissions = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        return permissionGranted(activity, permissions);
    }

    public static void requestIdentifierPermission(Activity activity) {
        String[] permissions = new String[]{
                Manifest.permission.READ_PHONE_STATE,
        };
        PermissionUtils.requestPermission(activity, Constants.PERMISSIONS_REQUEST_IDENTIFIER, permissions);
    }

    public static boolean checkIdentifierPermission(Activity activity) {
        String[] permissions = new String[]{
                Manifest.permission.READ_PHONE_STATE
        };
        return permissionGranted(activity, permissions);
    }

    public static void requestPhoneCallPermission(Activity activity) {
        String[] permissions = new String[]{
                Manifest.permission.CALL_PHONE,
        };
        PermissionUtils.requestPermission(activity, Constants.PERMISSIONS_REQUEST_PHONE_CALL, permissions);
    }

    public static boolean checkPhoneCallPermission(Activity activity) {
        String[] permissions = new String[]{
                Manifest.permission.CALL_PHONE
        };
        return permissionGranted(activity, permissions);
    }

    public static void requestLocationPermission(Activity activity) {
        String[] permissions = new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION
        };
        PermissionUtils.requestPermission(activity, Constants.PERMISSIONS_REQUEST_READ_LOCATION, permissions);
    }

    public static boolean checkLocationPermission(Activity activity) {
        String[] permissions = new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION
        };
        return permissionGranted(activity, permissions);
    }

    public static void requestPermission(Activity activity, int requestCode, String... permissions) {
        List<String> list = new ArrayList<>();
        for (String permission : permissions) {
            boolean ok = ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED;
            if (!ok) {
                list.add(permission);
            }
        }
        if (list.isEmpty()) {
            return;
        }

        String[] newPermissions = new String[list.size()];
        list.toArray(newPermissions);

        ActivityCompat.requestPermissions(activity, newPermissions, requestCode);
    }

    public static boolean permissionGranted(Activity activity, String... permissions) {
        List<String> list = new ArrayList<>();
        for (String permission : permissions) {
            boolean granted = ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED;
            if (!granted) {
                list.add(permission);
            }
        }
        return list.isEmpty();
    }
}
