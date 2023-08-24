package com.example.jktvehicleapp.activity;

import static android.app.PendingIntent.getActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.jktvehicleapp.R;
import com.example.jktvehicleapp.databinding.ActivityProfileBinding;
import com.example.jktvehicleapp.utils.CustomPopup;
import com.example.jktvehicleapp.utils.PopUpInterface;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;

    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 101;
    private static final int pic_id = 123;
    private Bitmap bitmap = null;
    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_profile);


        initListener();

        initView();
    }

    private void initListener() {
        binding.btnEdit.setOnClickListener(n->{
            if (binding.relativeUpdate.getVisibility()==View.GONE){
                binding.relativeUpdate.setVisibility(View.VISIBLE);
                binding.relativeProfile.setVisibility(View.GONE);
            }
            else {
                binding.relativeUpdate.setVisibility(View.GONE);
                binding.relativeProfile.setVisibility(View.VISIBLE);
            }

        });

        binding.btnLogout.setOnClickListener(n->{
            CustomPopup.PopUp("Logout", "Log Out", "Do you want to exit?", "", "Yes", "No", this, new PopUpInterface() {
                @Override
                public void onPositiveBtnClick() {
                    Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onNegativeBtnClick() {

                }
            });
        });
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.imgProfile.setOnClickListener(v -> {

        });
        binding.imgProfileEdit.setOnClickListener(n->{
            OpenImagePicker();
        });
        binding.imgAadharEdit.setOnClickListener(n->{
            OpenImagePicker2();
        });
    }

    private void initView() {
    }


    private void OpenImagePicker() {
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        View view = LayoutInflater.from(this).inflate(R.layout.image_picker_view, null);
        dialog.setContentView(view);
        LinearLayout btcam, btgal;
        btcam = view.findViewById(R.id.btCam);
        btgal = view.findViewById(R.id.btGal);

        btcam.setOnClickListener(v -> {
            if (checkAndRequestPermissions(this)) {
             /*   Intent takePictureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                String fileName = "temp.jpg";
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.TITLE, fileName);
                imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(takePictureIntent, 100);
                dialog.dismiss();*/

                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // Start the activity with camera_intent, and request pic id
                startActivityForResult(camera_intent, pic_id);
            }
        });

        btgal.setOnClickListener(v -> {
            if (checkAndRequestPermissions(this)) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, 2);
                dialog.dismiss();
            }
        });
        dialog.show();


    }
    private void OpenImagePicker2() {
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        View view = LayoutInflater.from(this).inflate(R.layout.image_picker_view, null);
        dialog.setContentView(view);
        LinearLayout btcam, btgal;
        btcam = view.findViewById(R.id.btCam);
        btgal = view.findViewById(R.id.btGal);

        btcam.setOnClickListener(v -> {
            if (checkAndRequestPermissions(this)) {
             /*   Intent takePictureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                String fileName = "temp.jpg";
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.TITLE, fileName);
                imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(takePictureIntent, 100);
                dialog.dismiss();*/

                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // Start the activity with camera_intent, and request pic id
                startActivityForResult(camera_intent, 1);
            }
        });

        btgal.setOnClickListener(v -> {
            if (checkAndRequestPermissions(this)) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, 3);
                dialog.dismiss();
            }
        });
        dialog.show();


    }

    public static boolean checkAndRequestPermissions(final Activity context) {
        int cameraPermission = ContextCompat.checkSelfPermission(context,
                Manifest.permission.CAMERA);
        int StoragePermission = ContextCompat.checkSelfPermission(context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int StoragePermission2 = ContextCompat.checkSelfPermission(context,
                Manifest.permission.READ_EXTERNAL_STORAGE);

        List<String> listPermissionsNeeded = new ArrayList<>();
        listPermissionsNeeded.clear();

        if (cameraPermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CAMERA);
        }
        if (StoragePermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (StoragePermission2 != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(context, listPermissionsNeeded
                            .toArray(new String[listPermissionsNeeded.size()]),
                    REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
           /* Uri selectedImage = data.getData();
            String projection[] = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(imageUri, projection, null, null, null);
            int index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            File file = new File(cursor.getString(index));
            bitmap= BitmapFactory.decodeFile(file.getPath());*/
            //Glide.with(this).load(imageUri).into(binding.imgProfile);


            if (requestCode == pic_id) {
                // BitMap is data structure of image file which store the image in memory
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                // Set the image in imageview for display
                binding.imgProfileEdit.setImageBitmap(photo);
            }
        }
        if (requestCode == 2 && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            File file = new File(picturePath);
            bitmap = BitmapFactory.decodeFile(file.getPath());
            Glide.with(this).load(selectedImage).centerCrop().into(binding.imgProfileEdit);
        }

        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
           /* Uri selectedImage = data.getData();
            String projection[] = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(imageUri, projection, null, null, null);
            int index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            File file = new File(cursor.getString(index));
            bitmap= BitmapFactory.decodeFile(file.getPath());*/
            //Glide.with(this).load(imageUri).into(binding.imgProfile);


            if (requestCode == 1) {
                // BitMap is data structure of image file which store the image in memory
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                // Set the image in imageview for display
                binding.imgAadharEdit.setImageBitmap(photo);
            }
        }
        if (requestCode == 3 && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            File file = new File(picturePath);
            bitmap = BitmapFactory.decodeFile(file.getPath());
            Glide.with(this).load(selectedImage).centerCrop().into(binding.imgAadharEdit);
        }
    }

    public static String encodeToBase64(Bitmap image, Bitmap.CompressFormat compressFormat, int quality) {
        ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
        image.compress(compressFormat, quality, byteArrayOS);
        return Base64.encodeToString(byteArrayOS.toByteArray(), Base64.DEFAULT);
    }


}