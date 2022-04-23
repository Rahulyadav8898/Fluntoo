package com.fluntoo.zenberry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.loader.content.CursorLoader;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.icu.text.StringSearch;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

import com.fluntoo.zenberry.Model.Contact;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import retrofit2.http.Url;

public class TestContact extends AppCompatActivity {

//    private static final String TAG = "tag";
//    ArrayList<Contact> arrayList;
//    String phnumber, phname;
//    String phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_contact);

//        checkPermission();
//        checkPermissionforSMS();
//        checkPermissionforCalllogs();

    }

//    private void checkPermissionforCalllogs() {
//        if (ContextCompat.checkSelfPermission(getApplicationContext(),
//                Manifest.permission.READ_CALL_LOG)
//                != PackageManager.PERMISSION_GRANTED) {
//
//            ActivityCompat.requestPermissions(TestContact.this,
//                    new String[]{Manifest.permission.READ_CALL_LOG}, 102);
//
//        } else {
//            getCallDetails();
//        }
//
//    }
//
//
//    private void checkPermission() {
//        if (ContextCompat.checkSelfPermission(getApplicationContext(),
//                Manifest.permission.READ_CONTACTS)
//                != PackageManager.PERMISSION_GRANTED) {
//
//            ActivityCompat.requestPermissions(TestContact.this,
//                    new String[]{Manifest.permission.READ_CONTACTS}, 100);
//
//        } else {
//            getContactList();
//        }
//
//    }
//
//    public List<String> getSMS() {
//        List<String> sms = new ArrayList<String>();
//        Uri uriSMSURI = Uri.parse("content://sms/inbox");
//        Cursor cur = getContentResolver().query(uriSMSURI, null, null, null, null);
//
//        while (cur.moveToNext()) {
//            String address = cur.getString(cur.getColumnIndex("address"));
//            String body = cur.getString(cur.getColumnIndexOrThrow("body"));
//            sms.add("Number: " + address + " .Message: " + body);
//            Log.i("sms", sms.toString());
////            Toast.makeText(getApplicationContext(), sms.toString(), Toast.LENGTH_SHORT).show();
//
//        }
//        return sms;
//
//    }
//
//    private String getCallDetails() {
//
//        StringBuffer sb = new StringBuffer();
//        Cursor managedCursor = managedQuery(CallLog.Calls.CONTENT_URI, null,
//                null, null, null);
//        int number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);
//        int type = managedCursor.getColumnIndex(CallLog.Calls.TYPE);
//        int date = managedCursor.getColumnIndex(CallLog.Calls.DATE);
//        int duration = managedCursor.getColumnIndex(CallLog.Calls.DURATION);
//        sb.append("Call Details :");
//        while (managedCursor.moveToNext()) {
//            String phNumber = managedCursor.getString(number);
//            String callType = managedCursor.getString(type);
//            String callDate = managedCursor.getString(date);
//            Date callDayTime = new Date(Long.valueOf(callDate));
//            String callDuration = managedCursor.getString(duration);
//            String dir = null;
//            int dircode = Integer.parseInt(callType);
//            switch (dircode) {
//                case CallLog.Calls.OUTGOING_TYPE:
//                    dir = "OUTGOING";
//                    break;
//
//                case CallLog.Calls.INCOMING_TYPE:
//                    dir = "INCOMING";
//                    break;
//
//                case CallLog.Calls.MISSED_TYPE:
//                    dir = "MISSED";
//                    break;
//            }
//            sb.append("\nPhone Number:--- " + phNumber + " \nCall Type:--- "
//                    + dir + " \nCall Date:--- " + callDayTime
//                    + " \nCall duration in sec :--- " + callDuration);
////            sb.append("\n----------------------------------");
//            Log.i("call", sb.toString());
//            Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_SHORT).show();
//
//        }
//        managedCursor.close();
//        return sb.toString();
//
//    }
//
//    private void checkPermissionforSMS() {
//        if (ContextCompat.checkSelfPermission(getApplicationContext(),
//                Manifest.permission.READ_SMS)
//                != PackageManager.PERMISSION_GRANTED) {
//
//            ActivityCompat.requestPermissions(TestContact.this,
//                    new String[]{Manifest.permission.READ_SMS}, 101);
//
//        } else {
//            getSMS();
//        }
//
//
//    }
//
//
//    private void getContactList() {
//        ContentResolver cr = getContentResolver();
//        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
//                null, null, null, null);
//
//        if ((cur != null ? cur.getCount() : 0) > 0) {
//            while (cur != null && cur.moveToNext()) {
//                String id = cur.getString(
//                        cur.getColumnIndex(ContactsContract.Contacts._ID));
//                String name = cur.getString(cur.getColumnIndex(
//                        ContactsContract.Contacts.DISPLAY_NAME));
//
//                if (cur.getInt(cur.getColumnIndex(
//                        ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
//                    Cursor pCur = cr.query(
//                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
//                            null,
//                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
//                            new String[]{id}, null);
//                    while (pCur.moveToNext()) {
//                        phoneNo = pCur.getString(pCur.getColumnIndex(
//                                ContactsContract.CommonDataKinds.Phone.NUMBER));
//                        Log.i(TAG, "Name: " + name);
//                        Log.i(TAG, "Phone Number: " + phoneNo);
//
//
////                        Toast.makeText(getApplicationContext(), name+ " : "+phoneNo, Toast.LENGTH_SHORT).show();
//                    }
//                    pCur.close();
//                }
//
//            }
//        }
//        if (cur != null) {
//            cur.close();
//        }
//
//
//    }
//
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
//                                           @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        if (requestCode == 100 && grantResults.length > 0 && grantResults[0]
//                == PackageManager.PERMISSION_GRANTED) {
//            getContactList();
//        } else {
//            Toast.makeText(getApplicationContext(), "  phone no. permission denied", Toast.LENGTH_SHORT).show();
//        }
//        if (requestCode == 101 && grantResults.length > 0 && grantResults[0]
//                == PackageManager.PERMISSION_GRANTED) {
//            getSMS();
//        } else {
//            Toast.makeText(getApplicationContext(), " SMS permission denied", Toast.LENGTH_SHORT).show();
//        }
//        if (requestCode == 102 && grantResults.length > 0 && grantResults[0]
//                == PackageManager.PERMISSION_GRANTED) {
//            getCallDetails();
//        } else {
//            Toast.makeText(getApplicationContext(), " CAllLOgs permission denied", Toast.LENGTH_SHORT).show();
//        }
//
//
//    }
}
