package com.misterjedu.gaadsleaderboard.ui.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.misterjedu.gaadsleaderboard.R;

public class ResponseDialog extends AppCompatDialogFragment {

    String response;
    View view;

    public ResponseDialog(String response) {
        this.response = response;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        //Create an Alert Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        //Inflate the Dialog view
        if(response.equals("Yes")){
            view = inflater.inflate(R.layout.submission_successful_dialog, null);
        }else{
            view = inflater.inflate(R.layout.submission_not_successful_dialog, null);
        }

        //Set the Dialog View
        builder.setView(view);
        return builder.create();
    }
}
