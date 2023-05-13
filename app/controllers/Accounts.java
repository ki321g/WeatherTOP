package controllers;

import models.Member;
import play.Logger;
import play.mvc.Controller;

/**
 * This class handles user Accounts
 *
 * @author Kieron GArvey
 * @version 0.1
 */
public class Accounts extends Controller {

  /**
   * signup() - This method renders signup.html
   *
   */
  public static void signup() {
    Logger.info("Rendering Signup");
    render("signup.html");
  }

  /**
   * login() - This method renders login.html
   *
   */
  public static void login() {
    Logger.info("Rendering Login");
    render("login.html");
  }

  /**
   * profile() - This method renders profile.html
   * Method gets the logged in member and passes
   * the member details to the profile.html
   *
   */
  public static void profile() {
    Logger.info("Rendering Profile");
    Member member = Accounts.getLoggedInMember();
    render("profile.html", member);
  }

  /**
   * register() - This method renders register.html
   * Method checks if the email already exists and
   * that the password length is over 7.
   *
   * If all checks are ok the method redirects to the login page
   * If there is an issue the method renders the singup.html passing
   * signupFail to it to display the fail reason.
   *
   * @param firstname New Member First Name
   * @param lastname New Member Last Name
   * @param email New Member eMail
   * @param password New Member Password
   */
public static void register(String firstname, String lastname, String email, String password) {
  Logger.info("Registering new user " + email.toLowerCase());
  Member memberCheck = Member.findByEmail(email.toLowerCase());
  if(memberCheck == null && password.length() >= 7) {
    Member member = new Member(firstname, lastname, email.toLowerCase(), password);
    member.save();
    redirect("/login");
  } else if(password.length() >= 7)  {
    Logger.info("Email Already Used");
    String signupFail = "Signup failed, Email Already In Use!";
    render("signup.html", signupFail);
  }else if(password.length() < 7)  {
    Logger.info("Password To Short");
    String signupFail = "Signup failed, Password has to be greater than 7 characters!";
    render("signup.html", signupFail);
  }
}

  /**
   * authenticate() - Used during login to check User details
   * Method find the member with the email and checks if
   * the password is correct.
   *
   * Redireted to Dashboard if all is OK
   * Render Login with error if there is an issue
   *
   * @param email New Member eMail
   * @param password New Member Password
   */
  public static void authenticate(String email, String password) {
    Logger.info("Attempting to authenticate with " + email + ":" + password);

    Member member = Member.findByEmail(email.toLowerCase());
    if ((member != null) && member.checkPassword(password)) {
      Logger.info("Authentication Successful");
      session.put("logged_in_Memberid", member.id);
      redirect("/dashboard");
    } else if (member == null) {
      Logger.info("Authentication failed");
      String loginFail = "Authentication failed, Email entered is not a current member, please register!";
      render("/login.html", loginFail);
    } else if (!member.checkPassword(password)) {
      Logger.info("Authentication failed");
      String loginFail = "Authentication failed, Wrong Password!";
      render("/login.html", loginFail);
    } else {
      Logger.info("Authentication failed");
      String loginFail = "Authentication failed, please try again!";
      render("/login.html", loginFail);
    }
  }

  /**
   * logout() - This method logs user out by clearing the session
   *
   */
  public static void logout() {
    Logger.info("Logging User Out");
    session.clear();
    redirect("/");
  }

  /**
   * getLoggedInMember() - This method gets teh logged in member
   *
   * @return logged in member
   */
  public static Member getLoggedInMember() {
    Member member = null;
    if (session.contains("logged_in_Memberid")) {
      String memberId = session.get("logged_in_Memberid");
      member = Member.findById(Long.parseLong(memberId));
    } else {
      login();
    }
    return member;
  }

  /**
   * update() -
   * Method updates the member and renders profile.html
   * passes the member and update success message back to
   * the profile.html page
   *
   * @param firstname New Member First Name
   * @param lastname New Member Last Name
   * @param email New Member eMail
   * @param password New Member Password
   */
  public static void update(String firstname, String lastname, String email, String password) {
    Logger.info("User details Udated " );
    getLoggedInMember().firstname = firstname;
    getLoggedInMember().lastname = lastname;
    // getLoggedInMember().email = email;
    getLoggedInMember().password = password;
    getLoggedInMember().save();
    String updateSuccess = "Profile Updated Successfully!";
    Member member = Accounts.getLoggedInMember();
    render("/profile.html", member, updateSuccess);
  }
}