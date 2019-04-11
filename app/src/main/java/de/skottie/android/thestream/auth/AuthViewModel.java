package de.skottie.android.thestream.auth;


import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class AuthViewModel extends ViewModel {

    private final FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    private CollectionReference colRef;

    @NonNull
    public LiveData<User> getAuthLiveData() {
        colRef = firestore.collection("users");
        return new AuthLiveData(colRef);
    }
}
