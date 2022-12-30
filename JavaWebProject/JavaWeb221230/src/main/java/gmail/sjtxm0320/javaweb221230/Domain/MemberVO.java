package gmail.sjtxm0320.javaweb221230.Domain;

public class MemberVO {
    private String mid;
    private String mpw;
    private String mname;

    public MemberVO(String mid, String mpw, String mname) {
        this.mid = mid;
        this.mpw = mpw;
        this.mname = mname;
    }

    public MemberVO() {
        super();
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMpw() {
        return mpw;
    }

    public void setMpw(String mpw) {
        this.mpw = mpw;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    @Override
    public String toString() {
        return "MemberVO{" +
            "mid='" + mid + '\'' +
            ", mpw='" + mpw + '\'' +
            ", mname='" + mname + '\'' +
            '}';
    }
}
