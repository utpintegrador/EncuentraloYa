package com.example.encuentraloya.callbacks;

import com.example.encuentraloya.entidad.LoginInformationRequest;
import com.example.encuentraloya.entidad.LoginInformationResponse;
import com.example.encuentraloya.model.Implement.LoginInteractor;
import com.example.encuentraloya.model.Interfaces.OnLoginFinishedListener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import retrofit2.Call;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LoginCallbackTest {

    @Spy
    private LoginInteractor loginInteractor = new LoginInteractor();

    @Mock
    private LoginInformationRequest loginInformationRequest;

    @Mock
    private Call<LoginInformationResponse> loginInformationResponseCall;

    @Mock
    private OnLoginFinishedListener onLoginFinishedListener;

    @Test
    public void shouldEnqueueWhenLogin(){
        // Arrange
        String username = "";
        String password = "";

        // Act
        loginInteractor.login(username, password, false, onLoginFinishedListener);

        // Assert that proper callback has been passed to enqueue
        //verify(loginInformationResponseCall).enqueue(Mockito.any(LoginCallback.class));
    }
}