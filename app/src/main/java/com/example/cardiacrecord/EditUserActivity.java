package com.example.cardiacrecord;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Activity for editing or adding a user record.
 */
public class EditUserActivity extends AppCompatActivity {

    private Button updateUserBtn, deleteUserBtn;
    private TextInputEditText userNameEdt, cmnt, systolic, diastolic, heart;
    private DatabaseReference databaseReference;
    private ProgressBar loadingPB;
    private String userID;
    private UserRVModal userRVModal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");

        updateUserBtn = findViewById(R.id.idBtnUpdate);
        deleteUserBtn = findViewById(R.id.idBtnDelete);
        userNameEdt = findViewById(R.id.idName);
        cmnt = findViewById(R.id.idComment);
        systolic = findViewById(R.id.idsPressure);
        diastolic = findViewById(R.id.idDPressure);
        heart = findViewById(R.id.idHeart);
        loadingPB = findViewById(R.id.idPBLoading);

        userRVModal = getIntent().getParcelableExtra("user");
        if (userRVModal != null) {
            userNameEdt.setText(userRVModal.getUserName());
            cmnt.setText(userRVModal.getUserDesc());
            heart.setText(userRVModal.getUserheart());
            diastolic.setText(userRVModal.getUserdio());
            systolic.setText(userRVModal.getUsersys());
            userID = userRVModal.getUserId();
        } else {
            // Handle the case when adding a new user
            userID = databaseReference.push().getKey();
            updateUserBtn.setText("     Add      ");
            deleteUserBtn.setVisibility(View.GONE);
        }

        updateUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUser();
            }
        });

        deleteUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteUser();
            }
        });
    }

    /**
     * Updates the user record in the Firebase database.
     */
    private void updateUser() {
        loadingPB.setVisibility(View.VISIBLE);

        String userName = userNameEdt.getText().toString();
        String userDesc = cmnt.getText().toString();
        String usersys = systolic.getText().toString();
        String userdio = diastolic.getText().toString();
        String userheart = heart.getText().toString();
        String userdate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
        String usertime = new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date());

        if (!validateInput(userName, userDesc, usersys, userdio, userheart)) {
            loadingPB.setVisibility(View.GONE);
            return;
        }

        Map<String, Object> map = new HashMap<>();
        map.put("userName", userName);
        map.put("userDesc", userDesc);
        map.put("usersys", usersys);
        map.put("userdio", userdio);
        map.put("userheart", userheart);
        map.put("userId", userID);
        map.put("userdate", userdate);
        map.put("usertime", usertime);

        databaseReference.child(userID).setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        loadingPB.setVisibility(View.GONE);
                        Toast.makeText(EditUserActivity.this, "Updated...", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(EditUserActivity.this, MainActivity.class));
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        loadingPB.setVisibility(View.GONE);
                        Toast.makeText(EditUserActivity.this, "Failed to update...", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    /**
     * Deletes the user record from the Firebase database.
     */
    private void deleteUser() {
        loadingPB.setVisibility(View.VISIBLE);

        databaseReference.child(userID).removeValue()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        loadingPB.setVisibility(View.GONE);
                        Toast.makeText(EditUserActivity.this, "Deleted...", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(EditUserActivity.this, MainActivity.class));
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        loadingPB.setVisibility(View.GONE);
                        Toast.makeText(EditUserActivity.this, "Failed to delete...", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    /**
     * Validates the user input for the user record.
     *
     * @param userName   The user name.
     * @param userDesc   The user description.
     * @param usersys    The systolic pressure value.
     * @param userdio    The diastolic pressure value.
     * @param userheart  The heart rate value.
     * @return True if the input is valid, false otherwise.
     */
    private boolean validateInput(String userName, String userDesc, String usersys, String userdio, String userheart) {
        if (userName.trim().isEmpty()) {
            userNameEdt.setError("Please enter a name");
            return false;
        }

        if (usersys.trim().isEmpty()) {
            systolic.setError("Please enter the systolic pressure");
            return false;
        }

        if (userdio.trim().isEmpty()) {
            diastolic.setError("Please enter the diastolic pressure");
            return false;
        }

        if (userheart.trim().isEmpty()) {
            heart.setError("Please enter the heart rate");
            return false;
        }

        int sysPressure;
        try {
            sysPressure = Integer.parseInt(usersys);
        } catch (NumberFormatException e) {
            systolic.setError("Invalid systolic pressure");
            return false;
        }

        int diaPressure;
        try {
            diaPressure = Integer.parseInt(userdio);
        } catch (NumberFormatException e) {
            diastolic.setError("Invalid diastolic pressure");
            return false;
        }

        int heartRate;
        try {
            heartRate = Integer.parseInt(userheart);
        } catch (NumberFormatException e) {
            heart.setError("Invalid heart rate");
            return false;
        }

        if (sysPressure < 0 || sysPressure > 500) {
            systolic.setError("Please enter a systolic pressure between 0 and 500");
            return false;
        }

        if (diaPressure < 0 || diaPressure > 500) {
            diastolic.setError("Please enter a diastolic pressure between 0 and 500");
            return false;
        }

        if (heartRate < 0 || heartRate > 500) {
            heart.setError("Please enter a heart rate between 0 and 500");
            return false;
        }

        return true;
    }
}
