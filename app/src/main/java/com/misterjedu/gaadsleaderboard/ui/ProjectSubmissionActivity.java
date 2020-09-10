package com.misterjedu.gaadsleaderboard.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.misterjedu.gaadsleaderboard.R;
import com.misterjedu.gaadsleaderboard.ui.dialog.ConfirmDialog;

public class ProjectSubmissionActivity extends AppCompatActivity {

    ConfirmDialog confirmDialog;
    Button submitProjectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_submission);

        //Press Back Arrow button to move to the Leaderboard Activity
        View back_button = findViewById(R.id.submission_activity_back_button);
        back_button.setOnClickListener(view -> finish());

        //Submit Project Button
        submitProjectButton = findViewById(R.id.project_submission_button);
        submitProjectButton.setOnClickListener(view -> openDialog());

    }

    private void closeDialog() {
        confirmDialog.dismiss();
    }

    private void openDialog() {
        confirmDialog = new ConfirmDialog();
        confirmDialog.show(getSupportFragmentManager(), "Confirm Dialog");
    }


}