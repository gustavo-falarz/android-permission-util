package br.gov.caixa.sifec.utils;

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


    public static boolean requestCameraPermission(Activity activity) {
        String[] permissoes = new String[]{
                Manifest.permission.CAMERA
        };
        return PermissionUtils.validate(activity, Constants.PERMISSIONS_REQUEST_CAMERA, permissoes);
    }

    public static boolean checkCameraPermission(Activity activity) {
        String[] permissoes = new String[]{
                Manifest.permission.CAMERA
        };
        return permissionGranted(activity, permissoes);
    }

    public static boolean requestCameraStoragePermission(Activity activity) {
        String[] permissoes = new String[]{
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        return PermissionUtils.validate(activity, Constants.PERMISSIONS_REQUEST_CAMERA, permissoes);
    }

    public static boolean checkCameraStoragePermission(Activity activity) {
        String[] permissoes = new String[]{
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        return permissionGranted(activity, permissoes);
    }
    public static boolean requestStoragePermission(Activity activity) {
        String[] permissoes = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        return PermissionUtils.validate(activity, Constants.PERMISSIONS_REQUEST_STORAGE, permissoes);
    }

    public static boolean checkStoragePermission(Activity activity) {
        String[] permissoes = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        return permissionGranted(activity, permissoes);
    }

    public static boolean requestIdentifierPermission(Activity activity) {
        String[] permissoes = new String[]{
                Manifest.permission.READ_PHONE_STATE,
        };
        return PermissionUtils.validate(activity, Constants.PERMISSIONS_REQUEST_IDENTIFIER, permissoes);
    }

    public static boolean requestPhoneCallPermission(Activity activity) {
        String[] permissoes = new String[]{
                Manifest.permission.CALL_PHONE,
        };
        return PermissionUtils.validate(activity, Constants.PERMISSIONS_REQUEST_PHONE_CALL , permissoes);
    }

    public static boolean checkPhoneCallPermission(Activity activity) {
        String[] permissoes = new String[]{
                Manifest.permission.CALL_PHONE
        };
        return permissionGranted(activity, permissoes);
    }

    public static boolean checkIdentifierAndStoragePermission(Activity activity) {
        String[] permissoes = new String[]{
                Manifest.permission.READ_PHONE_STATE,
        };
        return permissionGranted(activity, permissoes);
    }

    public static boolean requestLocationPermission(Activity activity) {
        String[] permissoes = new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION
        };
        return PermissionUtils.validate(activity, Constants.PERMISSIONS_REQUEST_READ_LOCATION, permissoes);
    }

    public static boolean checkLocationPermission(Activity activity) {
        String[] permissoes = new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION
        };
        return permissionGranted(activity, permissoes);
    }


    public static boolean validate(Activity activity, int requestCode, String... permissions) {
        List<String> list = new ArrayList<>();
        for (String permission : permissions) {
            boolean ok = ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED;
            if (!ok) {
                list.add(permission);
            }
        }
        if (list.isEmpty()) {
            return true;
        }

        String[] newPermissions = new String[list.size()];
        list.toArray(newPermissions);

        ActivityCompat.requestPermissions(activity, newPermissions, requestCode);

        return false;
    }

    public static boolean permissionGranted(Activity activity, String... permissions) {
        List<String> list = new ArrayList<>();
        for (String permission : permissions) {
            boolean ok = ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED;
            if (!ok) {
                list.add(permission);
            }
        }
        if (list.isEmpty()) {
            return true;
        }
        return false;
    }
}
