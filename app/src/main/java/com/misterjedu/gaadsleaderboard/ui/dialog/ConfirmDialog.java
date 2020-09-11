package com.misterjedu.gaadsleaderboard.ui.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.misterjedu.gaadsleaderboard.R;
import com.misterjedu.gaadsleaderboard.ui.ProjectSubmissionActivity;

public class ConfirmDialog extends AppCompatDialogFragment {

    Button yesButton;
    CardView closeDialog;
    ResponseDialog responseDialog;
    private ConfirmDialogListener confirmDialogListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        //Create an Alert Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        //Inflate the Dialog view
        View view = inflater.inflate(R.layout.confirm_submit_dialog, null);

        //find the Confirm and close Dialog Buttons
        yesButton = view.findViewById(R.id.confirm_dialog_yes_button);
        closeDialog =view.findViewById(R.id.confirm_dialog_close);

        //Set On Click Listerners
        closeDialog.setOnClickListener(v -> dismissDialog());
        yesButton.setOnClickListener(v -> openResponseDialog());

        //Set the Dialog View
         builder.setView(view);
         return builder.create();
    }

    //Open the response dialog and dismiss the confirm dialog
    private void openResponseDialog() {
        getDialog().dismiss();
        //
        confirmDialogListener.onDialogClick("Yes");
    }

    //Dismiss the Dialog on Button Click
    private void dismissDialog() {
        getDialog().dismiss();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            confirmDialogListener = (ConfirmDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
            + " must implement ConfirmDialog Listener"
            );
        }

    }

    //Confirm Dialog Listener Interface to speak with
     public interface ConfirmDialogListener {
        void onDialogClick(String response);
     }
}
