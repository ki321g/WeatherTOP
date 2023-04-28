package controllers;

import models.Member;
import play.Logger;
import play.mvc.Controller;

import java.util.HashMap;

public class Accounts extends Controller
{
  public static void signup()
  {
    Logger.info("Rendering Signup");
    render("signup.html");
  }

  public static void login()
  {
    Logger.info("Rendering Login");
    render("login.html");
  }
  public static void profile()
  {
    Logger.info("Rendering Profile");
    Member member = Accounts.getLoggedInMember();
    render("profile.html", member);
  }

  public static void register(String firstname, String lastname, String email, String password)
  {
    Logger.info("Registering new user " + email);
    Member member = new Member(firstname, lastname, email, password);
    member.save();
    redirect("/login");
  }

  public static void authenticate(String email, String password)
  {
    Logger.info("Attempting to authenticate with " + email + ":" + password);

    Member member = Member.findByEmail(email);
    if ((member != null) && (member.checkPassword(password) == true)) {
      Logger.info("Authentication Successful");
      session.put("logged_in_Memberid", member.id);
      redirect ("/dashboard");
    } else {
      Logger.info("Authentication failed");
      String loginFail = "Authentication failed, please try again!";
      render("/login.html", loginFail);
    }
  }

  public static void logout()
  {
    Logger.info("Logging User Out");
    session.clear();
    redirect ("/");
  }

  public static Member getLoggedInMember()
  {
    Member member = null;
    if (session.contains("logged_in_Memberid")) {
      String memberId = session.get("logged_in_Memberid");
      member = Member.findById(Long.parseLong(memberId));
    } else {
      login();
    }
    return member;
  }

  public static void update(String firstname, String lastname, String email, String password) {
    Logger.info("updating user details");
    getLoggedInMember().firstname = firstname;
    getLoggedInMember().lastname = lastname;
    getLoggedInMember().email = email;
    getLoggedInMember().password = password;
    getLoggedInMember().save();
    String updateSuccess = "Profile Updated Successfully!";
    Member member = Accounts.getLoggedInMember();
    render("/profile.html",member, updateSuccess);
  }
}