package com.weblite.jktvehicleapp.utils;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

import com.weblite.jktvehicleapp.R;
import com.weblite.jktvehicleapp.databinding.CustomPopupDialogBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class CustomPopup {

    public static void PopUp(String type, String title, String head, String desc, String posBtnText, String negBtnText, Activity activity, final PopUpInterface popUpInterface){

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                LayoutInflater layoutInflater = LayoutInflater.from(activity);
                CustomPopupDialogBinding binding = CustomPopupDialogBinding.inflate(layoutInflater);

                AlertDialog alertDialog = new MaterialAlertDialogBuilder(activity, R.style.MyRounded_MaterialComponents_MaterialAlertDialog)
                        .setView(binding.getRoot())
                        .show();

                alertDialog.setCancelable(false);

                binding.Title.setText(title);
                binding.Head.setText(head);
                binding.Desc.setText(desc);
                binding.PositiveBtn.setText(posBtnText);
                binding.NegativeBtn.setText(negBtnText);

                if (type.equals("Success")){
                    binding.animationView.setAnimation(R.raw.sucessfull);
                }else if (type.equals("Failed")){
                    binding.animationView.setAnimation(R.raw.failed);
                }
                else if (type.equals("Logout")){
                    binding.animationView.setAnimation(R.raw.door_logout);
                }
                else if (type.equals("Error")){
                    binding.animationView.setAnimation(R.raw.somthing_error);
                }


                binding.PositiveBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popUpInterface.onPositiveBtnClick();
                        alertDialog.dismiss();
                    }
                });

                binding.NegativeBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popUpInterface.onNegativeBtnClick();
                        alertDialog.dismiss();
                    }
                });

            }
        });
    }

}
