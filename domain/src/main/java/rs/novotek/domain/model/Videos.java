
package rs.novotek.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Videos implements Serializable, Parcelable
{

    @SerializedName("results")
    @Expose
    private List<Result> results = new ArrayList<Result>();
    public final static Parcelable.Creator<Videos> CREATOR = new Creator<Videos>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Videos createFromParcel(Parcel in) {
            return new Videos(in);
        }

        public Videos[] newArray(int size) {
            return (new Videos[size]);
        }

    }
    ;
    private final static long serialVersionUID = 5074388837122918788L;

    protected Videos(Parcel in) {
        in.readList(this.results, (rs.novotek.domain.model.Result.class.getClassLoader()));
    }

    public Videos() {
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Videos withResults(List<Result> results) {
        this.results = results;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("results", results).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(results);
    }

    public int describeContents() {
        return  0;
    }

}
