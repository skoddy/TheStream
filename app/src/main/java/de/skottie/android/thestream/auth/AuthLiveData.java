package de.skottie.android.thestream.auth;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

public class AuthLiveData extends MutableLiveData<User> implements FirebaseAuth.AuthStateListener {
    private final CollectionReference ref;
    private DocumentReference firebaseUser;
    AuthLiveData(CollectionReference ref) {
        this.ref = ref;
    }

    @Override
    protected void onActive() {
        super.onActive();
        FirebaseAuth.getInstance().addAuthStateListener(this);
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        FirebaseAuth.getInstance().removeAuthStateListener(this);
    }

    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        Transformations.switchMap(this, user ->  setValue(ref.document(firebaseAuth.getUid()).));


    }
}
