public class Member {
    private String memberName;
    private String memberID;

    public Member (String memberName, String memberID) {
        this.memberName = memberName;
        this.memberID = memberID;
    }

    // Getters
    public String getMemberName () {
        return memberName;
    }

    public String getMemberID () {
        return memberID;
    }

    // Setters
    public void setMemberName (String memberName) {
        this.memberName = memberName;
    }

    public void setMemberID (String memberID) {
        this.memberID = memberID;
    }

    @Override
    public String toString () {
        return memberName + " (ID: )" + memberID + " )";
    }
 }
