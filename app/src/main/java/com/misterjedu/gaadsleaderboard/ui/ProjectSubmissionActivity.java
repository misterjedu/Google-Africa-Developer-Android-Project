package com.misterjedu.gaadsleaderboard.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.misterjedu.gaadsleaderboard.R;
import com.misterjedu.gaadsleaderboard.requests.LeaderboardApi;
import com.misterjedu.gaadsleaderboard.requests.ServiceGenerator;
import com.misterjedu.gaadsleaderboard.ui.dialog.ConfirmDialog;
import com.misterjedu.gaadsleaderboard.ui.dialog.ResponseDialog;
import com.misterjedu.gaadsleaderboard.utils.Constants;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectSubmissionActivity extends AppCompatActivity implements ConfirmDialog.ConfirmDialogListener {

    ConfirmDialog confirmDialog;
    ResponseDialog responseDialog;
    Button submitProjectButton;
    EditText firstName;
    EditText lastName;
    EditText emailAddress;
    EditText gitHubLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_submission);

        //Set Base URL
        Constants.setBaseURL("docurl");

        //Press Back Arrow button to move to the Leaderboard Activity
        View back_button = findViewById(R.id.submission_activity_back_button);
        back_button.setOnClickListener(view -> finish());

        //Submit Project Button
        submitProjectButton = findViewById(R.id.project_submission_button);
        submitProjectButton.setOnClickListener(view -> openDialog());

    }

    private void openResponseDialog(String response) {
        //Open the Confirm Dialog Box
        if (response.equals("Success")) {
            responseDialog = new ResponseDialog("Yes");
        } else {
            responseDialog = new ResponseDialog("No");
        }
        responseDialog.show(getSupportFragmentManager(), "Confirm Dialog");
    }

    private void openDialog() {

        //Get the user input views
        firstName = findViewById(R.id.submission_first_name);
        lastName = findViewById(R.id.submission_last_name);
        emailAddress = findViewById(R.id.submission_email_address);
        gitHubLink = findViewById(R.id.submission_github_link);

        //Open the Confirm Dialog Box
        confirmDialog = new ConfirmDialog();
        confirmDialog.show(getSupportFragmentManager(), "Confirm Dialog");
    }

    public void submitProject() {
        LeaderboardApi leaderboardApi = ServiceGenerator.getLeaderboardApi();
        Log.i("Posted",  gitHubLink.getText().toString());
        Call<Void> responseCall = leaderboardApi.sendEntry(
                emailAddress.getText().toString(),
                firstName.getText().toString(),
                lastName.getText().toString(),
                gitHubLink.getText().toString()
        );

        responseCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code() == 200) {
                    Log.i("Success", String.valueOf(response.code()));
                    openResponseDialog("Success");
                } else {
                    try {
                        openResponseDialog("Failure");
                        Log.i("Not 200", response.errorBody().string());
                        Log.i("Not 200", String.valueOf(response.code()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                openResponseDialog("Failed");
            }
        });
    }

    //Implement onDialogClick method.
    @Override
    public void onDialogClick(String response) {
        if (response.equals("Yes")) {
            submitProject();
        } else {
            Log.i("Confirm Submit", "Response is not Yes");
        }

    }
}