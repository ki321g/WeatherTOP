package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This model class is used for Members
 *
 * @author Kieron GArvey
 * @version 0.1
 */
@Entity
public class Member extends Model {
  public String firstname;
  public String lastname;
  public String email;
  public String password;

  @OneToMany(cascade = CascadeType.ALL)
  public List<Station> stations = new ArrayList<Station>();

  /**
   * Member() - This constructor creates the new member
   *
   * @param firstname Member firstname
   * @param lastname Member lastname
   * @param email Member email
   * @param password Member password
   */
  public Member(String firstname, String lastname, String email, String password) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.password = password;
  }

  /**
   * findByEmail() - This method finds the member by email
   *
   * @param email Member email
   * @return Members email
   */
  public static Member findByEmail(String email) {
    return find("email", email.toLowerCase()).first();
  }

  /**
   * checkPassword() - This method checks the members password
   *
   * @param password Member password
   * @return Members password
   */
  public boolean checkPassword(String password) {return this.password.equals(password);}


  /**
   * getMemberDetails() - This method returns members details
   *
   * Method uses the passed in params to find the relevant members
   * details and then returns them
   *
   * @param returnType Member password
   * @param memberID Member password
   * @return Members password
   */
  public String getMemberDetails(String returnType, int memberID) {
    HashMap<String, String> memberDetails = new HashMap<String, String>();

    memberDetails.put("firstname", firstname);
    memberDetails.put("lastname", lastname);
    memberDetails.put("email", email);

    String returnMemberDetail = memberDetails.get(returnType);

    return returnMemberDetail;
  }
}