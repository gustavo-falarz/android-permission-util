//TODO Add the package

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import java.util.*

/**
 * Created by Gustavo on 11/20/2017.
 * Converted to kotlin by Polotto
 * Source: https://github.com/gustavo-falarz/android-permission-util/blob/master/PermissionUtils.java
 */

@Suppress("unused")
class PermissionUtils {

    internal object Constants {
        const val PERMISSIONS_REQUEST_READ_LOCATION = 1
        const val PERMISSIONS_REQUEST_CAMERA = 2
        const val PERMISSIONS_REQUEST_STORAGE = 3
        const val PERMISSIONS_REQUEST_IDENTIFIER = 4
        const val PERMISSIONS_REQUEST_PHONE_CALL = 5
    }

    companion object {

        fun requestCameraPermission(activity: Activity) {
            val permissions = arrayOf(Manifest.permission.CAMERA)
            Permissions.requestPermission(activity, Constants.PERMISSIONS_REQUEST_CAMERA, *permissions)
        }

        fun checkCameraPermission(activity: Activity): Boolean {
            val permissions = arrayOf(Manifest.permission.CAMERA)
            return permissionGranted(activity, *permissions)
        }

        fun requestCameraStoragePermission(activity: Activity) {
            val permissions = arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            Permissions.requestPermission(activity, Constants.PERMISSIONS_REQUEST_CAMERA, *permissions)
        }

        fun checkCameraStoragePermission(activity: Activity): Boolean {
            val permissions = arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            return permissionGranted(activity, *permissions)
        }

        fun requestStoragePermission(activity: Activity) {
            val permissions = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            Permissions.requestPermission(activity, Constants.PERMISSIONS_REQUEST_STORAGE, *permissions)
        }

        fun checkStoragePermission(activity: Activity): Boolean {
            val permissions = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            return permissionGranted(activity, *permissions)
        }

        fun requestIdentifierPermission(activity: Activity) {
            val permissions = arrayOf(Manifest.permission.READ_PHONE_STATE)
            Permissions.requestPermission(activity, Constants.PERMISSIONS_REQUEST_IDENTIFIER, *permissions)
        }

        fun checkIdentifierPermission(activity: Activity): Boolean {
            val permissions = arrayOf(Manifest.permission.READ_PHONE_STATE)
            return permissionGranted(activity, *permissions)
        }

        fun requestPhoneCallPermission(activity: Activity) {
            val permissions = arrayOf(Manifest.permission.CALL_PHONE)
            Permissions.requestPermission(activity, Constants.PERMISSIONS_REQUEST_PHONE_CALL, *permissions)
        }

        fun checkPhoneCallPermission(activity: Activity): Boolean {
            val permissions = arrayOf(Manifest.permission.CALL_PHONE)
            return permissionGranted(activity, *permissions)
        }

        fun requestLocationPermission(activity: Activity) {
            val permissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
            Permissions.requestPermission(activity, Constants.PERMISSIONS_REQUEST_READ_LOCATION, *permissions)
        }

        fun checkLocationPermission(activity: Activity): Boolean {
            val permissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
            return permissionGranted(activity, *permissions)
        }

        @Suppress("MemberVisibilityCanBePrivate")
        fun requestPermission(activity: Activity, requestCode: Int, vararg permissions: String) {
            val list = ArrayList<String>()
            for (permission in permissions) {
                val ok = ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED
                if (!ok) {
                    list.add(permission)
                }
            }
            if (list.isEmpty()) {
                return
            }

            val newPermissions = arrayOfNulls<String>(list.size)

            ActivityCompat.requestPermissions(activity, list.toArray(newPermissions), requestCode)
        }

        @Suppress("MemberVisibilityCanBePrivate")
        fun permissionGranted(activity: Activity, vararg permissions: String): Boolean {
            val list = ArrayList<String>()
            for (permission in permissions) {
                val granted =
                    ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED
                if (!granted) {
                    list.add(permission)
                }
            }
            return list.isEmpty()
        }
    }
}