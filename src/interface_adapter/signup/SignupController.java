package interface_adapter.signup;

import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

public class SignupController {
    final SignupInputBoundary userSignupUseCaseInteractor;
    public SignupController(SignupInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    public void execute(String username, String password1, String password2,
                      String email, String phoneNumber, String city) {
        SignupInputData signupInputData = new SignupInputData(
                username, password1, password2,
                email, phoneNumber, city);

        userSignupUseCaseInteractor.execute(signupInputData);
    }
}
