/**
 * Name: Michael Miralles
 * Date: July 18, 2025
 * Description: This class represents a library member.
 *              includes constructors, getters, setters, and a toString method.
 */

public class Member {
    private String memberName;
    private String memberID;

    // Default Constructor
    public Member() {
        this.memberName = "";
        this.memberID = "";
    }

    // Cunstroctor that creats a member with a name and ID
    public Member(String memberName, String memberID) {
        this.memberName = memberName;
        this.memberID = memberID;
    }

    // Getters
    public String getMemberName() {
        return memberName;
    }

    public String getMemberID() {
        return memberID;
    }

    // Setters
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    // Returns string showing the member details
    @Override
    public String toString() {
        return memberName + " (ID: " + memberID + " )";
    }
 }
