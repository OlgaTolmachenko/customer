package com.mobidev.taskcompany.util;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import com.mobidev.taskcompany.activity.EditProfileActivity;
import com.mobidev.taskcompany.activity.MainActivity;
=======
import com.mobidev.taskcompany.activity.SignInActivity;
=======
>>>>>>> 64f37b7... Add progressBars

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
=======
import com.mobidev.taskcompany.activity.EditProfileActivity;
import com.mobidev.taskcompany.activity.MainActivity;
>>>>>>> 3497b4d... refactoring

<<<<<<< HEAD
/**
 * Created by olga on 06.01.17.
 */
>>>>>>> d184d09... Task creation and DB saving added

=======
>>>>>>> 12b3da3... refactoring 2.0
public class UserAuth {

    private FirebaseAuth auth;
    private Activity context;

    public UserAuth(Activity context) {
        this.context = context;
        auth = FirebaseAuth.getInstance();
    }

    public void signUp(String email, String password) {
<<<<<<< HEAD
<<<<<<< HEAD
        if (!hasEmailAndPassword(email, password)) { return; }
=======
>>>>>>> 330f4ea... map ready
=======
        if (!hasEmailAndPassword(email, password)) { return; }
>>>>>>> 26ccd18... Back button action added. Sending logo to firebase
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(context, getCompleteListener(EditProfileActivity.class));
    }

    public void signIn(String email, String password) {
<<<<<<< HEAD
<<<<<<< HEAD
        if (!hasEmailAndPassword(email, password)) { return; }
=======
>>>>>>> 330f4ea... map ready
=======
        if (!hasEmailAndPassword(email, password)) { return; }
>>>>>>> 26ccd18... Back button action added. Sending logo to firebase
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(context, getCompleteListener(MainActivity.class));
    }

    private void showFailureToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    private OnCompleteListener<AuthResult> getCompleteListener(final Class activity) {
        return new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (!task.isSuccessful() && task.getException() != null) {
                    showFailureToast(task.getException().getMessage());
                } else {
                    context.startActivity(new Intent(context, activity));
                }
            }
        };
    }

    private boolean hasEmailAndPassword(String email, String password) {
        return !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password);
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======

    public void logout() {
        FirebaseAuth.getInstance().signOut();
        context.startActivity(new Intent(context, SignInActivity.class).setFlags(FLAG_ACTIVITY_CLEAR_TASK|FLAG_ACTIVITY_NEW_TASK));
    }
>>>>>>> d184d09... Task creation and DB saving added
=======
>>>>>>> 64f37b7... Add progressBars
}
